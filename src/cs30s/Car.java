
/** Required package class namespace */
package cs30s;
 
/**
 * Car.java - This class represents a car in code. It uses the same code logic 
 * as the "Motorcycle" class. It also uses "inheritance" as it "is a" vehicle
 * (inheriting all properties and methods).
 *
 * @author Mr. Wachs
 * @since December 2020
 */
public class Car extends Vehicle
{

    /**
     * Constructor method sets class properties in the same way as the 
     * "Motorcycle" class but with the different properties appropriate for  
     * this "child" class
     * 
     * @param driver the name of this vehicle's driver
     */
    public Car(String driver) {
        super(driver);
        super.speed  = Globals.SEDAN_SPEED;
        super.size   = Globals.SEDAN_SIZE;
        super.damage = Globals.SEDAN_DAMAGE;
        super.color  = Globals.SEDAN_COLOR;
    }
    
}
