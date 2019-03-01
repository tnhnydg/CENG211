package hw6.domain.customer;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


import hw6.domain.Customer;
import hw6.domain.CustomerType;

public class AdultCustomer extends Customer{

	public AdultCustomer(int age, char gender, String name) {
		
		super(age, gender, name);
		setType(CustomerType.ADULT);
		
	}
	
	public String toString() {
		return "Adult [super=" + super.toString() + "]";
	}
	
	public String toString2() {
		return "Adult [super=" + super.toString2() + "]";
	}

}
