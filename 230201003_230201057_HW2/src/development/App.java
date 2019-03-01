package development;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class App {

	public static void main(String[] args)	throws ParserConfigurationException, SAXException, IOException {

			ArrayList<University> universityList = new ArrayList<University>();
			ArrayList<Advisor> advisorList = new ArrayList<Advisor>();
			ArrayList<Student> studentList = new ArrayList<Student>();
			ArrayList<Thesis> thesisList = new ArrayList<Thesis>();
			
			DataAccessLayer layer = new DataAccessLayer("files//genealogy.xml");
			layer.initlizeObjects(universityList, advisorList, studentList, thesisList);
			
			Menu menu = new Menu();
			while (true){
				
				menu.start(universityList, advisorList, studentList, thesisList);
				
			}
	}
}
