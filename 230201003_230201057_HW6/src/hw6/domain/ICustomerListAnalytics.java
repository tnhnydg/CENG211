package hw6.domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */


public interface ICustomerListAnalytics {

	public boolean add(Customer customer);

	public int getNumberOfFemaleCustomers();

	public int getNumberOfMaleCustomers();

	public int getNumberOfSeniorCustomers();

	public int getNumberOfAdultCustomers();

	public int getNumberOfYoungCustomers();

}
