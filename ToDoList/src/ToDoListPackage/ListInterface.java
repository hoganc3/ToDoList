package ToDoListPackage;

public interface ListInterface<T> {
	
	public void addEntry(T entry);
	
	public void add(int newPosition, T newEntry);
	
	public T remove(int givenPosition);
	
	public void clear();
	
	public T replace(int givenPosition, T newEntry);
	
	public T getEntry(int givenPosition);
	
	public T[] toArray();
	
	public boolean contains(T anEntry);
	
	public int getLength();
	
	public boolean isEmpty();
}
