package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class RoutineActivityType extends ActivityType {

	public RoutineActivityType(String date, RoutineType repetition) {
	
		super(date, repetition);
		
	}
	
	public String toString() {
		String deadline = getDeadline();
		if(getDeadline() =="99/99/9999" || getDeadline() == null) {
			deadline="None";
		}
		return "\nDate: " + getDate() + "\nPeriod(day): " + getRepetition() + "\nDeadLine: " + deadline;
		
	}

}
