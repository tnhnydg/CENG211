package development;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Thesis {
	private String tName;
	private Student student;
	private ArrayList<University> tUniversityList;
	private int tYear;
	private ArrayList<Advisor> tAdvisorList;
	
	public Thesis(String tName,Student student, String tYear)
	{
		setName(tName);
		setStudent(student);
		setUniversityList(new ArrayList<University>());
		setYear(tYear);
		setAdvisorList(new ArrayList<Advisor>());
	}
	
	public void setName(String name)
	{
		this.tName = name;
	}
	public String getName()
	{
		return this.tName;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public Student getStudent()
	{
		return this.student;
	}
	public void setUniversityList(ArrayList<University> universityList)
	{
		this.tUniversityList = universityList;
	}
	public ArrayList<University> getUniversityList()
	{
		return this.tUniversityList;
	}
	public boolean addUniversity(University university)
	{
		boolean logic = false;
		if(!this.tUniversityList.contains(university))
		{
			this.tUniversityList.add(university);
			logic = true;
		}
		return logic;
	}
	public boolean removeUniversity(University university)
	{
		boolean logic = this.tUniversityList.remove(university);
		return logic;
	}
	public void setYear(String year)
	{
		this.tYear = Integer.parseInt(year);
	}
	public Integer getYear()
	{
		return this.tYear;
	}
	public void setAdvisorList(ArrayList<Advisor> advisorList)
	{
		this.tAdvisorList = advisorList;
	}
	public ArrayList<Advisor> getAdvisorList()
	{
		return this.tAdvisorList;
	}
	public boolean addAdvisor(Advisor advisor)
	{
		boolean logic = false;
		if(!this.tAdvisorList.contains(advisor))
		{
			this.tAdvisorList.add(advisor);
			logic = true;
		}
		return logic;
	}
	public boolean removeAdvisor(Advisor advisor)
	{
		boolean logic = this.tAdvisorList.remove(advisor);
		return logic;
	}
	
	public String toString() {
		return "Thesis [name=" + tName + ", student=" + student.getName() + ", publishedYear=" + tYear
				+ "]";
	}
}
