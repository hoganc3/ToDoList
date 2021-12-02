
package ToDoListPackage;

public class task {
    String time;
    String task;
    boolean AmPm; // Am = true Pm = false
    int val;
    int timeLength;
    int order;
    int integerTime;

    public task(String task, boolean AmPm, String time) {

        this.time = time;
        this.AmPm = AmPm;
        this.task = task;
        timeLength = time.length();

    }

    // Takes the String time and converts to an Integer military time
    public int StringToInteger() {

        String toTime = new String("");

        // replaces ":" with nothing
        this.time = this.time.replace(":", "");

        // Changes the String to an integer
        this.integerTime = Integer.valueOf(this.time);

        // If its pm then 1200 is added to the hours (24 hour time)
        if (AmPm == false && integerTime != 1200) {
            integerTime += 1200;
        } else if (integerTime == 1200) {
            if (AmPm == true) {
                integerTime += -1200;
            }
        }

        // returns value
        return integerTime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setAmPm(boolean AmPm) {
        this.AmPm = AmPm;
    }

    public boolean getAmPm() {
        return AmPm;
    }

    public String getTask() {
        return task;
    }

    /*
     * I'm not sure how we want to do this but we could take the array indexes of the sorted array
     * and set the value into the task object could be easier to put into a stack I'm not sure just
     * an idea
     */
    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public int getIntegerTime() {
        return integerTime;
    }

    public String toString() {
        if (AmPm) {
            return task + " " + time + " AM";
        } else
            return task + " " + time + " PM";
    }

}
