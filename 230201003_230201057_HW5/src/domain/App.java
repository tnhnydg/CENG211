package domain;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import presentation.Menu;

public class App {
	
	public static ArrayList<Activity> activityList;
	
	public static String currentDate;

	public static void main(String[] args) {
		
		activityList = new ArrayList<Activity>();
				
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		currentDate= dateFormat.format(date);
			
		Menu menu = new Menu();
		menu.display(); 
	}

}
