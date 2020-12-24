
/** Required package class namespace */
package cs30s;

/**
 * Motorcycle.java - This class represents a motorcycle in code. In the line 
 * below add the code "extends" which is a keyword in Java that causes this
 * class to "inherit" all the properties ("things about the class") and methods
 * ("things the class can do") from the "Vehicle" class. Like biology, this
 * means the "Vehicle" class is a "parent" class (also called a "super" class)
 * to this class (which we can call the "child" class). Simply put the
 * "Motorcycle" "is a" "Vehicle" which is what the concept of inheritance 
 * means. The keyword "super" can be used in code to refer to this parent class
 * either to access properties or call methods (including the constructors).
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class Motorcycle extends Vehicle
{
    
    /**
     * Constructor method sets class properties and "passes" the information
     * to the "super" (or parent) class.
     * 
     * @param driver the name of this vehicle's driver
     */
    public Motorcycle(String driver) {
        // A call to the constructor method in the "super" class (or parent)
        super(driver);                          
        
        // Now set all other properties we inherited from the super class 
        // (which are public) by reading from the shared properties of the 
        // "Globals" class
        super.speed  = Globals.RACER_SPEED;
        super.size   = Globals.RACER_SIZE;
        super.damage = Globals.RACER_DAMAGE;
        super.color  = Globals.RACER_COLOR;
    }
    
}
