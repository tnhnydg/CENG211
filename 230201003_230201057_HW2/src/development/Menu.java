package development;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Menu {

	public Menu()
	{
		show();
	}
	private void show()
	{
		System.out.println("<<<<Welcome to Academic Extended Search Application>>>>");
	}
	public void start(ArrayList<University> universityList, ArrayList<Advisor> advisorList, ArrayList<Student> studentList, ArrayList<Thesis> thesisList) throws IOException
	{
		String input=null;
		System.out.print("\n");
		System.out.println("1-Listing all theses by department and university");
		System.out.println("2-Listing all acedemicians that are both advisor and student");
		System.out.println("3-Listing all theses in chronological order by advisor");
		System.out.println("4-Finding the country that has the most number of published theses");
		System.out.println("5-Listing all universities by advisor");
		System.out.println("6-Exit");
		System.out.println(">Please type an option 1-6 to interact:");
		input = takeInput();
	
		switch(input) {
		case "1":
			option1(thesisList); break;
		case "2":
			option2(advisorList, studentList); break;
		case "3":
			option3(advisorList); break;
		case "4":
			option4(thesisList); break;
		case "5":
			option5(advisorList); break;
		case "6":
			System.exit(0); break;
		default:
			System.out.print("Invalid option choice!"); break;
		}
		
	}
	
	public String takeInput() throws IOException
	{
		String input=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		return input;
	}
	
	public void option1(ArrayList<Thesis> thesisList) throws IOException
	{
		String uName=null, dName=null;
		System.out.println("1-Listing all theses by department and university");
		System.out.println("University:");
		uName=takeInput();
		System.out.println("Department:");
		dName=takeInput();
		
		for(int i=0; i <thesisList.size(); i++ )
		{
			for(int j=0; j < thesisList.get(i).getUniversityList().size(); j++)
			{
				//most of the time loop turn once so there is no problem.
				if(thesisList.get(i).getUniversityList().get(j).getName().equals(uName) && 
					thesisList.get(i).getStudent().getDepartment().equals(Department.valueOf(dName.toUpperCase())))
				{
					System.out.println(thesisList.get(i).getName());
				}
				
			}
		}
		
	}
	
	public void option2(ArrayList<Advisor> advisorList, ArrayList<Student> studentList)
	{
		System.out.println("2-Listing all acedemicians that are both advisor and student");
		
		for(int i=0; i < advisorList.size(); i++)
		{
			for(int j=0; j < studentList.size(); j++)
			{
				if(advisorList.get(i).getName().equals(studentList.get(j).getName()))
				{
					System.out.println(advisorList.get(i).getName());
					break; //there is no duplicate in the list so there is no need to continue once we found the advisor
				}
				
			}
		}
		
		
	}
	
	public void option3(ArrayList<Advisor> advisorList) throws IOException
	{
		System.out.println("3-Listing all theses in chronological order by advisor");
		System.out.println("Advisor:");
		String aName = takeInput();
	
		for(int i=0; i < advisorList.size(); i++)
		{
			if(advisorList.get(i).getName().equals(aName))
			{
				Collections.sort(advisorList.get(i).getThesisList(), new Comparator<Thesis>(){   // sorts the list in chronological order
					public int compare(Thesis a, Thesis b)
					  {
					     return Integer.compare(a.getYear(),b.getYear());
					  }
				});
				for(int j=0; j < advisorList.get(i).getThesisList().size(); j++)
				{
					System.out.print(advisorList.get(i).getThesisList().get(j).getYear()+"-");
					System.out.println(advisorList.get(i).getThesisList().get(j).getName());
				}			
			}
			
		}
		
	}
	
	public void option4(ArrayList<Thesis> thesisList)
	{
		System.out.println("4-Finding the country that has the most number of published theses");
		
		ArrayList<String> cCounter = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for(int i=0; i<thesisList.size(); i++)
		{
			for(int j=0; j < thesisList.get(i).getUniversityList().size(); j++)
			{
				//most of the time inner loop will turn once so there is no problem.
				cCounter.add(thesisList.get(i).getUniversityList().get(j).getCountry());
				set.add(thesisList.get(i).getUniversityList().get(j).getCountry());	
			}	
		}
		temp.addAll(set);
		int max=0,value=0;
		String maxCountry=null;
		for(int i=0; i < temp.size(); i++)
		{
			value = Collections.frequency(cCounter,temp.get(i));
			if(value > max)
			{
				max=value; 
				maxCountry=temp.get(i);
			}
		}
		
		System.out.println(maxCountry);
	}
	
	public void option5(ArrayList<Advisor> advisorList) throws IOException
	{
		System.out.println("5-Listing all universities by advisor");
		System.out.println("Advisor:");
		String aName = takeInput();
		
		for(int i=0; i < advisorList.size(); i++)
		{
			if(advisorList.get(i).getName().equals(aName))
			{
				for(int j=0; j<advisorList.get(i).getUniversityList().size(); j++)
				{
					System.out.println(advisorList.get(i).getUniversityList().get(j).getName());
				}
				break; //no duplicate so no need for further search
			}
			
		}
	}
}
