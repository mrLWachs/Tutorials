/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * This class is a version of the same class found on our class "Help" page:
 * https://mrwachs.wordpress.com/current-classes/computer-science-40s/help-cs40s
 * Which is used to have available methods for creating dialogs for the user
 * as versions of JOptionPane dialogs. It includes a lot of customization
 * features like fonts, colors, etc. The methods can be used for inputs, 
 * outputs, and things like getting file names from the user.
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "Images.java" class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.io;

/** Required imports */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import cs40s.tools.Numbers;


/**
 * Dialogs.java - a collection of useful methods for working with dialogs
 *
 * @author Mr. Wachs
 * @since December, 2020
 */
public class Dialogs
{

    private static final Font      DEFAULT_FONT             = new 
        javax.swing.JOptionPane().getFont();
    private static final Color     DEFAULT_BACKGROUND_COLOR = new 
        javax.swing.JOptionPane().getBackground();
    private static final Color     DEFAULT_FOREGROUND_COLOR = new 
        javax.swing.JOptionPane().getForeground();
    private static final String    DEFAULT_TITLE            = "";
    private static final Component DEFAULT_COMPONENT        = null;
    private static final ImageIcon DEFAULT_ICON             = null;
    private static final int       DEFAULT_TYPE             = 
            javax.swing.JOptionPane.PLAIN_MESSAGE;
    private static final int       DEFAULT_OPTION_TYPE      = 
            javax.swing.JOptionPane.YES_NO_OPTION;
    private final String           ERROR                    = 
            "Error, please enter again\n\n"; 
       
    private JTextArea area;
    private Numbers   numbers;

    /** Font used for displaying in the dialogs */
    public Font font;
    /** Background color used for displaying in the dialogs */
    public Color background;
    /** Foreground (text) color used for displaying in the dialogs */
    public Color foreground;
    /** Top dialog title used */
    public String title;
    /** Frame or other component the dialog parents (centers) with */
    public Component parent;
    /** Type of icon used in the dialogs */
    public int messageType;
    /** Type of button options used in the dialogs */
    public int optionType;
    /** Custom icon (image) used in the dialogs */
    public Icon icon;

    
    /**
     * Default class constructor sets class properties
     */
    public Dialogs() {
        defaults();                                 // Set all default values
        init();                                     // Inititalize the class
    }
    
    /**
     * Class constructor sets class properties
     *
     * @param title The title used on any dialog in the class
     */
    public Dialogs(String title) {
        defaults();                             // Set all default values
        this.title = title;                     // Set the title of all dialogs
        init();                                 // Inititalize the class
    }

    /**
     * Class constructor sets class properties
     *
     * @param title The title used on any dialog in the class
     * @param parent the component to parent the dialogs to
     */
    public Dialogs(String title, Component parent) {
        defaults();                         // Set all default values
        this.title  = title;                // Set the title of all dialogs
        this.parent = parent;               // Set the parent UI of all dialogs
        init();                             // Inititalize the class
    }

    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent the component to parent the dialogs to
     * @param font font used in dialogs
     */
    public Dialogs(String title, Component parent, Font font) {
        defaults();                         // Set all default values
        this.font  = font;                  // Set the font of all dialogs
        this.title = title;                 // Set the title of all dialogs
        init();                             // Inititalize the class
    }
    
    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent the component to parent the dialogs to
     * @param font font used in dialogs
     * @param background background color used in dialogs
     * @param foreground foreground (text) color used in dialogs
     */
    public Dialogs(String title, Component parent, Font font, Color background, 
                   Color foreground) {
        defaults();                         // Set all default values
        this.font       = font;             // Set the font of all dialogs
        this.background = background;       // Set background color of dialogs
        this.foreground = foreground;       // Set foreground color of dialogs
        this.title      = title;            // Set the title of all dialogs
        init();                             // Inititalize the class
    }

    /**
     * Class constructor sets passed properties
     * 
     * @param title top dialog title used
     * @param parent frame the dialog parents (centers) with
     * @param font font used in dialogs 
     * @param background background color used in dialogs
     * @param foreground foreground (text) color used in dialogs 
     * @param messageType type of icon used in the dialogs
     * @param icon custom icon (image) used in the dialogs
     */
    public Dialogs(String title, Component parent, Font font, Color background,
                   Color foreground, int messageType, Icon icon) {
        defaults();                         // Set all default values
        this.parent      = parent;          // Set the parent UI of all dialogs
        this.messageType = messageType;     // Set type of message of dialogs
        this.icon        = icon;            // Set icon image of dialogs
        this.font        = font;            // Set the font of all dialogs
        this.background  = background;      // Set background color of dialogs
        this.foreground  = foreground;      // Set foreground color of dialogs
        this.title       = title;           // Set the title of all dialogs
        init();                             // Inititalize the class
    }

    /**
     * Sets the image icon for the dialog methods invoked
     * 
     * @param imageFilePath the name of the image to display
     */
    public void setImage(String imageFilePath) {
        this.icon = new ImageIcon(imageFilePath);   // Set property to new icon
    }
    
    /**
     * Outputs the passed text in a dialog
     *
     * @param text the text to display
     */
    public void output(String text) {
        area.setText(text);                     // Set the area text
        JOptionPane.showMessageDialog(parent, area, title, messageType, icon);
    }

    /**
     * Outputs the passed text in a dialog, and gets typed user input
     *
     * @param text the text to display
     * @return the text the user types in
     */
    public String input(String text) {
        area.setText(text);                     // Set the area text
        Object object = JOptionPane.showInputDialog(parent, area,
                title, messageType, icon, null, null);
        if (object == null) return null;        // Nothing inputted
        return object.toString();               // Convert to string
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public int inputInteger(String text) {
        String value = input(text);             // Get user text
        while (!numbers.isInteger(value)) {     // Confirm the text is integer
            value = input(ERROR + text);        // Error message, input again
        }
        return Integer.parseInt(value);         // Convert to integer and return
    }

    /**
     * Asks the user for a number (double) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public double inputDouble(String text) {
        String value = input(text);             // Get user text
        while (!numbers.isDouble(value)) {      // Confirm the text is double
            value = input(ERROR + text);        // Error message, input again
        }
        return Double.parseDouble(value);       // Convert to double and return    
    }

    /**
     * Ask the user a yes and no question, in a confirm dialog box
     * 
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    public boolean yesNo(String text) {
        area.setText(text);                     // Set the area text
        int response = JOptionPane.showConfirmDialog(parent, area, title,
                optionType, messageType, icon);
        if (response == JOptionPane.YES_OPTION) return true;
        else                                    return false;
    }

    /**
     * Outputs the passed text in a dialog and creates buttons with the text
     * from the choices on each for the user to click on
     * 
     * @param text the text to display
     * @param choices the text choices for each button
     * @return the text on which button the user clicked on
     */
    public String buttons(String text, String[] choices) {
        area.setText(text);                     // Set the area text
        int value = JOptionPane.showOptionDialog(parent, area, title, 
                optionType, messageType, icon, choices, choices[0]);
        return choices[value];
    }

    /**
     * Presents an input dialog with a drop down selection of options
     * 
     * @param text the text to show in the dialog
     * @param options the array of option to have in the drop down
     * @return the option they choose
     */
    public String choices(String text, String[] options) {
        area.setText(text);                     // Set the area text
        Object object = JOptionPane.showInputDialog(parent, area, title, 
                optionType, icon, options, options[0]);
        if (object == null)  return "";
        else                 return object.toString();
    }
    
    /**
     * Ask the user if they want to play again, in a dialog box
     * 
     * @return true (yes, play again), false (no)
     */
    public boolean playAgain() {
        final String PLAY_AGAIN = "Do you want to play again?";
        return yesNo(PLAY_AGAIN);
    }
    
    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(title);     // File dialog
        chooser.showOpenDialog(frame);                      // Show user
        return chooser.getSelectedFile();                   // Get file selected
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(title);     // File dialog
        chooser.showSaveDialog(frame);                      // Show user
        return chooser.getSelectedFile();                   // Get file selected
    }

    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(title);     // File dialog
        chooser.showOpenDialog(frame);                      // Show user
        return chooser.getSelectedFile();                   // Get file selected
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(title);     // File dialog
        chooser.showSaveDialog(frame);                      // Show user
        return chooser.getSelectedFile();                   // Get file selected
    }
    
    /**
     * Sets class properties to default values
     */
    private void defaults() {
        this.parent      = null;
        this.font        = DEFAULT_FONT;
        this.background  = DEFAULT_BACKGROUND_COLOR;
        this.foreground  = DEFAULT_FOREGROUND_COLOR;
        this.title       = DEFAULT_TITLE;
        this.parent      = DEFAULT_COMPONENT;
        this.messageType = DEFAULT_TYPE;
        this.optionType  = DEFAULT_OPTION_TYPE;
        this.icon        = DEFAULT_ICON;
        this.numbers     = new Numbers();
        this.area        = new JTextArea();
    }

    /**
     * Initializes the display objects
     */
    private void init() {
        area.setFont(font);
        area.setBackground(background);
        area.setForeground(foreground);  
    }
    
}