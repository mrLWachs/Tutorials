
/** Required package class namespace */
package cs40s;

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
    
    public static int IS_FROM_FILE = 0;         // Meme is from a file
    public static int IS_FROM_NET = 1;          // Meme is from the internet
           
    public String path;                         // Path to the meme
    public int type;                            // Which type of meme
    public LinkedList<String> keywords;         // Dynamic list of keywords

    
    /**
     * Class constructor, set class properties
     * 
     * @param path the path to the image itself
     * @param type did the meme come from a file or the net?
     */
    public Meme(String path, int type) {
        this.path = path;               // Assign parameter to class property
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
        if (keywords == null || keywords.isEmpty()) {
            text += " no keywords";
        }
        else {                                  // Continue filling from list
            text += " keywords = ";
            for (int i = 0; i < keywords.size()-1; i++) {
                text += keywords.get(i) + ", ";
            }
            text += keywords.get(keywords.size()-1);
        }
        if (type == IS_FROM_FILE) text += " from file: " + path;
        if (type == IS_FROM_NET)  text += " from URL: " + path;
        return text;                                    // Return filled text
    }

}