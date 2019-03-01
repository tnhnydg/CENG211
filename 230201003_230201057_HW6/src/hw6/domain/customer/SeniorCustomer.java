package hw6.domain.customer;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


import hw6.domain.Customer;
import hw6.domain.CustomerType;

public class SeniorCustomer extends Customer {
	
	public SeniorCustomer(int age, char gender, String name) {
	
		super(age, gender, name);
		setType(CustomerType.SENIOR);
		
	}
	
	public String toString() {
		return "Senior [super=" + super.toString() + "]";
	}
	
	public String toString2() {
		return "Senior [super=" + super.toString2() + "]";
	}

}
