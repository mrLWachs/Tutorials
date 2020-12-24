
/** Required package class namespace */
package cs30s;

/** Required imports */
import java.awt.Color;
 
/**
 * Globals.java - classes can contain "properties" which are essentially 
 * "global variables" to that class - but can also be thought of as "things
 * about that class" (or "descriptors" or even "adjectives"). This class is 
 * using properties which are "global" to all the other classes in the project.
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class Globals 
{

    /**************************************************************************
     * NOTE... The code below creates global variables (constants). Using 
     * the keywords "public" and "static" mean these variables will be 
     * "shared" with all the other classes in the project. Keywords "public"
     * means it can be accessed by other classes, while the keyword "private"
     * means it can only be accessed internally within the class itself. 
     *************************************************************************/
    
    public static final String APPLICATION_TITLE = "Vehicle Racing";
    
    public static final int ROAD_LINES_DELAY  = 50;
    public static final int OPPONENT_DELAY    = 100;
    public static final int TIMER_DELAY       = 1000;
    public static final int OPPONENT_AMOUNT   = 10;
    public static final int DRIVER_AMOUNT     = 10;
    public static final int ROAD_LINES_AMOUNT = 10;
    
    public static final int   RACER_SPEED  = 100;
    public static final int   RACER_SIZE   = 100;
    public static final int   RACER_DAMAGE = 0;
    public static final Color RACER_COLOR  = Color.red;
    
    public static final int   SEDAN_SPEED  = 150;
    public static final int   SEDAN_SIZE   = 150;
    public static final int   SEDAN_DAMAGE = 1;
    public static final Color SEDAN_COLOR  = Color.green;
    
    public static final int   TRUCK_SPEED  = 200;
    public static final int   TRUCK_SIZE   = 200;
    public static final int   TRUCK_DAMAGE = 3;
    public static final Color TRUCK_COLOR  = Color.blue;
        
    /**************************************************************************
     * NOTE... The code below references another class we will create. Again, 
     * go to "File - New File..." then select "Java" and "Java Class". Name it 
     * "Vehicle" under "Class Name:" and it will add this class to the project 
     * and open it as a code tab in NetBeans. Once this code is completed, 
     * move on to code that class next.
     *************************************************************************/
    
    public static Vehicle vehicle;
    
}
