package ToDoListPackage;

public class task {
	String time;
	String task;
	boolean AmPm; //Am  = true Pm = false
	int val;
	int timeLength;
	int order;
	
	public task(String task, boolean AmPm, String time) {
		
		this.time = time;
		this.AmPm = AmPm;
		this.task = task;
		timeLength = time.length();
		
	}
	
	//Takes the String time and converts to an Integer military time
	public int StringToInteger() {
		
		String totTime = new String("");
		
		//finds where the colon is in the String
		int colonPlace = 0;
		if(time.charAt(1)==':') {
			colonPlace = 1;
		}
		else if(time.charAt(2)==':'){
				colonPlace = 2;
		}
		
		
		//for loop to make String removing the colon
		for(int i=0; i<time.length(); i++) {
			if(i == colonPlace) {
				
			}else {
				totTime += String.valueOf(time.charAt(i));
			}
		}
		
		//Changes the String to an integer
		int totTimeInt = Integer.valueOf(totTime);
		
		
		
		//If its pm then 1200 is added to the hours (24 hour time)
		if(AmPm == false) {
			totTimeInt += 1200;
		}
		
		//returns value
		return totTimeInt;
	}
	
	
	public void setTime(String time) {
		this.time=time;
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
	
	/*I'm not sure how we want to do this but we could take 
	the array indexes of the sorted array and set the value 
	into the task object could be easier to put into a stack 
	I'm not sure just an idea */
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}

}