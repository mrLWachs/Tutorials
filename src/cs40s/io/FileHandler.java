
/******************************************************************************
 * NOTE... This class is already coded and completed and you do NOT need to 
 * modify it. You ARE responsible for adding the "EXPLANATION" comment below...
 * 
 * EXPLANATION: 
 * 
 * ADD COMMENT HERE!
 * 
 * NOTE... After completing this comment in your project, examining the code,  
 * and reading all the comments below, move next to the "UIController.java" 
 * class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.io;

/** Required imports */
import cs40s.collections.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


/**
 * FileHandler.java - a collection of useful methods for working with files
 *
 * @author Mr. Wachs 
 * @param <T> the generic data type to use
 * @since December, 2020
 */
public class FileHandler <T>
{
    
    private Dialogs dialog;                     // dialogs used for errors
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param dialog the Dialog object to associate with
     */
    public FileHandler(Dialogs dialog) {
        this.dialog = dialog;                   // Assign parameter to property
    }

    /**
     * Default constructor for the class sets class properties
     */
    public FileHandler() {
        this.dialog = new Dialogs("");          // Instantiate dialog class
    }

    /**
     * Saves the passed text to the passed file name
     * 
     * @param text the text to save
     * @param fileName the name of the file to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(String text, String fileName) {
        try {                                               // Start try block
            FileWriter stream = new FileWriter(fileName);   // Connect to name
            PrintWriter file  = new PrintWriter(stream);    // Connect to writer
            file.print(text);                               // Write text 
            file.close();                                   // Close connection
            return true;                                    // Return successful
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return false;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File save: " + error.toString());    // Show user
            return false;                                   // Return no success
        }
    }
    
    /**
     * Saves the passed text to the passed file 
     * 
     * @param text the text to save
     * @param file the File object to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(String text, File file) {
        try {                                               // Start try block
            return save(text,file.getAbsolutePath());   // Call with file path
        }
        catch (NullPointerException e) {                    // Null error caught  
            dialog.output("Null: " + e.toString());         // Show user
            return false;                                   // Return no success
        }
    }
       
    /**
     * Saves the passed array of text to the passed file name
     * 
     * @param array the array of text to save
     * @param fileName the name of the file to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(String[] array, String fileName) {
        try {                                               // Start try block            
            FileWriter stream = new FileWriter(fileName);   // Connect to name
            PrintWriter file  = new PrintWriter(stream);    // Connect to writer            
            for (String string : array) {                   // Traverse array
                file.println(string);                       // Write to file
            }
            file.close();                                   // Close connection
            return true;                                    // Return successful
        }
        catch (ArrayIndexOutOfBoundsException | 
               ArrayStoreException error) {                     // Array error
            dialog.output("Array type: " + error.toString());   // Show user
            return false;                                   // Return no success
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return false;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File save: " + error.toString());    // Show user
            return false;                                   // Return no success
        }
    }
    
    /**
     * Saves the passed text to the passed file 
     * 
     * @param array the array of text to save
     * @param file the File object to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(String[] array, File file) {
        try {                                               // Start try block
            return save(array,file.getAbsolutePath());  // Call with file path
        }
        catch (NullPointerException e) {                    // Null error caught
            dialog.output("Null: " + e.toString());         // Show user
            return false;                                   // Return no success
        }
    }
        
    /**
     * Saves the passed list of text to the passed file name
     * 
     * @param list a LinkedList of text to save
     * @param fileName the name of the file to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(LinkedList<String> list, String fileName) {
        try {                                               // Start try block            
            FileWriter stream = new FileWriter(fileName);   // Connect to name
            PrintWriter file  = new PrintWriter(stream);    // Connect to writer              
            for (int i = 0; i < list.size(); i++) {         // Traverse list
                file.println(list.get(i));                  // Write to file
            }            
            file.close();                                   // Close connection
            return true;                                    // Return successful
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return false;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File save: " + error.toString());    // Show user
            return false;                                   // Return no success   
        }
    }
    
    /**
     * Saves the passed text to the passed file 
     * 
     * @param list a LinkedList of text to save
     * @param file the File object to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean save(LinkedList<String> list, File file) {
        try {                                               // Start try block
            return save(list,file.getAbsolutePath());  // Call with file path
        }
        catch (NullPointerException e) {                    // Null error caught
            dialog.output("Null: " + e.toString());         // Show user
            return false;                                   // Return no success
        }
    }
        
    /**
     * Appends (meaning it adds the line to the data already in the file) the 
     * passed text to the passed file name
     * 
     * @param line the line of text to append to the end of the file
     * @param fileName the name of the file to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean append(String line, String fileName) {
        try {                                               // Start try block            
            FileWriter stream = new FileWriter(fileName,true);  // Use append
            PrintWriter file  = new PrintWriter(stream);       // Connect writer
            file.println(line);                             // Append line
            file.close();                                   // Close connection
            return true;                                    // Return successful
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return false;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File append: " + error.toString());    // Show user
            return false;                                   // Return no success
        }
    }
    
    /**
     * Appends (meaning it adds the line to the data already in the file) the 
     * passed text to the passed file 
     * 
     * @param line the line of text to append to the end of the file
     * @param file the File object to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean append(String line, File file) {
        try {                                               // Start try block
            return append(line,file.getAbsolutePath());  // Call with file path
        }
        catch (NullPointerException e) {                    // Null error caught
            dialog.output("Null: " + e.toString());         // Show user
            return false;                                   // Return no success
        }
    }
        
    /**
     * Opens the passed file name and returns the contents as a single string
     * 
     * @param fileName the name of the file to open
     * @return a string of the contents of the file (or null)
     */
    public String open(String fileName) {
        try {                                               // Start try block            
            FileReader stream   = new FileReader(fileName);   // Connect to name
            BufferedReader file = new BufferedReader(stream); // Connect reader
            String line = file.readLine();                  // Read in line
            file.close();                                   // Close connection
            return line;                                    // Return line
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no text
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File open: " + error.toString());    // Show user
            return null;                                    // Return no text
        }
    }

    /**
     * Opens the passed file and returns the contents as a single string
     * 
     * @param file the file to open
     * @return a string of the contents of the file (or null)
     */
    public String open(File file) {
        try {                                               // Start try block
            return open(file.getAbsolutePath());        // Call with file path
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no text
        }
    }
    
    /**
     * Opens the passed file name and returns the contents as a string array
     * 
     * @param fileName the name of the file to open
     * @return a string array of the contents of the file (or null)
     */
    public String[] openArray(String fileName) {
        try {                                               // Start try block
            LinkedList<String> list = openList(fileName);   // Get list 
            if (list == null) return null;                  // Error catch
            String[] array = new String[0];                 // Create array
            array = list.toArray(array);                    // Convert list 
            return array;                                   // Return filled
        }
        catch (NullPointerException error) {               // Null error caught
            dialog.output("Null: " + error.toString());    // Show user
            return null;                                   // Return no success
        }    
    }

    /**
     * Opens the passed file and returns the contents as a string array
     * 
     * @param file the file to open
     * @return a string array of the contents of the file (or null)
     */
    public String[] openArray(File file) {
        try {                                               // Start try block
            return openArray(file.getAbsolutePath());   // Call with file path
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no text
        }
    }
        
    /**
     * Opens the passed file name and returns the contents as a string list
     * 
     * @param fileName the name of the file to open
     * @return a string LinkedList of the contents of the file (or null)
     */
    public LinkedList<String> openList(String fileName) {
        try {                                               // Start try block            
            FileReader stream   = new FileReader(fileName);   // Connect to name
            BufferedReader file = new BufferedReader(stream); // Connect reader
            String line = file.readLine();                  // Read in line            
            LinkedList<String> list = new LinkedList<>();   // Create list        
            while (line != null) {                          // Read until end                          
                list.add(line);                             // Add line to list
                line = file.readLine();                     // Read next line
            }          
            file.close();                                   // Close connection
            return list;                                    // Return filled
        }
        catch (NullPointerException error) {               // Null error caught
            dialog.output("Null: " + error.toString());    // Show user
            return null;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File open: " + error.toString());    // Show user
            return null;                                   // Return no success
        }
    }

    /**
     * Opens the passed file and returns the contents as a string list
     * 
     * @param file the file to open
     * @return a string LinkedList of the contents of the file (or null)
     */
    public LinkedList<String> openList(File file) {
        try {                                               // Start try block
            return openList(file.getAbsolutePath());   // Call with file path
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no text
        }
    }
    
    /**
     * Opens the passed file and returns the contents as a LinkedList of
     * ACSII integers
     * 
     * @param file the file to open
     * @return a LinkedList of integers (ASCII) contents or null
     */
    public LinkedList<Integer> openASCIICollection(File file) {
        try {                                               // Start try block            
            FileReader     stream = new FileReader(file);     // Connect to file
            BufferedReader reader = new BufferedReader(stream); // Connect read
            LinkedList<Integer> tokens = new LinkedList<>();    // Create list        
            int token = reader.read();              // Read in single character
            while (token != -1) {                       // Read until end  
                tokens.add(token);                      // Add to list
                token = reader.read();                  // Read next character
            }
            reader.close();                             // Close connection
            return tokens;                              // Return filled list
        }
        catch (NullPointerException error) {               // Null error caught
            dialog.output("Null: " + error.toString());    // Show user
            return null;                                   // Return no success
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File open: " + error.toString());    // Show user
            return null;                                   // Return no success
        }
    }
    
    /**
     * Opens the passed file and returns the contents as a LinkedList of
     * ACSII integers
     * 
     * @param fileName the name of the file to open
     * @return a LinkedList of integers (ASCII) contents or null
     */
    public LinkedList<Integer> openASCIICollection(String fileName) {
        try {                                               // Start try block
            return openASCIICollection(new File(fileName)); // With file path
        }
        catch (NullPointerException error) {                // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no text
        }
    }
    
    /**
     * Opens the passed file and returns the contents as a LinkedList of
     * Characters
     * 
     * @param file the file object to open
     * @return a LinkedList of Character contents or null
     */
    public LinkedList<Character> openCharCollection(File file) {
        LinkedList<Integer>   list       = openASCIICollection(file);   // List
        LinkedList<Character> characters = new LinkedList<>();      // New list
        for (int i = 0; i < list.size(); i++) {         // Traverse first list
            int       value1 = list.get(i).intValue();  // Get int value
            char      value2 = (char)value1;            // Cast to char
            Character value3 = new Character(value2);   // Create Character
            characters.add(value3);                     // Add to second list
        }
        return characters;                              // Return filled list
    }
        
    /**
     * Saves the generic object to the passed filename
     * 
     * @param data the generic object to save
     * @param filename the filename to save it to
     * @return the operation was successful (true) or not (false)
     */
    public boolean saveObject(T data, String filename) {
        try {                                               // Start try block
            FileOutputStream   stream = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(stream);
            output.writeObject(data);                   // Write object to file
            output.close();                             // Close file connection
            return true;                                // Operation successful
        }
        catch(NullPointerException error) {             // Null error caught
            dialog.output("Null: " + error.toString()); // Show user
            return false;                               // Return unsuccessful
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File save: " + error.toString());    // Show user
            return false;                               // Return unsuccessful
        }
    }
        
    /**
     * Saves the generic object to the passed file
     * 
     * @param data the generic object to save
     * @param file the file object to save to
     * @return the operation was successful (true) or not (false)
     */
    public boolean saveObject(T data, File file) {
        try {                                               // Start try block
            return saveObject(data, file.getAbsolutePath());  // Call with path
        }
        catch(NullPointerException error) {                 // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return false;                                   // Return no success
        }
    }
    
    /**
     * Opens the passed filename and reads the generic object from it
     * 
     * @param filename the filename to open
     * @return the generic data type in the file
     */
    public T openObject(String filename) {
        try {                                               // Start try block
            FileInputStream   stream = new FileInputStream(filename);
            ObjectInputStream input  = new ObjectInputStream(stream);
            T object = (T)input.readObject();       // Read object and cast
            input.close();                          // Close file connection
            return object;                          // Return object read
        }
        catch (ClassCastException error) {        // Casting class error caught
            dialog.output("Class casting: " + error.toString());   // Show user
            return null;                                // Return unsuccessful
        }
        catch (ClassNotFoundException error) {    // No class type error caught
            dialog.output("Class not found: " + error.toString());  // Show user
            return null;                                // Return unsuccessful
        }
        catch(NullPointerException error) {             // Null error caught 
            dialog.output("Null: " + error.toString()); // Show user
            return null;                                // Return unsuccessful
        }
        catch (IOException error) {                 // Input/output error caught
            dialog.output("File open: " + error.toString());    // Show user
            return null;                                // Return unsuccessful
        }
    }
    
    /**
     * Opens the passed file object and reads the generic object from it
     * 
     * @param file the file object to open
     * @return the generic data type in the file
     */
    public T openObject(File file) {
        try {                                               // Start try block
            return openObject(file.getAbsolutePath());      // Call with path
        }
        catch(NullPointerException error) {                 // Null error caught
            dialog.output("Null: " + error.toString());     // Show user
            return null;                                    // Return no success
        }
    }    
    
}