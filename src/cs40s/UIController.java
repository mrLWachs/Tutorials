
/** Required package class namespace */
package cs40s;

/** Required imports */
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import cs40s.collections.LinkedList;
import cs40s.io.Dialogs;
import cs40s.io.FileHandler;
import cs40s.tools.Images;

 
/**
 * UIController.java - this is a class that "controls" the main user 
 * interface logic. By separating this logic from the user interfaces visual 
 * (or "view") we are following a pattern like the "MVC" software design 
 * pattern which is commonly used for developing user interfaces which divides 
 * the related program logic. This is done to separate internal representations 
 * of information from the ways information is presented to and accepted from 
 * the user. This is one style of programming paradigm that is expanded on in 
 * post secondary studies in Computer Science (but is not necessary for I.B. or
 * high school Computer Science in general).
 *
 * @author Mr. Wachs
 * @since December, 2020
 */
public class UIController 
{

    // properties linked from the view 
    private JLabel     memeImageLabel;      // label for pictures
    private JTextField keywordTextbox;      // textbox to enter a keyword
    private List       keywordsList;        // listbox for all entered keywords
    private List       memesList;           // listbox for all entered memes
    private UIView     userInterface;       // the frame user interface
    
    // properties for use when one meme is created
    private File               file     = null;     // stores the a file object
    private String             keyword  = null;     // stores a keyword
    private Meme               meme     = null;     // a meme object
    private LinkedList<String> keywords = null;     // stores all keywords
    
    // property to store all memes in a dynamic list
    private LinkedList<Meme> allMemes = new LinkedList<>();
    
    // properties for functions like searching, sorting, dialogs, files, etc.
    private Dialogs dialog = new Dialogs("Meme database",userInterface);
    private FileHandler<LinkedList<Meme>> fileHandler = new FileHandler<>(dialog);
    
    /**
     * Class constructor, set class properties
     * 
     * @param memeImageLabel label for pictures
     * @param keywordTextbox text box to enter a keyword
     * @param keywordsList list box for all entered keywords
     * @param memesList list box for all entered memes
     * @param userInterface the frame user interface
     */
    public UIController(
            JLabel     memeImageLabel, 
            JTextField keywordTextbox, 
            List       keywordsList, 
            List       memesList, 
            UIView     userInterface) {
        // connect (link) all parameters to global properties
        this.memeImageLabel     = memeImageLabel;
        this.keywordTextbox     = keywordTextbox;
        this.keywordsList       = keywordsList;
        this.memesList          = memesList; 
        this.userInterface      = userInterface;
        // set some values for the user interface and display        
        userInterface.setSize(835,745);                 // set size
        userInterface.setTitle("Meme Database");        // set title
        userInterface.setResizable(false);              // no resizing
        userInterface.setLocationRelativeTo(null);      // center on screen
        userInterface.setVisible(true);                 // display frame
    }
    
    /**
     * User has clicked a button and wants to select a meme image from a file
     */
    public void selectMemeImageFromFile() {
        file = dialog.openFile(userInterface);      // Get file from open dialog 
        if (file != null) {
            String path = file.getAbsolutePath();   // Get path to the file
            meme = new Meme(path, Meme.IS_FROM_FILE);
            showImage();
        }
    }

    /**
     * 
     */
    public void selectMemeImageFromInternet() {
        String path = dialog.input("Copy and Paste the internet path "
                    + "to the image in the box below...");
        meme = new Meme(path, Meme.IS_FROM_NET);
        showImage();
    }

    /**
     * User has clicked a button to enter a keyword into the list of keywords
     */
    public void enterMemeKeyword() {
        keyword = keywordTextbox.getText();             // get text from textbox
        if (keyword != null && !keyword.equals("")) {       // valid text
            if (keywords == null || keywords.isEmpty()) {   // list is empty
                keywords = new LinkedList<>();              // create list
            }
            keywords.add(keyword);                      // add to list
            keywordsList.add(keyword);                  // add to listbox
            keywordTextbox.setText("");                 // set textbox empty
            keywordTextbox.requestFocus();              // set focus to textbox
            keyword = null;                             // set property to null
        }
    }

    /**
     * User has clicked a button to delete the keyword selected in the listbox
     */
    public void deleteSelectedKeyword() {
        int index = keywordsList.getSelectedIndex();    // index selected
        if (index != -1) {                              // valid index
            if (dialog.yesNo("Are you sure you want to "
                           + "delete the selected keyword?")) { // confirm
                keywordsList.remove(index);             // remove from listbox
                if (keywords != null) keywords.remove(index);   // and from list
            }
        }
    }

    /**
     * User has clicked a button to clear all the fields for making a new 
     * meme (to start over)
     */
    public void clearFields() {
        memeImageLabel.setIcon(null);       // remove any image from label
        keywordTextbox.setText("");
        keywordsList.removeAll();           // clear out the listbox
        file = null;
        meme = null;
        if (keywords != null) {             // clear and set list to null
            keywords.clear();
            keywords = null;
        }
    }

    /**
     * User has clicked a button to save all meme information into the meme list
     */
    public void saveMeme() {
        if (meme != null) {
            
            System.out.println("saving meme... keywords: " + keywords.toString());
            
            meme.add(keywords);
            allMemes.add(meme);                         // add meme to list
            memesList.add(meme.toString());         // add meme to listbox
            clearFields();                          // clear all fields
        }
        else {
            dialog.output("Please select an image file!");  // dialog to user
            memeImageLabel.requestFocus();          // set focus to textbox
        }
    }

    /**
     * User has clicked a button to delete the meme selected in the listbox
     */
    public void deleteSelectedMeme() {
        int index = memesList.getSelectedIndex();       // index selected
        if (index != -1) {                              // index is valid
            if (dialog.yesNo("Are you sure you want to "
                           + "delete the selected meme?")) {    // confirm
                memesList.remove(index);                // remove from listbox
                allMemes.remove(index);                     // remove from list
            }
        }
    }

    /**
     * User has clicked a button to search all memes in the list for a keyword
     */
    public void searchMemes() {
        String searchText = dialog.input("Enter word to search for");   // word
        searchText = searchText.toLowerCase();      // convert to lowercase
        int index = -1;                             // assume not found
        for (int i = 0; i < allMemes.size(); i++) {     // traverse list
            meme = allMemes.get(i);                     // get a meme from list
            String words = meme.toString();         // convert meme to string
            words = words.toLowerCase();            // convert to lowercase
            if (words.contains(searchText)) {       // see if word is in text
                index = i;                          // meme location found
                i = allMemes.size();                    // exit loop
            }
        }
        if (index != -1) {
            memesList.select(index);            // select found in listbox
            clickOnMemeList();
        }   
        else {
            dialog.output(searchText + " not found!");      // prompt
        }         
    }

    /**
     * User has clicked a button to open a memes list from a permanent file
     */
    public void openMemeList() {
        file = dialog.openFile(userInterface);  // dialog and file to open list
        if (file != null) {                     // valid file chosen
            allMemes = (LinkedList<Meme>)fileHandler.openObject(file);  // get list
            if (allMemes != null) {                 // valid list
                memesList.removeAll();          // clear out listbox
                for (int i = 0; i < allMemes.size(); i++) {     // traverse list
                    meme = allMemes.get(i);              // get meme
                    String text = meme.toString();          // convert to text
                    memesList.add(text);                    // add to listbox
                }
            }
        }
    }

    /**
     * User has clicked a button to save the memes list to a permanent file
     */
    public void saveMemeList() {
        file = dialog.saveFile(userInterface);  // dialog and save list to file
        if (file != null && allMemes != null) fileHandler.saveObject(allMemes, file);
    }

    /**
     * 
     */
    public void clickOnMemeList() {
        int index = memesList.getSelectedIndex();
        meme = allMemes.get(index);
        if (meme != null) {
            keywordsList.removeAll();
            keywords = meme.keywords;
            for (int i = 0; i < keywords.size(); i++) {
                String word = keywords.get(i);
                keywordsList.add(word);
            }
            showImage();
        }
    }
    
    /**
     * 
     */
    private void showImage() {
        if (meme == null) return;
        try {
            Icon icon = null;
            if (meme.type == Meme.IS_FROM_FILE) {
                icon = new ImageIcon(meme.path);      // Create icon to display
            }
            else if (meme.type == Meme.IS_FROM_NET) {   
                URL           url   = new URL(meme.path);
                BufferedImage image = ImageIO.read(url);
                icon = new ImageIcon(image);      // Create icon to display
            }
            memeImageLabel.setIcon(icon);           // Assign icon to label
            Images.resizeToContainer(memeImageLabel);   // Resize to label
        } 
        catch(MalformedURLException error) {
            dialog.output("Sorry cannot load that image!");
        }
        catch (IOException error) {
            dialog.output("Sorry cannot load that image!");
        }
    }
    
}
