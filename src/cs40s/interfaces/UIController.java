/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * This class 
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "Meme.java" class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.interfaces;

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

    // Properties linked from the view 
    private JLabel     memeImageLabel;      // Label for pictures
    private JTextField keywordTextbox;      // Textbox to enter a keyword
    private List       keywordsList;        // Listbox for all entered keywords
    private List       memesList;           // Listbox for all entered memes
    private UIView     userInterface;       // The frame user interface
    
    // Properties for use when one meme is created
    private File               file     = null;     // Stores the a file object
    private String             keyword  = null;     // Stores a keyword
    private Meme               meme     = null;     // A meme object
    private LinkedList<String> keywords = null;     // Stores all keywords
    
    // Property to store all memes in a dynamic list
    private LinkedList<Meme> allMemes = new LinkedList<>();
    
    // Properties for functions like searching, sorting, dialogs, files, etc.
    private Dialogs dialogs = new Dialogs("Meme database",userInterface);
    private FileHandler<LinkedList<Meme>> fileHandler = new FileHandler<>(dialogs);
    
    /**
     * Class constructor, set class properties
     * 
     * @param memeImageLabel label for pictures
     * @param keywordTextbox text box to enter a keyword
     * @param keywordsList list box for all entered keywords
     * @param memesList list box for all entered memes
     * @param userInterface the frame user interface
     */
    public UIController(JLabel memeImageLabel, JTextField keywordTextbox, 
            List keywordsList, List memesList, UIView userInterface) {
        // Connect (link) all parameters to global properties
        this.memeImageLabel     = memeImageLabel;
        this.keywordTextbox     = keywordTextbox;
        this.keywordsList       = keywordsList;
        this.memesList          = memesList; 
        this.userInterface      = userInterface;
        // Set some values for the user interface and display        
        userInterface.setSize(835,745);                 // Set size
        userInterface.setTitle("Meme Database");        // Set title
        userInterface.setResizable(false);              // No resizing
        userInterface.setLocationRelativeTo(null);      // Center on screen
        userInterface.setVisible(true);                 // Display frame
    }
    
    /**
     * User has clicked a button and wants to select a meme image from a file
     */
    public void selectMemeImageFromFile() {
        file = dialogs.openFile(userInterface);     // Get file from open dialog 
        if (file != null) {                             // File is valid
            String path = file.getAbsolutePath();       // Get path to the file
            meme = new Meme(path, Meme.IS_FROM_FILE);   // Create Meme object
            showImage();                                // Show the meme image
        }
    }

    /**
     * User has clicked a button and wants to select a meme image from internet
     */
    public void selectMemeImageFromInternet() {
        String path = dialogs.input("Copy and Paste the internet path "
                    + "to the image in the box below...");  // Get URL from user
        meme = new Meme(path, Meme.IS_FROM_NET);            // Create Meme
        showImage();                                        // Show meme image
    }

    /**
     * User has clicked a button to enter a keyword into the list of keywords
     */
    public void enterMemeKeyword() {
        keyword = keywordTextbox.getText();             // Get text from textbox
        if (keyword != null && !keyword.equals("")) {       // Valid text
            if (keywords == null || keywords.isEmpty()) {   // List is empty
                keywords = new LinkedList<>();              // Create list
            }
            keywords.add(keyword);                      // Add to list
            keywordsList.add(keyword);                  // Add to listbox
            keywordTextbox.setText("");                 // Set textbox empty
            keywordTextbox.requestFocus();              // Set focus to textbox
            keyword = null;                             // Set property to null
        }
    }

    /**
     * User has clicked a button to delete the keyword selected in the list box
     */
    public void deleteSelectedKeyword() {
        int index = keywordsList.getSelectedIndex();    // Index selected
        if (index != -1) {                              // Valid index
            if (dialogs.yesNo("Are you sure you want to "
                           + "delete the selected keyword?")) { // Confirm
                keywordsList.remove(index);             // Remove from listbox
                if (keywords != null) keywords.remove(index);   // And from list
            }
        }
    }

    /**
     * User has clicked a button to clear all the fields for making a new 
     * meme (to start over)
     */
    public void clearFields() {
        memeImageLabel.setIcon(null);       // Remove any image from label
        keywordTextbox.setText("");         // Remove text from textbox
        keywordsList.removeAll();           // Clear out the listbox
        file = null;                        // Set global to null
        meme = null;                        // Set meme to null
        if (keywords != null) {             // Clear and set list to null
            keywords.clear();               // Clear linked list
            keywords = null;                // Set to null
        }
    }

    /**
     * User has clicked a button to save all meme information into the meme list
     */
    public void saveMeme() {
        if (meme != null) {                             // Meme is valid
            meme.add(keywords);                         // Add words to meme
            allMemes.add(meme);                         // Add meme to list
            memesList.add(meme.toString());             // Add meme to listbox
            clearFields();                              // Clear all fields
        }
        else {                                          // No meme created
            dialogs.output("Please select an image file!");  // Dialog to user
            memeImageLabel.requestFocus();              // Set focus to textbox
        }
    }

    /**
     * User has clicked a button to delete the meme selected in the list box
     */
    public void deleteSelectedMeme() {
        int index = memesList.getSelectedIndex();       // Index selected
        if (index != -1) {                              // Index is valid
            if (dialogs.yesNo("Are you sure you want to "
                           + "delete the selected meme?")) {    // Confirm
                memesList.remove(index);                // Remove from listbox
                allMemes.remove(index);                 // Remove from list
            }
        }
    }

    /**
     * User has clicked a button to search all memes in the list for a keyword
     */
    public void searchMemes() {
        String searchText = dialogs.input("Enter word to search for");  // Word
        searchText = searchText.toLowerCase();      // Convert to lowercase
        int index = -1;                             // Assume not found
        for (int i = 0; i < allMemes.size(); i++) { // Traverse list
            meme = allMemes.get(i);                 // Get a meme from list
            String words = meme.toString();         // Convert meme to string
            words = words.toLowerCase();            // Convert to lowercase
            if (words.contains(searchText)) {       // See if word is in text
                index = i;                          // Meme location found
                i = allMemes.size();                // Exit loop
            }
        }               
        if (index != -1) {                          // Valid index selected
            memesList.select(index);                // Select found in listbox
            clickOnMemeList();                      // Click on that meme
        }   
        else {                                      // Not a valid index
            dialogs.output(searchText + " not found!");      // Prompt user
        }         
    }

    /**
     * User has clicked a button to open a memes list from a permanent file
     */
    public void openMemeList() {
        file = dialogs.openFile(userInterface);  // Dialog and file to open list
        if (file != null) {                     // Valid file chosen
            allMemes = (LinkedList<Meme>)fileHandler.openObject(file);  // Get
            if (allMemes != null) {                         // Valid list
                memesList.removeAll();                      // Clear out listbox
                for (int i = 0; i < allMemes.size(); i++) { // Traverse list
                    meme = allMemes.get(i);                 // Get meme
                    String text = meme.toString();          // Convert to text
                    memesList.add(text);                    // Add to listbox
                }
            }
        }
    }

    /**
     * User has clicked a button to save the memes list to a permanent file
     */
    public void saveMemeList() {
        file = dialogs.saveFile(userInterface);  // Dialog and save list to file
        if (file != null && allMemes != null) {     // Check all is valid
            fileHandler.saveObject(allMemes, file); // Save all memes to file
        }
    }

    /**
     * User has clicked on a meme in the list box, display this meme and its
     * image
     */
    public void clickOnMemeList() {
        int index = memesList.getSelectedIndex();       // Get the user index
        meme = allMemes.get(index);                     // Get meme from list 
        if (meme != null) {                             // Meme is valid
            keywordsList.removeAll();                   // Clear keyword list
            keywords = meme.keywords;                   // Get list from meme
            for (int i = 0; i < keywords.size(); i++) { // Traverse keywords
                String word = keywords.get(i);          // Get a word
                keywordsList.add(word);                 // Add to list box
            }
            showImage();                                // Show meme image
        }
    }
    
    /**
     * Utility method shows the image from the meme in the label
     */
    private void showImage() {
        if (meme == null) return;                       // Check meme is valid
        try {                                           // Error trap
            Icon icon = null;                           // Reset icon
            if (meme.type == Meme.IS_FROM_FILE) {       // File image
                icon = new ImageIcon(meme.path);        // Create icon
            }
            else if (meme.type == Meme.IS_FROM_NET) {   // URL image   
                URL url = new URL(meme.path);           // Get path from meme
                BufferedImage image = ImageIO.read(url);    // Create image
                icon = new ImageIcon(image);            // Create icon 
            }
            memeImageLabel.setIcon(icon);               // Assign icon to label
            Images.resizeToContainer(memeImageLabel);   // Resize to label
        } 
        catch(MalformedURLException error) {            // Error trap for URL
            dialogs.output("Sorry cannot load that image!");
        }
        catch (IOException error) {                     // Error trap for file
            dialogs.output("Sorry cannot load that image!");
        }
    }
    
}
