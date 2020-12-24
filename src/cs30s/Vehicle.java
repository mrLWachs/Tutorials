
/** Required package class namespace */
package cs30s;

/** Required imports */
import java.awt.Color;
 
/**
 * Vehicle.java - This class represents the general idea of a vehicle. Classes
 * can contain "properties" and "methods". We know what methods are, but in the 
 * context of classes, then can also be though of as "things the class can do"
 * (or "actions" or even "verbs"). 
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class Vehicle 
{

    /**************************************************************************
     * NOTE... When a property is made "private" it cannot be accessed outside
     * the class (it is internal to the class only) but is still a global
     * variable for this class.
     *************************************************************************/
    
    private String driver;          // Stores the vehicle's driver
    public  int    size;            // Stores the vehicle's size
    public  int    speed;           // Stores the vehicle's speed
    public  int    damage;          // Stores the vehicle's amount of damage
    public  Color  color;           // Stores the vehicle's color
    
    
    /**
     * A constructor method for the class that is called when a vehicle is
     * created 
     * 
     * @param driver the name of this vehicle's driver
     */
    public Vehicle(String driver) {
        this.driver = driver;       // assign the parameter to the property
    }
    
    /**
     * A method to allow classes outside this one to "read" the driver 
     * property without being able to change it ("read only")
     * 
     * @return the driver's name
     */
    public String getDriver() {
        return driver;
    }
    
    /**************************************************************************
     * NOTE... We will now again create three new classes to code. Once again, 
     * go to "File - New File..." then select "Java" and "Java Class". Name the
     * three classes: "Motorcycle", "Car", and "Truck". Each will open in their
     * own code tabs. Complete the code for these three classes then return 
     * back to the code for the "VehicleSelect" class.
     *************************************************************************/
    
}
