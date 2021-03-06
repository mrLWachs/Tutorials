
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
