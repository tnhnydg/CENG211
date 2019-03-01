package development;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class University {
	
	private String uName;
	private String uCountry;
	private int uFounded;
	
	public University(String uName, String uCountry, String uFounded)
	{
		setName(uName);
		setCountry(uCountry);
		setFounded(uFounded);
	}
	public void setName(String name)
	{
		this.uName = name;
	}
	public String getName()
	{
		return this.uName;
	}
	public void setCountry(String country)
	{
		this.uCountry = country;
	}
	public String getCountry()
	{
		return this.uCountry;
	}
	public void setFounded(String founded)
	{
		this.uFounded = Integer.parseInt(founded);
	}
	public Integer getFounded()
	{
		return this.uFounded;
	}
	public String toString() {
		return "University [name=" + uName + ", country=" + uCountry + ", foundationYear=" + uFounded
				+ "]";
	}

}
