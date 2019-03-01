package development;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Advisor {
	
	private String aName;
	private ArrayList<Thesis> aThesisList; //supervised
	private ArrayList<University> aUniversityList;
	private University currentUniversity; // university that the advisor currently works. 
	private ArrayList<Student> aStudentList;
	
	public Advisor(String aName)
	{	
		setName(aName);
		setThesisList(new ArrayList<Thesis>());
		setUniversityList(new ArrayList<University>());
		setStudentList(new ArrayList<Student>());
	}
	public void setName(String aName)
	{
		this.aName = aName;
	}
	public String getName()
	{
		return this.aName;
	}
	public void setThesisList(ArrayList<Thesis> thesisList)
	{
		this.aThesisList = thesisList;
	}
	public ArrayList<Thesis> getThesisList()
	{
		return this.aThesisList;
	}
	public boolean addThesis(Thesis thesis)
	{
		boolean logic = false;
		if(!this.aThesisList.contains(thesis))
		{
			this.aThesisList.add(thesis);
			logic = true;
		}
		return logic;
	}
	public boolean removeThesis(Thesis thesis)
	{
		boolean logic = this.aThesisList.remove(thesis);
		return logic;
	}
	public void setUniversityList(ArrayList<University> universityList)
	{
		this.aUniversityList = universityList;
	}
	public ArrayList<University> getUniversityList()
	{
		return this.aUniversityList;
	}
	public boolean addUniversity(University university)
	{
		boolean logic=false;
		if(!this.aUniversityList.contains(university))
		{
			this.aUniversityList.add(university);
			logic = true;
		}
		return logic;
	}
	public boolean removeUniversity(University university)
	{
		boolean logic = this.aUniversityList.remove(university);
		return logic;
	}
	public void setCurrentUniversity(University university)
	{
		this.currentUniversity = university;
	}
	public University getCurrentUniversity()
	{
		return this.currentUniversity;
	}
	public void setStudentList(ArrayList<Student> studentList)
	{
		this.aStudentList = studentList;
	}
	public ArrayList<Student> getStudentList()
	{
		return this.aStudentList;
	}
	public boolean addStudent(Student student)
	{
		boolean logic=false;
		if(!this.aStudentList.contains(student))
		{
			this.aStudentList.add(student);
			logic = true;
		}
		return logic;
	}
	public boolean removeStudent(Student student)
	{
		boolean logic = this.aStudentList.remove(student);
		return logic;
	}
	public String toString() {
		return "Advisor [name=" + aName + "]";
	}
}
