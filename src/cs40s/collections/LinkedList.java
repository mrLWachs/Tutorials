/******************************************************************************
 * NOTE... This class is partially coded but will have errors for the missing
 * code you will be adding to complete the class (and therefore work towards 
 * completing the tutorial). You are responsible for all areas with "NOTE..."
 * added in as a comment (as shown in the tutorial document and video). This 
 * also includes adding comments to the code as outlined. 
 * 
 * NOTE... After completing all needed code, examining the existing code and 
 * comments, this will complete the tutorial. Run the program, debug if 
 * necessary, and prepare for hand in
 *****************************************************************************/


/** Required package class namespace */
package cs40s.collections;

/** Required imports */
import java.io.Serializable;
import java.lang.reflect.Array;


/**
 * NOTE... Add the first part of the class comment below...
 * 
 * LinkedList.java - an implementation of a linked list abstract (advanced)
 * data (dynamic) type (ADT) and useful methods. The collection structure 
 * "links" together node objects into the collection to represent a list of
 * data. Similar to an array, but dynamic meaning we can add and delete nodes
 * by altering the links in the "chain".
 * 
 * It could be "visualized" as:
 * <pre>
 *                           LINKED LIST:
 *             +------+       +------+       +------+       +------+      
 *  null <---- |      | <---- |      | <---- |      | <---- |      |  
 *             | NODE |       | NODE |       | NODE |       | NODE |       
 *             |      |---->  |      |---->  |      |---->  |      |----> null  
 *             +------+       +------+       +------+       +------+      
 *                 ^                                           ^
 *                 |                                           |
 *                head                                        tail
 * </pre>
 * 
 * @author Mr. Wachs 
 * @param <T> the generic data type used in the class
 * @since December, 2020
 */
public class LinkedList <T> implements Serializable
{
    
    /**************************************************************************
     * NOTE... Add the class properties and the comments below:
     *************************************************************************/
    
    /** Flag to indicate a search was not found */
    public final int NOT_FOUND = -1;
    
    /** Reference (link) to the first (front) node in the list (entry point) */
    private Node head;
    
    /** Reference (link) to the last (back) node in the list (entry point) */
    private Node tail;
    
    /** The number of nodes in the list, immutable property */
    private int length;
        
    
    /**
     * Default constructor, set class properties
     */
    public LinkedList() {
        finalize();
    }
    
    /**
     * Constructor instantiates list from the passed data
     * 
     * @param array the data objects to create the list from
     */
    public LinkedList(T[] array) {
        fromArray(array);
    }
        
    /**
     * Constructor instantiates list from the passed data
     * 
     * @param list the data objects to create the list from
     */
    public LinkedList(LinkedList<T> list) {
        fromLinkedList(list);
    }
    
    /**
     * Determines if the list is empty (no content)
     * 
     * @return is empty (true) or not empty (false)
     */
    public boolean isEmpty() {
        return length == 0;
    }
    
    /**
     * Accessor method of the immutable property
     * 
     * @return the number of nodes in the list
     */
    public int size() {
        return length;
    }
            
    /**
     * Inserts data into the front (head) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addFront(T data) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
                
        if (data == null) return false;     // Null data cannot be added        
        Node<T> node = new Node<>(data);    // New node memory created 
        // Scenarios to consider:    
        // 1) empty list
        // 2) list of 1 or more nodes
        if (isEmpty()) {                    // Adding first node
            head = tail = node;             // Set references
        }
        else {                              // Subsequent nodes added
            node.next = head;               // Link node to rest of list
            head.previous = node;           // Connect rest of list to node
            head = node;                    // Reassign head reference
        }
        length++;                           // Increase length environmental
        return true;                        // Operation successful
    }
    
    /**
     * Inserts data into the back (tail) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBack(T data) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/        
        
        if (data == null) return false;     // Null data cannot be added            
        Node<T> node = new Node<>(data);    // New node memory created  
        if (isEmpty()) {                    // Adding first node
            head = tail = node;             // Set references
        }
        else {                              // Subsequent nodes added
            node.previous = tail;           // Link node to rest of list
            tail.next = node;               // Connect rest of list to node
            tail = node;                    // Reassign tail reference
        }
        length++;                           // Increase length environmental
        return true;                        // Operation successful
    } 
    
    /**
     * Accessor for the data at the specified index
     * 
     * @param index the index location to access
     * @return the data (or null) at the index
     */
    public T get(int index) {      
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (!inRange(index)) return null;   // Invalid index, return flag        
        return (T)getNode(index).data;      // Get reference and retrieve data  
    }
    
    /**
     * Mutator method sets the index location to the new data
     * 
     * @param index the index location to mutate
     * @param data the new data to mutate into
     * @return the operation was successful (true) or not (false)
     */
    public boolean set(int index, T data) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (!inRange(index)) return false;          // invalid index
        if (data == null)    return false;          // invalid data
        Node current = getNode(index);              // get to node at index
        current.data = data;                        // change node data
        return true;                                // operation successful
    }
    
    /**
     * Accesses the first, head, front data in the list
     * 
     * @return the head data
     */
    public T front() {
        return get(0);                              // first node
    }
    
    /**
     * Accesses the last, tail, back data in the list
     * 
     * @return the tail data
     */
    public T back() {
        return get(length-1);                       // last node
    }
    
    /**
     * Removes (deletes) the first (head) node of the list
     * 
     * @return the data in the first node (or null)
     */
    public T removeFront() {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (isEmpty()) return null;             // No front to remove
        T data = (T)head.data;                  // Store head data
        if (length == 1) finalize();            // One node list, wipe list
        else {                
            head = head.next;                   // Advanced head reference
            head.previous.next = null;          // Cut old head reference
            head.previous = null;               // Cut reference to old head
            length--;                           // Reduce list length
            System.gc();                        // Call system garbage collector
        }
        return data;                            // Return stored data
    }
    
    /**
     * Removes (deletes) the last (tail) node of the list
     * 
     * @return the data in the last node (or null)
     */
    public T removeBack() {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (isEmpty()) return null;             // No back to remove
        T data = (T)tail.data;                  // Store tail data
        if (length == 1) finalize();            // One node list, wipe list
        else {   
            tail = tail.previous;               // Advanced tail reference
            tail.next.previous = null;          // Cut old tail reference
            tail.next = null;                   // Cut reference to old tail
            length--;                           // Reduce list length
            System.gc();                        // Call system garbage collector
        }
        return data;                            // Return stored data
    }
    
    /**
     * Checks (searches) if the specified data is inside the list
     * 
     * @param data the data to check for
     * @return data is in the list (true) or not (false)
     */ 
    public boolean contains(T data) {
        if (data == null) return false;         // Invalid data to search for
        Node current = head;                    // Start reference at head
        while (current != null) {               // Traverse list
            if (current.data.equals(data)) {    // Found first occurrence
                return true;                    // Indicate found
            }
            current = current.next;             // Move to next node
        }
        return false;                           // Not found in list
    } 
    
    /**
     * Inserts data as a new node after the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert after
     * @return the operation was successful (true) or not (false)
     */
    public boolean addAfter(T data, int index) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (data == null)    return false;              // Invalid data to add
        if (!inRange(index)) return false;              // Index out of range        
        if (index == length-1) return addBack(data);    // Add to end of list
        Node<T> node = new Node<>(data);                // Create node object
        Node current = getNode(index);                  // Get to index spot
        node.next = current.next;                       // Set proper references
        current.next.previous = node;
        current.next = node;
        node.previous = current;            
        length++;                                       // Increase length
        return true;                                    // Opperation successful
    }
    
    /**
     * Inserts data as a new node before the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert before
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBefore(T data, int index) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (data == null)    return false;              // Invalid data to add
        if (!inRange(index)) return false;              // Index out of range        
        if (index == 0)      return addFront(data);     // Add to start of list
        Node<T> node = new Node<>(data);                // Create node object
        Node current = getNode(index);                  // Get to index spot
        node.previous = current.previous;               // Set proper references
        current.previous.next = node;
        current.previous = node;
        node.next = current;            
        length++;                                       // Increase length
        return true;                                    // Opperation successful
    }
    
    /**
     * Adds the data to the back of the list (wrapper method)
     * 
     * @param data the data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean add(T data) {
        return addBack(data);                           // Wrapper method call
    }
    
    /**
     * Adds the data before the passed index (wrapper method)
     * 
     * @param data the data to add
     * @param index the index location to add before
     * @return the operation was successful (true) or not (false)
     */
    public boolean add(T data, int index) {
        return addAfter(data, index);                   // Wrapper method call
    }
    
    /**
     * Deletes the node at the specified index and mutates the list
     * 
     * @param index the index location to remove
     * @return the data at the specified index (or null)
     */
    public T remove(int index) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (!inRange(index))   return null;             // Not in range
        if (index == 0)        return removeFront();    // Remove first
        if (index == length-1) return removeBack();     // Remove last
        Node current = getNode(index);                  // Get to index
        current.next.previous = current.previous;       // Change references
        current.previous.next = current.next;
        current.next = current.previous = null;        
        length--;                                       // Reduce list length
        return (T)current.data;                         // Return index data
    }
    
    /**
     * Finds the node matching the data at the first occurrence in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of first occurrence or -1 (NOT_FOUND)
     */
    public int firstIndexOf(T data) {
        if (data == null) return NOT_FOUND;     // Null data rejected
        Node current = head;                    // Start at head
        int index = 0;                          // Start count at 0
        while (current != null) {               // Traverse list
            if (current.data.equals(data)) {    // Found first occurrence
                return index;                   // Return location
            }
            current = current.next;             // Advance to next node
            index++;                            // Advance count
        }
        return NOT_FOUND;                       // Data not found
    }
    
    /**
     * Finds the node matching the data at the last occurrence in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of last occurrence or -1 (NOT_FOUND) 
     */
    public int lastIndexOf(T data) {
        if (data == null) return NOT_FOUND;     // Null data rejected
        Node current = tail;                    // Start at head
        int index = length-1;                   // Start count at total nodes
        while (current != null) {               // Traverse list
            if (current.data.equals(data)) {    // Found last occurrence
                return index;                   // Return location
            }
            current = current.previous;         // Return to previous node
            index--;                            // Decrease count
        }
        return NOT_FOUND;                       // Data not found
    }
    
    /**
     * The number of instances this data occurs in the list
     * 
     * @param data the data to search for
     * @return the number of instances of the data
     */
    public int numberOf(T data) {
        if (data == null) return 0;             // Reject null data
        int counter = 0;                        // Start a counter
        Node current = head;                    // Start at head of list
        while (current != null) {               // Traverse list
            if (current.data.equals(data)) {    // Item found in list
                counter++;                      // Increase counter
            }
            current = current.next;             // Advance to next node
        }
        return counter;                         // Counter returned
    }
    
    /**
     * Accesses all occurrences of the passed data in the list and returns an
     * integer array containing all index values the data occurred at
     * 
     * @param data the data to search for
     * @return all indices location in an array or null if no indices
     */
    public int[] allIndices(T data) {
        if (data == null)    return null;       // Reject null data
        if (!contains(data)) return null;       // No data in the list
        int size = numberOf(data);              // Get number of occurrences
        int[] array = new int[size];            // Create array 
        Node current = head;                    // Start at head
        int counter = 0;                        // Start counter
        for (int i = 0; i < length; i++) {      // Traverse list
            if (current.data.equals(data)) {    // Item encountered
                array[counter] = i;             // Insert index into array
                counter++;                      // Increase counter
                if (counter >= size) {
                    return array;
                }
            }
            current = current.next;             // Move to next node
        }
        return array;                           // Return completed array
    }
    
    /**
     * Deletes the first occurrence of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean remove(T data) {
        if (data == null) return false;         // Nothing to remove
        int index = firstIndexOf(data);         // Get first location
        if (index == NOT_FOUND) return false;   // Not in list
        remove(index);                          // Remove
        return true;                            // Operation successful
    }
    
    /**
     * Deletes the last occurrence of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean removeLast(T data) {
        if (data == null) return false;         // Nothing to remove
        int index = lastIndexOf(data);          // Get first location
        if (index == NOT_FOUND) return false;   // Not in list
        remove(index);                          // Remove
        return true;                            // Operation successful
    }
    
    /**
     * Deletes all occurrences of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(T data) {
        if (data == null)    return false;      // Nothing to remove
        if (!contains(data)) return false;      // Not in list
        while(contains(data)) {                 // Loop continuously
            remove(data);                       // Removing the data
        }
        return true;                            // Operation successful
    }
    
    /**
     * Deletes all occurrences of the different data items in the array 
     * from the list
     * 
     * @param items the node data array items to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(T[] items) {
         if (items == null)     return false;   // Invalid array
         if (items.length == 0) return false;   // Invalid array
         for (T item : items) {                 // Traverse array
             removeAll(item);                   // Remove array item
         }
         return true;                           // Operation successful
    } 
   
    /**
     * Deletes all occurrences of the different data items in the passed
     * list from the current list
     * 
     * @param list the LinkedList of items to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(LinkedList<T> list) {
        if (list == null)   return false;           // Invalid list
        if (list.isEmpty()) return false;           // Empty list
        for (int i = 0; i < list.size(); i++) {     // Traverse list
            removeAll(list.get(i));                 // Remove list item
        }
        return true;                                // Operation successful
    }
   
    /**
     * Wipes out all memory of all contents of the list
     */
    public void clear() {
        Node current = head;                // Start at head of the list
        while (current != null) {           // Traverse the list
            Node next = current.next;       // Reference to the next node
            current.finalize();             // Wipe all memory from the node
            current = next;                 // Move to the next node
        }
        finalize();                         // Wipe all memory from the list
    }
   
    /**
     * Checks the list to see if it contains all the items in the array
     * 
     * @param items the node data array items to check
     * @return all items are in the array (true) or not (false)
     */
    public boolean containsAll(T[] items) {
        if (items == null)     return false;    // Invalid array
        if (items.length == 0) return false;    // Invalid array
        for (T item : items) {                  // Traverse array
            if (!contains(item)) return false;  // Item not in list
        }
        return true;                            // Operation successful
    }
    
    /**
     * Checks the list to see if it contains all the items in the array
     * 
     * @param list the LinkedList of items to check
     * @return all items are in the list (true) or not (false)
     */
    public boolean containsAll(LinkedList<T> list) {
        if (list == null)     return false;         // Invalid list
        if (list.size() == 0) return false;         // Invalid list
        for (int i = 0; i < list.size(); i++) {     // Traverse array
            if (!contains((T)list.get(i))) 
                return false;                       // Item not in list
        }
        return true;                                // Operation successful
    }
    
    /**
     * Appends all the items from the passed list to the end of the 
     * current list
     * 
     * @param list the Linked list to append on
     */
    public void addAll(LinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {     // Traverse list
            this.add(list.get(i));                  // Get and add item
        }
    }
   
    /**
     * Appends all the items from the passed list into the current list 
     * after the passed index
     * 
     * @param list the Linked list to append on
     * @param index the index location to append from
     */
    public void addAll(LinkedList<T> list, int index) {
        for (int i = 0; i < list.size(); i++) {     // Traverse list
            this.addAfter(list.get(i), index);      // Get and add item after
            index++;                                // Increase index
        }
    }
        
    /**
     * Appends all the items from the passed list to the end of the 
     * current list
     * 
     * @param items the array to append on
     */
    public void addAll(T[] items) {
        for (int i = 0; i < items.length; i++) {    // Traverse array
            this.add(items[i]);                     // Add array item
        }
    }
    
    /**
     * Appends all the items from the passed list into the current list 
     * after the passed index
     * 
     * @param items the array to append on
     * @param index the index location to append from
     */
    public void addAll(T[] items, int index) {
        for (int i = 0; i < items.length; i++) {    // Traverse array
            this.addAfter(items[i], index);         // Add array item after
            index++;                                // Increase index
        }
    }
   
    /**
    * Accesses a sub list from the main list based on the passed parameters
    * 
    * @param from the index to start the sublist from
    * @param to the index to end the sub list at
    * @return a sub list from the main list
    */
    public LinkedList<T> subList(int from, int to) {
        if (!inRange(from)) return null;            // Index out of range
        if (!inRange(to))   return null;            // Index out of range
        if (from > to)      return null;            // Index not in line
        LinkedList<T> list = new LinkedList<>();    // Create list
        for (int i = from; i <= to; i++) {          // Traverse indices
            list.add(this.get(i));                  // Add to list from list
        }
        return list;                                // Return new list
    }
    
    /**
     * Mutates the list into a list only matching the contents of the array
     * 
     * @param array the data objects to form the list from
     */
    public final void fromArray(T[] array) {
        if (array == null) return;                  // Error check
        finalize();                                 // Wipe list memory
        for (T item : array) {                      // Traverse array
            add(item);                              // Add array item
        }
    }
    
    /**
     * Mutates list into a list only matching the contents of the other list
     * 
     * @param list the data objects to form the list from
     */
    public final void fromLinkedList(LinkedList<T> list) {
        if (list == null) return;                   // Error check
        finalize();                                 // Wipe list memory
        for (int i = 0; i < list.size(); i++) {     // Traverse list
            add(list.get(i));                       // Get and add item
        }
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(array.getClass().getComponentType(), 
                        length));               // Create empty array
        for (int i = 0; i < length; i++) {      // Traverse list
            array[i] = get(i);                  // Add to array
        }
        return array;                           // Return completed array
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (isEmpty()) return "Empty LinkedList";       // No nodes to display
        String text = "Linked List [";                  // Starting character
        Node current = head;                            // Start at head node
        while (current.next != null) {                  // Traverse list
            text += current.toString() + ",";           // Append data
            current = current.next;                     // Move to next node
        }            
        return text + current.toString() + "]";         // Append end character      
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
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        LinkedList<T> that = (LinkedList<T>)object;     // Cast object to list
        if (this.size() != that.size()) return false;   // Not same sizes      
        Node current1 = this.getFirstNode();            // Get reference to
        Node current2 = that.getFirstNode();            // Nodes in each list    
        while (current1 != null) {                      // Traverse lists
            if (!current1.equals(current2)) {           // Not equal data 
                return false;                           // Not equal lists
            }                
            current1 = current1.next;                   // Move each reference
            current2 = current2.next;                   // To next node
        }
        return true;                                    // Lists are equal
    }
        
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public LinkedList clone() {
        LinkedList<T> list = new LinkedList<>();    // Create new list memory
        for (int i = 0; i < length; i++) {          // Traverse list
            list.addBack((T)this.getNode(i).data);  // Get and add node data          
        }        
        return list;                                // New list returned
    }
        
    /**
     * Frees up all memory used by this object
     */
    @Override
    public void finalize() {
        length = 0;                 // Length set to zero
        head = tail = null;         // References set to nulls
        System.gc();                // Runs the garbage collector in Java
    }
        
    /**
     * Accessor method to the encapsulated (private) property of the first
     * (head) node of the list
     * 
     * @return reference to the first node
     */
    protected Node getFirstNode() {
        return head;
    }
    
    /**
     * Accessor method to the encapsulated (private) property of the last
     * (tail) node of the list
     * 
     * @return reference to the last node
     */
    protected Node getLastNode() {
        return tail;
    }
    
    /**
     * Accesses the node reference for this index location
     * 
     * @param index the index location
     * @return a reference to the node at this index or null
     */
    protected Node getNode(int index) {
        
        /**********************************************************************
         * NOTE... Add the code and comments inside this method...
         *********************************************************************/
        
        if (!inRange(index))   return null;             // Not valid index
        if (index == 0)        return getFirstNode();   // First node returned
        if (index == length-1) return getLastNode();    // Last node returned
        Node current = head;                            // Start at first node
        for (int i = 0; i < index; i++) {               // Move to index
            current = current.next;                     // Advance reference
        }
        return current;                                 // Return reference
    }
        
    /**
     * Checks to see if the index is in range of the list
     * 
     * @param index the location to check
     * @return it is in range (true) or not (false)
     */        
    private boolean inRange(int index) {
        if (isEmpty())       return false;  // Empty list no valid index
        if (index < 0)       return false;  // Index before first valid number
        if (index >= length) return false;  // Index after last valid number
        return true;                        // Index is valid
    }

}
