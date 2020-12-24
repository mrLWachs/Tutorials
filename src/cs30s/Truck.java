
/** Required package class namespace */
package cs30s;
 
/**
 * Truck.java - This class represents a truck in code. It uses the same code 
 * logic as the "Motorcycle" class. It also uses "inheritance" as it "is a"
 * vehicle (inheriting all properties and methods).
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class Truck extends Vehicle
{

    /**
     * Constructor method sets class properties in the same way as the 
     * "Motorcycle" class but with the different properties appropriate for  
     * this "child" class
     * 
     * @param driver the name of this vehicle's driver
     */
    public Truck(String driver) {
        super(driver);
        super.speed  = Globals.TRUCK_SPEED;
        super.size   = Globals.TRUCK_SIZE;
        super.damage = Globals.TRUCK_DAMAGE;
        super.color  = Globals.TRUCK_COLOR;
    }
    
}
