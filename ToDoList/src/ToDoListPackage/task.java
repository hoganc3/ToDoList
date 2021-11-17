package ToDoListPackage;

public class task {
	String time;
	String task;
	boolean AmPm; //Am  = true Pm = false
	int val;
	int timeLength;
	
	public task(String task, boolean AmPm, String time) {
		
		this.time = time;
		this.AmPm = AmPm;
		this.task = task;
		timeLength = time.length();
		
	}
	
	private double StringToDouble() {
		String timeHours = new String("");
		String timeMin = new String("");
		
		//finds where the colon is in the String
		int colonPlace = 0;
		if(time.charAt(1)==':') {
			colonPlace = 1;
		}
		else if(time.charAt(2)==':'){
				colonPlace = 2;
		}
		
		//for loop to make String containing just the hours (before the colon)
		for(int i=0; i<colonPlace; i++) {
			timeHours += String.valueOf(time.charAt(i));
		}
		
		//for loop to make String containing just the minutes (after the colon)
		for(int i=colonPlace+1; i<time.length(); i++) {
			timeMin += String.valueOf(time.charAt(i));
		}
		
		//Changes the two Strings into integers
		int timeMinInt = Integer.valueOf(timeMin);
		int timeHoursInt = Integer.valueOf(timeHours);
		
		//Then changes from an integer to a decimal
		double timeM = (double) timeMinInt;
		System.out.println("This is timeM "+timeM);
		double timeH = (double) timeHoursInt;
		System.out.println("This is timeH "+timeH);
		
		//If its pm then 12 is added to the hours
		if(AmPm == false) {
			timeH += 12;
		}
		
		//Min are put into a decimal form ex) 30 min is 0.5 of an hour
		timeM = timeM / 60;
		
		//The two values(hours and minutes) are combined and returned
		double totTime = timeH+timeM;
		return totTime;
	}
	
	
		//Calls the String to Double method
	public String sortTime() {
		double totTime = StringToDouble();
		//Turns into a decimal form so that there are no double digits so that it can be sorted
		totTime = totTime / 10;
		//Turns back to a String to be sorted
		String newTime = Double.toString(totTime);
		return newTime;
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
//	public void toString() {
//		System.out.println(time+":");
//	}
}
