
/** Required package class namespace */
package tutorials;

/** Required imports */
import cs30s.CS30STutorial;
import cs40s.CS40STutorial;


/**
 * Tutorials.java - Various class tutorials for students to work on
 *
 * @author Mr. Wachs 
 * @since December, 2020
 */ 
public class Tutorials 
{

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CS30STutorial().main(args);
        new CS40STutorial().main(args);
    }

}
