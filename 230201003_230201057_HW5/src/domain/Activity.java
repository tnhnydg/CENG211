package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public interface  Activity {
	
	public void setName(String name);
	public String getName();
	public void setStatus(ActivityStatus status);
	public ActivityStatus getStatus();
	public void setType(ActivityType type);
	public ActivityType getType();
	public String toString();
	
}
