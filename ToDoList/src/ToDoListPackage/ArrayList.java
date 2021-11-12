package ToDoListPackage;

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
		T[] tempList = (T[]) new Object(initialCapacity+1);
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	}
	
	public void addEntry(T entry) {
		// TODO Auto-generated method stub
		
	}

	
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
	}

	
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
