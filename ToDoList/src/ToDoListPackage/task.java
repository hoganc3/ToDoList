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
		char[] charToString = new char[timeLength];
		String timeHours = "";
		String timeMin = "";
		
		//gets rid of colon
		boolean min = false; //still looking at hours, true if looking at minutes
		for(int i=0; i<time.length(); i++) {
			if(charToString[i]==':') {
				min = true;
			}else {
				if(min = true) {
					timeMin += charToString;
				}
				timeHours += charToString;
			}
			
		}
		double timeH = Double.parseDouble(timeHours);
		double timeM = Double.parseDouble(timeMin);
		
		if(AmPm == false) {
			timeH += 12;
		}
		
		timeM = timeM / 60;
		
		double totTime = timeH+timeM;
		return totTime;
	}
	
	public String sortTime() {
		double totTime = StringToDouble();
		totTime = totTime / 10;
		String newTime = Double.toString(totTime);
		return newTime;
	}
	
	public void setTime(String time) {
		this.time=time;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(boolean AmPm) {
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
