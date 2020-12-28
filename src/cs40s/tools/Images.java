/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * This class like many of the classes in this tutorial is a version of a 
 * similar class found on our class "Help" page, and is included to give you 
 * ideas and an exemplar for any of your own projects you might develop. The 
 * class currently only have one method to resize an image file to fit inside a 
 * JLabel on a design (similar to how a picture box in Visual Studio can do 
 * this). It has the potential to add more methods for working with images in 
 * the future.
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "Numbers.java" class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.tools;

/** Required imports */
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 
/**
 * Images.java - tools for working with images
 *
 * @author Mr. Wachs
 * @since December, 2020
 */
public class Images 
{

    /** 
     * Resizes the image inside the label to match the size of the label 
     * 
     * @param label the JLabel object to resize to
     */
    public static void resizeToContainer(JLabel label) {
        int       width         = label.getWidth();     // Get label width
        int       height        = label.getHeight();    // Get label height
        ImageIcon originalIcon  = (ImageIcon)label.getIcon();   // Get icon
        if (originalIcon == null) return;               // Error trap
        Image     originalImage = originalIcon.getImage();      // Get image
        Image     newImage      = originalImage.getScaledInstance(
                                          width,height,Image.SCALE_SMOOTH);
        Icon icon               = new ImageIcon(newImage);  // Set new image
        label.setIcon(icon);                            // Set icon to label
    }
    
}
