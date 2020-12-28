/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * This class is a custom class to represent a Meme object. It has properties
 * to store which one of two types of meme it is (from a saved image file or 
 * directly from a URL on the internet). It also stores the path to the image
 * and a list (a dynamic linked list collection) of all the keywords the 
 * user gave for this meme. The class signature line uses "implements 
 * Serializable" which follows the rules of an interface that it imported so 
 * that the meme can eventually be saved to a permanent file. The class also
 * uses two static constants which are used outside the class. For methods, 
 * it has a constructor, an add() method which adds the keywords, and it 
 * overloads the toString() method of the Object class.
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "Dialogs.java" class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.interfaces;

/** Required imports */
import java.io.Serializable;
import cs40s.collections.LinkedList;
 

/**
 * Meme.java - represents an internet "meme" which is an image (usually funny) 
 * and also which type (it came from an image file or off the internet), and 
 * any keywords that describe the meme
 *
 * @author Mr. Wachs
 * @since December, 2020
 */
public class Meme implements Serializable
{
    
    /** This Meme is from a file */
    public static int IS_FROM_FILE = 0;
    /** This Meme is from the internet */
    public static int IS_FROM_NET = 1;           
    /** Path to the meme (either the file path or the URL path) */
    public String path;
    /** Which type of meme (from a file or from a URL) */
    public int type;
    /** Dynamic list of keywords */
    public LinkedList<String> keywords;

    
    /**
     * Class constructor, set class properties
     * 
     * @param path the path to the image itself
     * @param type did the meme come from a file or the net?
     */
    public Meme(String path, int type) {
        this.path = path;               // Assign parameters to class properties
        this.type = type;
    }
    
    /**
     * Adds the keywords to this meme
     * 
     * @param keywords dynamic list of keywords
     */
    public void add(LinkedList<String> keywords) {
        if (keywords != null) {                 // Valid list of keywords
            this.keywords = new LinkedList<>();              // Instantiate list
            for (int i = 0; i < keywords.size(); i++) { // Traverse list
                this.keywords.add(keywords.get(i));     // Assign to property
            }
        } 
    }
        
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        String text = "Meme";                           // Create text
        if (keywords == null || keywords.isEmpty()) {   // List is empty
            text += " no keywords";                     // Inform user
        }
        else {                                          // List is valid
            text += " keywords = ";                         // Add to text
            for (int i = 0; i < keywords.size()-1; i++) {   // Traverse list
                text += keywords.get(i) + ", ";             // Add word to text
            }
            text += keywords.get(keywords.size()-1);        // Add last word
        }
        if (type == IS_FROM_FILE) text += " from file: " + path;    // Add type
        if (type == IS_FROM_NET)  text += " from URL: "  + path;
        return text;                                    // Return filled text
    }

}