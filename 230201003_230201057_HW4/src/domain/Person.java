package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Person {
	
	private String name;
	private double weight; 
	private double height;
	private int age;
	private Gender gender;
	private Meal[] mealList;

	
	public Person(String name, double weight, double height, int age, Gender gender) {
		setName(name);
		setWeight(weight);
		setHeight(height);
		setAge(age);
		setGender(gender);
		setMealList(new Meal[3]);
			
	}
	public void addBreakfast(Breakfast breakfast) {
		
		getMealList()[0] = breakfast;
	}
	public void addLunch(Lunch lunch) {
		
		getMealList()[1] = lunch;
	}
	
	public void addDinner(Dinner dinner) {
		
		getMealList()[2] = dinner;
	}
	
	public double dailyOptCalorie(){ 
		
		int num;
		if(this.getGender() == Gender.FEMALE){
			num = -161;
		}
		else{
			num = 5;
		}
		return 10*this.getWeight() + 6.25*this.getHeight() - 5*this.getAge() + num;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Meal[] getMealList() {
		return mealList;
	}

	public void setMealList(Meal[] mealList) {
		this.mealList = mealList;
	}
	
	public String toString() {
		
		return "Person= [" +getName() + "," + getWeight() + "," + getHeight() + "," + getAge() + "," + getGender() +"\n" + getMealList()[0] +"\n" + getMealList()[1] +"\n"+ getMealList()[2] + "]";

	}
	

}
