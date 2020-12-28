
/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * This class is another class to use as an example of a "helper" class that
 * is a modification of a class in our Help page that was started in the 
 * CS30S course. The class is a series of methods to work with numbers. Most
 * of these methods are not used in the tutorial directly (they are used by 
 * the "Dialogs.java" class) but could be used in the future (or modified 
 * for use). 
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "FileHandler.java" 
 * class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.tools;

/** Required imports */
import cs40s.collections.LinkedList;

 
/**
 * Numbers.java - a collection of useful methods for working with numbers
 *
 * @author Mr. Wachs
 * @since December, 2020
 */
public class Numbers 
{

    private final char NEGATIVE = '-';          // The negative number symbol
    private final char DECIMAL  = '.';          // The decimal number symbol
    
    /**
     * Checks the value to see if it contains numerical characters or a "-" 
     * or a "."
     * 
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    public boolean isDouble(String value) {
        char[] characters = value.toCharArray(); // Convert string to char array
        for (int i = 0; i < characters.length; i++) {   // Traverse array            
            if (!Character.isDigit(characters[i])) {    // Not a digit 
                if (characters[i] != DECIMAL &&     
                    characters[i] != NEGATIVE) {        // Check if not special
                    return false;                       // Not a digit
                }
            }
        }
        try {                                           // Error trap starts
            Double.parseDouble(value);                  // Convert to double
        } 
        catch (NumberFormatException error) {           // Catch error
            return false;                               // Not a digit
        }
        return true;                                    // Is a digit
    }
    
    /**
     * Checks the value to see if it contains numerical characters or a "-"
     * 
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    public boolean isInteger(String value) {
        char[] characters = value.toCharArray(); // Convert string to char array
        for (int i = 0; i < characters.length; i++) {   // Traverse array            
            if (!Character.isDigit(characters[i])) {    // Not a digit
                if (characters[i] != NEGATIVE) {        // Check if not special
                    return false;                       // Not a digit
                }
            }
        }   
        try {                                           // Error trap starts
            Integer.parseInt(value);                    // Convert to integer
        } 
        catch (NumberFormatException error) {           // Catch error
            return false;                               // Not a digit
        }
        return true;                                    // Is a digit
    }

    /**
     * Determines if a number if odd or even
     * 
     * @param number the number to check
     * @return true (if even), false (if odd)
     */
    public boolean isEven(int number) {
        if (number % 2 == 0) return true;       // Is divisible by two, so even
        else                 return false;      // Is not divisible, so odd
    }
    
    /**
     * Checks to make sure the number is in the range
     * 
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    public boolean inRange(int number, int low, int high) {
        if (number >= low && number <= high) return true;   // Within range
        return false;                                       // Outside range
    }
    
    /**
     * Checks to make sure the number is in the range
     * 
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    public boolean inRange(double number, double low, double high) {
        if (number >= low && number <= high) return true;   // Within range
        return false;                                       // Outside range
    }
    
    /**
     * Rounds off a number to the passed number of decimal places
     * 
     * @param number the number to round off
     * @param places the number of places to round to
     * @return a rounded off number
     */
    public double round(double number, int places) {
        String text = String.format("%." + places + "f",number); // Into string
        double rounded = Double.parseDouble(text);               // Into double
        return rounded;                 
    }
    
    /**
     * Rounds off all numbers in the array to the passed number of decimal 
     * places
     * 
     * @param array the array to use
     * @param places the number of places to round to
     * @return a rounded off array of numbers
     */
    public double[] round(double[] array, int places) {
        double[] a = new double[array.length];          // New empty array
        for (int i = 0; i < array.length; i++) {        // Traverse array
            a[i] = round(array[i], places);             // Round off and assign
        }
        return a;                                       // Return new array
    }
    
    /**
     * Rounds off all numbers in the matrix to the passed number of decimal 
     * places
     * 
     * @param matrix the matrix to use
     * @param places the number of places to round to
     * @return a rounded off matrix of numbers
     */
    public double[][] round(double[][] matrix, int places) {
        double[][] m = new double[matrix.length][matrix[0].length];
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = round(matrix[row][column], places);
            }
        }
        return m;
    }
    
    /**
     * Rounds off all numbers in the LinkedList to the passed number of decimal 
     * places
     * 
     * @param list the LinkedList to use
     * @param places the number of places to round to
     * @return a rounded off LinkedList of numbers
     */
    public LinkedList<Double> round(LinkedList<Double> list, int places) {
        LinkedList<Double> l = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            l.add(round(list.get(i), places));
        }
        return l;
    }
    
    /**
     * Generate a random Boolean
     * 
     * @return random Boolean (true or false)
     */
    public boolean random() {
        return random(0, 1) == 0;       // Random number is zero true or false
    }
    
    /**
     * Generate a random number in a range
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number in the range
     */
    public int random(int low, int high) {
        return (int)(random((double)low, (double)high));    // Ints to double
    }
    
    /**
     * Generate a random number in a range
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number in the range
     */
    public double random(double low, double high) {
        return ((high - low + 1d) * Math.random() + low);   // Random formula
    }
      
    /**
     * Generates an array of random Booleans 
     * 
     * @param size the size to make the array
     * @return an array of random integers
     */
    public boolean[] random(int size) {
        boolean[] numbers = new boolean[size];  // Create empty array
        for (int i = 0; i < size; i++) {        // Traverse array size
            numbers[i] = random();          // Assign random value to each index
        }
        return numbers;                         // Return completed array
    }
    
    /**
     * Generates an array of random integers in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the array
     * @return an array of random integers
     */
    public int[] random(int low, int high, int size) {
        int[] numbers = new int[size];      // Create empty array of passed size
        for (int i = 0; i < size; i++) {    // Traverse array size
            numbers[i] = random(low,high);  // Assign random value to each index
        }
        return numbers;                     // Return completed array
    }
    
    /**
     * Generates an array of random doubles in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the array
     * @return an array of random doubles
     */
    public double[] random(double low, double high, int size) {
        double[] numbers = new double[size];    // Create empty array 
        for (int i = 0; i < size; i++) {        // Traverse array size
            numbers[i] = random(low,high);  // Assign random value to each index
        }
        return numbers;                         // Return completed array
    }
   
    /**
     * Generates a matrix of random integers in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random integers
     */
    public int[][] random(int rows, int columns, int low, int high) {
        int[][] matrix = new int[rows][columns];        // Create empty matrix
        for (int row = 0; row < rows; row++) {          // Traverse rows
            matrix[row] = random(low, high, columns);   // Create random row
        }
        return matrix;                              // Return completed matrix
    }
    
    /**
     * Generates a matrix of random doubles in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random doubles
     */
    public double[][] random(int rows, int columns, double low, double high) {
        double[][] matrix = new double[rows][columns];  // Create empty matrix
        for (int row = 0; row < rows; row++) {          // Traverse rows
            matrix[row] = random(low, high, columns);   // Create random row
        }
        return matrix;                              // Return completed matrix
    }
    
    /**
     * Generates a list of random integers in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the list
     * @return a list of random integers
     */
    public LinkedList<Integer> randomList(int low, int high, int size) {
        LinkedList<Integer> list = new LinkedList<Integer>(); // Create list
        for (int i = 0; i < size; i++) {                // Traverse size
            list.add(random(low, high));                // Add random to list
        }
        return list;                                    // Return completed list
    }
    
    /**
     * Generates a list of random doubles in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the list
     * @return a list of random doubles
     */
    public LinkedList<Double> randomList(double low, double high, int size) {
        LinkedList<Double> list = new LinkedList<Double>(); // Create list
        for (int i = 0; i < size; i++) {                // Traverse size
            list.add(random(low, high));                // Add random to list
        }
        return list;                                    // Return completed list
    }
    
    /**
     * Generates a list of random Booleans
     * 
     * @param size the size to make the list
     * @return a list of random doubles
     */
    public LinkedList<Boolean> randomList(int size) {
        LinkedList<Boolean> list = new LinkedList<Boolean>();   // Create list
        for (int i = 0; i < size; i++) {                // Traverse size
            list.add(random());                         // Add random to list
        }
        return list;                                    // Return completed list
    }
    
}
