/******************************************************************************
 * NOTE... This class is partially coded but will have errors for the missing
 * code you will be adding to complete the class (and therefore work towards 
 * completing the tutorial). You are responsible for all areas with "NOTE..."
 * added in as a comment (as shown in the tutorial document and video). This 
 * also includes adding comments to the code as outlined. 
 * 
 * NOTE... After completing all needed code, examining the existing code and 
 * comments, move next to the "LinkedList.java" class... 
 *****************************************************************************/


/** Required package class namespace */
package cs40s.collections;

/** Required imports */
import java.io.Serializable;

 
/**
 * NOTE... Add the first part of the class comment below...
 * 
 * Node.java - a representation of a generic node for use with a LinkedList
 * object. The node is a piece of whatever "data" the list will be storing. It
 * has a section of memory for that data as well as a "link" (or "connection", 
 * or "reference", or "pointer") to the next node that will be in the list. 
 * 
 * It could be "visualized" as:
 * <pre>
 *                              NODE
 *            +-------------+-----------+-------------+
 * node <-----|   previous  |   data    |    next     |
 *            | (reference) | (content) | (reference) |
 *            |   (link)    | (generic) |   (link)    |
 *            |  (pointer)  |           |  (pointer)  |----> node
 *            +-------------+-----------+-------------+
 * </pre>
 * 
 * @author Mr. Wachs 
 * @param <T> the generic data type used in the class
 * @since December, 2020
 */
public class Node <T> implements Serializable
{
    
    /**************************************************************************
     * NOTE... Add the class properties and the comments below:
     *************************************************************************/
    
     /** The generic data for the node to store */
    public T data;    
    /** Self reference (link) to the next node in the "chain" */
    public Node next;
    /** Self reference (pointer) to the previous node in the "list" */
    public Node previous;
    
    
    /**************************************************************************
     * NOTE... Add the first class constructor below (the other overloaded
     * constructors are already added and their errors will disappear once this
     * constructor is added.
     *************************************************************************/
    
    /**
     * Class constructor sets class properties 
     * 
     * @param data the node data
     * @param next reference to the next Node object
     * @param previous reference to the previous Node object
     */
    public Node(T data, Node next, Node previous) {
        this.data     = data;
        this.next     = next;
        this.previous = previous;
    }
       
    /**
     * Class constructor sets class properties 
     * 
     * @param data the node data
     * @param next reference to the next Node object
     */
    public Node(T data, Node next) {
        this(data,next,null);
    }
        
    /**
     * Class constructor sets class properties 
     * 
     * @param data the node data
     */
    public Node(T data) {
        this(data,null,null);
    }
    
    /** 
     * Default constructor, sets class properties
     */
    public Node() {
        this(null,null,null);
    }
        
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        
        /**********************************************************************
         * NOTE... Add the code inside this overloaded method...
         *********************************************************************/
        
        if (data == null) return null;              // Invalid data, output null
        return data.toString();                     // Output data in node
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        
        /**********************************************************************
         * NOTE... Add the code inside this overloaded method...
         *********************************************************************/
        
        if (this.data == null) return false;    // Error check the node data
        if (object    == null) return false;    // Error check the parameter
        Node that = (Node)object;               // Cast object into node
        if (that.data == null || this.data == null) return false;   // Invalid
        return this.data.equals(that.data);     // Compare data in nodes
    }
        
    /**
     * A Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Node clone() {
        return new Node(data,next,previous);        // Annonymous object
    }
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public void finalize() {
        
        /**********************************************************************
         * NOTE... Add the code inside this overloaded method...
         *********************************************************************/
        
        data = null;                // Set node internal data to null
        next = previous = null;     // Set both "link" references to null
        System.gc();                // Runs the garbage collector in Java
    }

}
