package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class MandatoryActivity implements Activity {
	
	private ActivityType type;
	private String name;
	private ActivityStatus status;

	public MandatoryActivity(String name) {
		setName(name);
		
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setStatus(ActivityStatus status) {
		this.status = status;
		
	}

	@Override
	public ActivityStatus getStatus() {
		return status;
	}

	@Override
	public void setType(ActivityType type) {
		this.type = type;
	}
	
	@Override
	public ActivityType getType() {
		return type;
	}
	
	public String toString() {
		
		return "\nName: " + getName() + getType() +"\nStatus: " + getStatus() + "\n";
	}
	
}
