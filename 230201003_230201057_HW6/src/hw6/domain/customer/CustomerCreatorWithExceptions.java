package hw6.domain.customer;
import hw6.domain.Customer;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class CustomerCreatorWithExceptions {
	
	public CustomerCreatorWithExceptions() {
		
		
	}

	public Customer createCustomer(int age, char gender, String name) throws IllegalArgumentException {
		
		checkAge(age);
		checkGender(gender);
		checkName(name);
		
		Customer customer = null;
		
		if(age>=60) {
			
			//create senior;
			customer = new SeniorCustomer(age, gender, name);
		}
		else if(age>=30 && age<=59) {
			
			//create adult
			customer = new AdultCustomer(age, gender, name);
		}
		else if(age>=18 && age<=29) {
			
			//create young
			customer =  new YoungCustomer(age, gender, name);
		}

		return customer;
	}
	
	private void checkAge(int age) throws IllegalArgumentException {
		
		if(!(age>=18 && age<=79)) {
			
			throw new IllegalArgumentException("Invalid Age Parameter");
		}
		
	}
	
	private void checkGender(char gender) throws IllegalArgumentException {
		
		if(!(gender == 'f' || gender == 'F' || gender =='m' || gender == 'M')) {
			
			throw new IllegalArgumentException("Invalid Gender Parameter");
		}
		
	}
	
	private void checkName(String name) throws IllegalArgumentException {
		
		if(name == null || name.length()>20) {
			
			throw new IllegalArgumentException("Invalid Name Parameter! Name can not be null or longer than 20 char");
		}
	}
	
}
