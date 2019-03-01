package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public abstract class  Nutrition {
	
	private String name;
	private int unit;
	private int calorie;
	private NutritionType type;
	
	
	public Nutrition () {
		
	}
	
	public Nutrition (String name, int unit, int calorie, NutritionType type) {
		setName(name);
		setUnit(unit);
		setCalorie(calorie);
		setType(type);
		
	}
	
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public NutritionType getType() {
		return type;
	}

	public void setType(NutritionType type) {
		this.type = type;
	}
	
	public String toString() {
		
		return "Nutrition  = ["+getName()+","+getUnit()+","+getCalorie()+","+ getType()+ "," + (String.valueOf(this.getClass())).split("\\.")[1] +"]";	
	}

}
