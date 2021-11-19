package ToDoListPackage;
import java.util.Arrays;
public class ArrayList<T> implements ListInterface<T> {
	
	//Still need to add check capacity method
	
	private T[] list;
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayList() {
		
		this(DEFAULT_CAPACITY);
		
	}
	
	public ArrayList(int initialCapacity) {
		
		integrityOK = false; 
		
		if(initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		}
		else {
			checkCapacity(initialCapacity);
		}
		
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	}
	
	public void addEntry(T newEntry) {
		checkIntegrity();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
		} // end add
		

	
	public void add(int givenPosition, T newEntry) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
		{
		if (givenPosition <= numberOfEntries)
		makeRoom(givenPosition);
		list[givenPosition] = newEntry;
		numberOfEntries++;
		ensureCapacity();
		}
		else
		throw new IndexOutOfBoundsException(
		"Given position of add's new entry is out of bounds.");
		} // end add

		private void makeRoom(int givenPosition)
		{
			int newIndex = givenPosition;
			int lastIndex = numberOfEntries;
			for (int index = lastIndex; index >= newIndex; index--)
				list[index + 1] = list[index];
		} // end makeRoom
	
	public T remove(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
		// Assertion: The list is not empty
		T result = list[givenPosition]; // Get entry to be removed
		// Move subsequent entries toward entry to be removed,
		// unless it is last in list
		if (givenPosition < numberOfEntries)
		removeGap(givenPosition);
		list[numberOfEntries] = null;
		numberOfEntries--;
		return result; // Return reference to removed entry
		}
		else
		throw new IndexOutOfBoundsException(
		"Illegal position given to remove operation.");
		} // end remove


	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
	public T replace(int givenPosition, T newEntry) {
		checkIntegrity();
		T original = list[givenPosition-1];
		list[givenPosition-1] = newEntry;
		return original;
		} // end replace

	
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T[] toArray() {
		checkIntegrity();
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++)
		{
		result[index] = list[index + 1];
		} // end for
		
		return result;
		} // end toArray


	
	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries))
		{
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		} // end while
		return found;
	}

	
	public int getLength() {
		return numberOfEntries;
	} // end contains

	
	public boolean isEmpty() {
		return numberOfEntries == 0; 
	}
	private void removeGap(int givenPosition)
	{
	int removedIndex = givenPosition;
	for (int index = removedIndex; index < numberOfEntries; index++)
	list[index] = list[index + 1];
	} // end removeGap
	
	private void ensureCapacity(){
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity){
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} // end if
		} // end ensureCapacity
	private void checkCapacity(int initialCapacity) {
		if(initialCapacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a list " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
		}

	}
	
	// Throws an exception if this object is not initialized.
	private void checkIntegrity(){
		if (!integrityOK)
				throw new SecurityException("ArrayBag object is corrupt.");
	} // end checkIntegrity

}
