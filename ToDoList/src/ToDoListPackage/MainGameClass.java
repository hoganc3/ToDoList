
package ToDoListPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGameClass {

    public static ArrayList<String> time = new ArrayList<>();
    public static ArrayList<String> task = new ArrayList<>();
    public static ArrayList<Boolean> ap = new ArrayList<>();
    public static int gameTime = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the ToDoList!\n");
        System.out.println("Instructions: ");
        System.out.println(
                "Type in your tasks then you will be prompt to press y when you are done.");
        System.out.println("Press enter to go through the day.");
        System.out.println("Type in the task to complete it.");
        System.out.println(
                "In order to win you must type in all your tasks before the time deadline you input for your tasks.");
        createList(input);

        /*
         * while (there are still tasks) { //when the user hits enter pop a task from the stack
         * if(input.nextLine().equals("") { stack.pop() } }
         * System.out.println("Congratulations on completing your list!");
         */
        task tasks[] = new task[time.size()];
        Integer sortedTimes[] = new Integer[tasks.length];

        tasks = sort(tasks, sortedTimes);
        System.out.println();
        for (int i = 0; i <= tasks.length - 1; i++) {
            System.out.printf("Task: %s, Time: %s, AM: %b%n", tasks[i].getTask(),
                    tasks[i].getTime(), tasks[i].getAmPm());
        }

        Stack<task> taskStack = createStack(tasks);

        System.out.println(taskStack);

        System.out.println(
                "Type out the task to mark it as complete. Press the enter key to skip 30 minutes into the day");
        while (!taskStack.isEmpty()) {
            task currentTask = taskStack.peek();
            if (input.nextLine().equals(currentTask.getTask())) {
                taskStack.pop();
                System.out.println(taskStack);
            }
            if (taskStack.isEmpty()) {
                break;
            }
            if (gameTime % 100 == 0) {
                gameTime += 30;
            } else {
                gameTime += 70;
            }
            if (gameTime % 100 != 0) {
                System.out.println(gameTime / 100 + ":30");

            } else {
                System.out.println(gameTime / 100 + ":00");
            }
            if (gameTime > taskStack.peek().integerTime) {
                System.out.println("You missed a task! Manage your time better next time.");
                System.exit(0);
            }
            if (gameTime >= 2400) {
                System.out.println("You ran out of time today. Try again tomorrow.");
                System.exit(0);
            }
        }

        System.out.println("Congratulations, you got all of your tasks done on the to-do list!");
    }

    // while(!taskStack.isEmpty()) {
    // if(input.nextLine().equals(""))
    // taskStack.pop();
    // }

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
        boolean valid = false;
        while (valid == false) {
            System.out.println("AM or PM? (Enter 'AM' or 'PM' as your answer): ");
            ampm = input.nextLine();
            switch (ampm) {
                case "AM":
                    ap.add(true);
                    valid = true;
                    break;
                case "PM":
                    ap.add(false);
                    valid = true;
                    break;
                default:
                    valid = false;
                    break;
            }

        }

        // the user is asked if they want to add more tasks. entering y calls the method again, and
        // any other input will just end the method and the rest of the program will continue
        System.out.println("Do you want to add more tasks? (Enter 'y' to add more tasks): ");
        if (input.nextLine().equals("y")) {
            createList(input);
        }

        // This is where the object will be created with the name, time, and am/pm boolean
    }

    public static task[] sort(task[] tasks, Integer[] sortedTimes) {
        for (int i = 0; i <= time.size() - 1; i++) {
            tasks[i] = new task(task.get(i), ap.get(i), time.get(i));
            sortedTimes[i] = tasks[i].StringToInteger();
        }

        SortArray.selectionSort(sortedTimes, sortedTimes.length);

        for (int i = 0; i <= sortedTimes.length - 1; i++) {
            for (int j = 0; j <= tasks.length - 1; j++) {
                if (sortedTimes[i] == tasks[j].getIntegerTime()) {
                    // Swap the position in tasks[] at j with i
                    task temp = tasks[i];
                    tasks[i] = tasks[j];
                    tasks[j] = temp;
                    // end swap
                }
            }
        }
        return tasks;
    }

    public static Stack<task> createStack(task[] tasks) {
        Stack<task> taskStack = new Stack<>();
        for (int i = tasks.length - 1; i > -1; i--) {
            taskStack.push(tasks[i]);
        }
        return taskStack;
    }
}
