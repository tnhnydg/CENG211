package hw6.domain.customer;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


import hw6.domain.Customer;
import hw6.domain.CustomerType;

public class YoungCustomer extends Customer {
	
	public YoungCustomer(int age, char gender, String name) {
		
		super(age, gender, name);
		setType(CustomerType.YOUNG);
	
	}
	
	public String toString() {
		return "Young [super=" + super.toString() + "]";
	}
	
	public String toString2() {
		return "Young [super=" + super.toString2() + "]";
	}

}
