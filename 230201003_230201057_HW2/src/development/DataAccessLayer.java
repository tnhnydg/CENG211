package development;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class DataAccessLayer {
	
	private String path;

	public DataAccessLayer(String path)
	{
		setPath(path);
	}
	public Document readFile() throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(path);
		
		return doc;	
	}
	public University universityChecker(String name, String country, String founded, ArrayList<University> universityList)
	{
		University university=null;
		for(int i=0; i < universityList.size(); i++)
		{
			if(universityList.get(i).getName().equals(name))
			{
				university = universityList.get(i);
				break;
			}
		}
		if(university == null)
		{
			university = new University(name, country, founded);
			universityList.add(university);
		}
		return university;
	}
	public Advisor advisorChecker(String name, ArrayList<Advisor> advisorList)
	{
		Advisor advisor = null;
		for(int i=0; i < advisorList.size(); i++)
		{
			if(advisorList.get(i).getName().equals(name))
			{
				advisor = advisorList.get(i);
				break;
			}
		}
		if(advisor == null)
		{
			advisor = new Advisor(name);
			advisorList.add(advisor);
		}
		return advisor;
	}
	public Student studentChecker(String name, String ID, String department, ArrayList<Student> studentList)
	{
		Student student = null;
		for(int i=0; i < studentList.size(); i++)
		{
			if(studentList.get(i).getName().equals(name))
			{
				student = studentList.get(i);
				break;
			}
		}
		if(student == null)
		{
			student = new Student(name, ID, department);
			studentList.add(student);
		}
		return student;
	}
	public Thesis thesisChecker(String name, Student student, String year, ArrayList<Thesis> thesisList)
	{
		Thesis thesis = null;
		for(int i=0; i < thesisList.size(); i++)
		{
			if(thesisList.get(i).getName().equals(name))
			{
				thesis = thesisList.get(i);
				break;
			}
		}
		if(thesis == null)
		{
			thesis = new Thesis(name,student, year);
			thesisList.add(thesis);
		}
		return thesis;
	}
	public void initlizeObjects(ArrayList<University> universityList, ArrayList<Advisor> advisorList, ArrayList<Student> studentList, ArrayList<Thesis> thesisList) throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = readFile();
		NodeList advisorListFile = doc.getElementsByTagName("Advisor");
		for(int i0=0; i0<advisorListFile.getLength(); i0++)
		{	String uName = null, uCountry=null, uFounded=null;
			Node a = advisorListFile.item(i0);
			if(a.getNodeType() == Node.ELEMENT_NODE)
			{
				Element advisor = (Element) a;
				String aName = advisor.getAttribute("name");
				
				NodeList studentListFile = advisor.getChildNodes();
				
				for (int i1=0; i1<studentListFile.getLength(); i1++)
				{
					String tName=null, tYear=null,dName = null;
					Node s = studentListFile.item(i1);
					if(s.getNodeType() == Node.ELEMENT_NODE)
					{
						Element student = (Element) s;
						String sName=student.getAttribute("name");
						String sID = student.getAttribute("id");
						
						NodeList studentChild =student.getChildNodes();
					
						Node t = studentChild.item(1);
						if(t.getNodeType() == Node.ELEMENT_NODE)
						{
						Element thesis = (Element) t;
						tName = thesis.getAttribute("name");
						tYear = thesis.getAttribute("year");
						}
						
						Node u =studentChild.item(3);
						if(u.getNodeType() == Node.ELEMENT_NODE)
						{
							Element university = (Element) u;
							uName = university.getAttribute("name");
							uCountry = university.getAttribute("country");
							uFounded = university.getAttribute("foundedYear");					
						}
				
						Node d =studentChild.item(5);
						if(d.getNodeType() == Node.ELEMENT_NODE)
						{
							Element department = (Element) d;
							dName = department.getAttribute("name");
						}
						
						University universityObj = universityChecker(uName, uCountry, uFounded, universityList);
						Student studentObj = studentChecker(sName, sID, dName, studentList);
						Thesis thesisObj = thesisChecker(tName, studentObj,tYear, thesisList);
						Advisor advisorObj = advisorChecker(aName, advisorList);
						
						//Student
						studentObj.addUniversity(universityObj);
						studentObj.addAdvisor(advisorObj);
						studentObj.addThesis(thesisObj);
						
						//Thesis
						thesisObj.addUniversity(universityObj);
						thesisObj.addAdvisor(advisorObj);
						
						//Advisor
						advisorObj.addThesis(thesisObj);
						advisorObj.addUniversity(universityObj);
						advisorObj.addStudent(studentObj);
						
					}
				}
			}
		}
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getPath()
	{
		return this.path;
	}

}
