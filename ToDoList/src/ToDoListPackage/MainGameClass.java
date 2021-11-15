package ToDoListPackage;
import java.util.ArrayList;
import java.util.Scanner;
public class MainGameClass {

	public static ArrayList<String> time = new ArrayList<>();
	public static ArrayList<String> task = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the ToDoList!\n");
		
		
		createList(input);
		
		System.out.print(time);
		System.out.print(task);	
		
		/*
		while (there are still tasks) {
			//when the user hits enter pop a task from the stack
			if(input.nextLine().equals("") {
			stack.pop()
			}
	}
	
	System.out.println("Congratulations on completing your list!");
	*/	
		
	}
	
	//a recursive method where the user adds tasks.
	//The user can add the task and time in this class and it gets added into the arraylists that are initialized above in main
	//Then for the recursive part we can ask the user if they want to add more tasks. yes calls the method again and no will end the recursive method
	public static void createList(Scanner input) {
		
		System.out.println("Enter the name of the task: ");
		String taskInput = input.nextLine();
		task.add(taskInput);
		
		
		System.out.println("Enter the time you want to complete this task (ex. 8:15): ");
		String timeInput = input.nextLine();
		time.add(timeInput);
		
		
		String ampm = "";
		while(!ampm.equals("AM") && !ampm.equals("PM")) {
			System.out.println("AM or PM? (Enter 'AM' or 'PM' as your answer): ");
			ampm = input.nextLine();
		}
		boolean result;
		if (ampm.equals("AM")) {
			result = true;
		}
		else if(ampm.equals("PM")) {
			result = false;
		}
		
		
		//the user is asked if they want to add more tasks. entering y calls the method again, and any other input will just end the method and the rest of the program will continue
		System.out.println("Do you want to add more tasks? (Enter 'y' to add more tasks): ");
		if (input.nextLine().equals("y")) {
			createList(input);
		}
		
		
		//This is where the object will be created with the name, time, and am/pm boolean
		
		
	}
}
