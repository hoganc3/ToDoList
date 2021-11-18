package ToDoListPackage;

import java.util.EmptyStackException;
import java.util.Vector;

public final class Stack <T> implements StackInterface<T>{

	private Vector<T> stack; // Last element is the top entry in stack
    private boolean initialized = false;
    
    //NICK:
    //Should we even have a default capacity and if so, what number?
    //It was originally 50 but I changed it to 0. If this causes an error just change it back.
    private static final int DEFAULT_INITIAL_CAPACITY = 0;
    private static final int MAX_CAPACITY = 10000;

    public Stack() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public Stack(int initialCapacity) {
        checkCapacity(initialCapacity);
        stack = new Vector<T>(initialCapacity);// Size doubles as needed
        initialized = true;
    } // end constructor

    
    /** 
     * Throws an exception if this object is not initialized.
     */
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("VectorStack object is not initialized " +
                                        "properly.");
   }

    /** Determine if the asked for capacity is less than the maximum.
     * @param desiredCapacity The requested capacity for the stack
     */
    private void checkCapacity(int desiredCapacity){
        if (desiredCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end checkCapacity

    /** Adds a new entry to the top of this stack.
     * @param newEntry an object to be added to the stack 
     */
    public void push(T newEntry){
        checkInitialization();
        stack.add(newEntry);

    }

    /** Removes and returns this stack’s top entry.
     * @return  The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation. 
     */
    public T pop() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.remove(stack.size() - 1);
        }
    } // end pop

    /** Retrieves this stack's top entry.
     * @return The object at the top of the stack or null if
     * @throws EmptyStackException if the stack is empty. 
     */
    public T peek(){
        checkInitialization();
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();
    } // end peek

    /** Detects whether this stack is empty.
     * @return True if the stack is empty. 
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    } // end isEmpty

    /** Removes all entries from this stack */
    public void clear(){
        stack.clear();
    } // end celar

    /** Override the toString() method so that we get a more useful display of 
     * the contents in the stack.
     * @return A string representation of the contents of the stack. 
     */
    public String toString() {

        String result = "Stack[ ";

        for (int index = 0; index < stack.size(); index++) {
            result += stack.get(index) + " ";
        } // end for

        result += "]*Top*";
        return result;
    }

   
}
