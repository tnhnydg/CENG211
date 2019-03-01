package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public abstract class ActivityType {
	
	private Activity activity;
	private int repetition;
	private String deadline; // date as dd/mm/yyyy (if None, 99/99/9999)
	private String date;
	
	public ActivityType() {
		System.out.println("No argument constructor executed");
	}
	
	public ActivityType(String date) {
		setDate(date);
	}
	
	public ActivityType(String date, RoutineType repetition) {
		
		setRepetition(repetition);
		setDate(date);			
	}
	
	public void postpone(String date) {
		
		setDate(date);	
	}

	public void updateActivityStatus(String currentDate) {

		if(compareDates(this.date, currentDate) == 0 || (compareDates(this.date, currentDate) == 1 && getDeadline() != null && getDeadline() != "99/99/9999" && compareDates(getDeadline(),currentDate) == 2 )){
			getActivity().setStatus( ActivityStatus.STARTED);
		}
		else if(compareDates(this.date, currentDate) == 1){
			getActivity().setStatus( ActivityStatus.DONE); 
		}
		else if(compareDates(this.date, currentDate) == 2) {
			getActivity().setStatus( ActivityStatus.PENDING);
		}
	}
	
	public int compareDates(String date1, String date2){ //0 for equal, 1 for left one is before, 2 for right one is before
	
		String[] s1 = date1.split("/");
		String[] s2 = date2.split("/");
		String d1,m1,y1,d2,m2,y2;//day,year,month
		d1 = s1[0]; m1 = s1[1]; y1 = s1[2];
		d2 = s2[0]; m2 = s2[1]; y2 = s2[2];
		if(y1.equals(y2)){
			if(m1.equals(m2)){
				if(d1.equals(d2)){
					return 0;
				}
				else{
					if(Integer.parseInt(d1)<Integer.parseInt(d2)){
						return 1;
					}
					else{
						return 2;
					}
				}
			}
			else{
				if(Integer.parseInt(m1)<Integer.parseInt(m2)){
					return 1;
				}
				else{
					return 2;
				}
			}
		}
		else{
			if(Integer.parseInt(y1)<Integer.parseInt(y2)){
				return 1;
			}
			else{
				return 2;
			}
		}
	}
	
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public void setRepetition(RoutineType repetition){
		if(repetition.equals(RoutineType.DAILY)) {
			this.repetition = 1;
		}
		else if(repetition.equals(RoutineType.WEEKLY)) {
			this.repetition = 7;
		}
		else if(repetition.equals(RoutineType.MONTHLY)) {
			this.repetition = 30;
		}
		else if(repetition.equals(RoutineType.CUSTOM)) {
			//You should call overloaded setRepetition(int)
		}
		else {
			System.out.println("Problem occured!");
		}
		
	}
	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}

	public int getRepetition(){
		return repetition;
	}
	
	public void setDate(String date) {
		this.date = date;
		
	}

	public String getDate() {
		return date;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
		
	}
	
	public Activity getActivity() {
	
		return this.activity;
	}
	
}

