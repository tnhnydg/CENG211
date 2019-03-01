package development;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Student {
	
	private String sID;
	private String sName;
	private	ArrayList<University> sUniversityList;
	private Department department;
	private ArrayList<Advisor> sAdvisorList;
	private ArrayList<Thesis> thesisList;
	
	public Student(String sName, String sID, String department) 
	{
		setID(sID);
		setName(sName);
		setUniversityList(new ArrayList<University>());
		setDepartment(department);
		setAdvisorList(new ArrayList<Advisor>());
		setThesisList(new ArrayList<Thesis>());
	}
	public void setID(String ID)
	{
		this.sID = ID;
	}
	public String getID()
	{
		return this.sID;
	}
	public void setName(String Name)
	{
		this.sName = Name;
	}
	public String getName()
	{
		return this.sName;
	}
	public void setUniversityList(ArrayList<University> universityList)
	{
		this.sUniversityList = universityList;
	}
	public ArrayList<University> getUniversityList()
	{
		return this.sUniversityList;
	}
	public boolean addUniversity(University university)
	{
		boolean logic = false;
		if(!this.sUniversityList.contains(university))
		{
			this.sUniversityList.add(university);
			logic = true;
		}
		return logic;
	}
	public boolean removeUniversity(University university)
	{
		boolean logic = this.sUniversityList.remove(university);
		return logic;
	}
	public void setDepartment(String department)
	{
		this.department = Department.valueOf(department.toUpperCase());
	}
	public Department getDepartment()
	{
		return this.department;
	}
	public void setAdvisorList(ArrayList<Advisor> advisorList)
	{
		this.sAdvisorList = advisorList;
	}
	public ArrayList<Advisor> getAdvisorList()
	{
		return this.sAdvisorList;
	}
	public boolean addAdvisor(Advisor advisor)
	{
		boolean logic = false;
		if(!this.sAdvisorList.contains(advisor))
		{
			this.sAdvisorList.add(advisor);
			logic = true;
		}
		return logic;
	}
	public boolean removeAdvisor(Advisor advisor)
	{
		boolean logic = this.sAdvisorList.remove(advisor);
		return logic;
	}
	public void setThesisList(ArrayList<Thesis> thesisList)
	{
		this.thesisList = thesisList;
	}
	public ArrayList<Thesis> getThesisList()
	{
		return this.thesisList;
	}
	public boolean addThesis(Thesis thesis)
	{
		boolean logic = false;
		if(!this.thesisList.contains(thesis))
		{
			this.thesisList.add(thesis);
			logic = true;
		}
		return logic;
	}
	public boolean removeThesis(Thesis thesis)
	{
		boolean logic = this.thesisList.remove(thesis);
		return logic;
	}
	public String toString() {
		return "Student [name=" + sName + ", id=" + sID + ", departmentName=" + department
				+ "]";
	}
}
