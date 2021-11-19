
package ToDoListPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGameClass {

    public static ArrayList<String> time = new ArrayList<>();
    public static ArrayList<String> task = new ArrayList<>();
    public static ArrayList<Boolean> ap = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the ToDoList!\n");

        createList(input);

        /*
         * while (there are still tasks) { //when the user hits enter pop a task from the stack
         * if(input.nextLine().equals("") { stack.pop() } }
         * System.out.println("Congratulations on completing your list!");
         */
        task tasks[] = new task[time.size()];
        Integer sortedTimes[] = new Integer[tasks.length];

        for (int i = 0; i <= time.size() - 1; i++) {
            System.out.printf("Task: %s, Time: %s, AM: %b%n", task.get(i), time.get(i), ap.get(i));
            tasks[i] = new task(task.get(i), ap.get(i), time.get(i));
            sortedTimes[i] = tasks[i].StringToInteger();
        }

        SortArray.selectionSort(sortedTimes, sortedTimes.length);
        for (int i = 0; i <= sortedTimes.length - 1; i++) {
            System.out.print(sortedTimes[i]);
        }
    }

    // a recursive method where the user adds tasks.
    // The user can add the task and time in this class and it gets added into the arraylists that
    // are initialized above in main
    // Then for the recursive part we can ask the user if they want to add more tasks. yes calls the
    // method again and no will end the recursive method
    public static void createList(Scanner input) {

        System.out.println("Enter the name of the task: ");
        String taskInput = input.nextLine();
        task.add(taskInput);

        System.out.println("Enter the time you want to complete this task (ex. 8:15): ");
        String timeInput = input.nextLine();
        time.add(timeInput);

        String ampm = "";
        while (!ampm.equals("AM") && !ampm.equals("PM")) {
            System.out.println("AM or PM? (Enter 'AM' or 'PM' as your answer): ");
            ampm = input.nextLine();
        }
        boolean result = false;
        if (ampm.equals("AM")) {
            result = true;
        } else if (ampm.equals("PM")) {
            result = false;
        }
        ap.add(result);

        // the user is asked if they want to add more tasks. entering y calls the method again, and
        // any other input will just end the method and the rest of the program will continue
        System.out.println("Do you want to add more tasks? (Enter 'y' to add more tasks): ");
        if (input.nextLine().equals("y")) {
            createList(input);
        }

        // This is where the object will be created with the name, time, and am/pm boolean

    }
}
