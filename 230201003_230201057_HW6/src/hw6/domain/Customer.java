package hw6.domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


public abstract class Customer {
	private int age;
	private char gender;
	private String name;
	private CustomerType type;
	
	public Customer() {
		
		
	}
	
	public Customer(int age,char gender,String name) {
		setAge(age);
		setGender(gender);
		setName(name);
		
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public CustomerType getType() {
	
		return type;
	}
	
	public String toString() {
		
		return "Customer [age="+getAge()+", "+"gender="+getGender()+", "+"name="+getName()+", "+"type="+ getType() + "]";
	}
	
	public String toString2() {
		
		return "Customer [age="+getAge()+", "+"gender="+getGender()+", "+"name="+getName()+", "+"type="+ String.valueOf(getType()).substring(0, 1)+String.valueOf(type).toLowerCase().substring(1) + "]";
	}

}
