package ToDoListPackage;
import java.util.ArrayList;
import java.util.Scanner;
public class MainGameClass {

	public ArrayList<Integer> time = new ArrayList<>();
	public static ArrayList<String> task = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the ToDoList!");
		
		
		//Initialize the arraylists here. One for the names and one for the times of the tasks.
		//then the sorting class can be called here to sort the tasks
		
		
		
	}
	
	//a recursive method where the user adds tasks.
	//The user can add the task and time in this class and it gets added into the arraylists that are initialized above in main
	//Then for the recursive part we can ask the user if they want to add more tasks. yes calls the method again and no will end the recursive method
	public static void createList(Scanner input) {
		
	
		System.out.println("Enter the name of the task: ");
		String taskinput = input.next();
		//now add this task to the arraylist (somehow)
		
		
		System.out.println("Enter the time you want to complete this task: ");
		int time = input.nextInt();
		//now add this time to the other arraylist that is in main
		
		
		//the user is asked if they want to add more tasks. entering y calls the method again, and any other input will just end the method and the rest of the program will continue
		System.out.println("Do you want to add more tasks? (Enter 'y' to add more tasks): ");
		String ans = input.next();
		if (ans == "y") {
			createList(input);
		}
		
		
	}

}
