package hw6.domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


import java.util.ArrayList;

public class CustomerListAnalyticsImpl implements ICustomerListAnalytics {
	
	private ArrayList<Customer> customerList = new ArrayList<>();

	public CustomerListAnalyticsImpl() {
		
	}
	
	@Override
	public boolean add(Customer customer) {
		boolean logic = false;
		if(customer == null) {
			logic = false;
		}
		else {
			customerList.add(customer);
			logic = true;
		}
		return logic;
	}

	@Override
	public int getNumberOfFemaleCustomers() {
		int count = 0;
		for(Customer c : customerList) {
			if(c.getGender() == 'f' || c.getGender() == 'F') {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getNumberOfMaleCustomers() {
		int count = 0;
		for(Customer c : customerList) {
			if(c.getGender() == 'm' || c.getGender() == 'M') {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getNumberOfSeniorCustomers() {
		int count = 0;
		for(Customer c : customerList) {
			if(c.getType() == CustomerType.SENIOR) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getNumberOfAdultCustomers() {
		int count = 0;
		for(Customer c : customerList) {
			if(c.getType() == CustomerType.ADULT) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getNumberOfYoungCustomers() {
		int count = 0;
		for(Customer c : customerList) {
			if(c.getType() == CustomerType.YOUNG) {
				count++;
			}
		}
		return count;
	}
	
	public String toString() {
		String listString = "";
		for(int i=0;i<customerList.size()-1;i++) {
			listString += customerList.get(i).toString2() + "," + " ";
		}
		listString += customerList.get(customerList.size()-1).toString2();
		
		return "CustomerListImpl [buyers=[" + listString +"]]";
	}
	
	/*public String toString() {
		return "CustomerListImpl [buyers=" + customerList.toString()+"]";
	}*/ 
	//Since tostrings in the testcases doesn't match, we didn't use this method.
}
