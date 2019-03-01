package presentation;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import domain.Activity;
import domain.ActivityType;
import domain.App;
import domain.HobbyActivity;
import domain.MandatoryActivity;
import domain.RoutineActivityType;
import domain.RoutineType;
import domain.SingleDayActivityType;

public class Menu {
	
	public Menu() {
		
		System.out.println("<<<Welcome to TODO List App>>>");
		System.out.println("Current Date : " + App.currentDate);
	}
	
	public void display() {
		
		//option0
		System.out.println("<<Main Menu>>");
		System.out.println("\t1-Create Activity");
		System.out.println("\t2-Set Current Date");
		System.out.println("\t3-Postpone Hobby Activity");
		System.out.println("\t4-View TODO List");
		System.out.println("\t5-View Any Specific Date's Activities");
		System.out.println("\t6-Quit");
		
		String input = takeInput();
		if(input.equals("1")) {
			option1();
		}
		else if(input.equals("2")) {
			option2();
		}
		else if(input.equals("3")) {
			option3();
		}
		else if(input.equals("4")) {
			option4();
		}
		else if(input.equals("5")) {
			option5();
		}
		else if(input.equals("6")) {
			System.exit(0);
		}
			
	}
	
	public Activity createActivity(String name, String date, RoutineType repetition, String activitySub) {
		
		//activitySub "M"->Mandatory, "H"->Hobby
		Activity activity=null;
		if(activitySub == "M") {
			if(repetition != null) {
			
				activity = new MandatoryActivity(name);
				ActivityType routine = new RoutineActivityType(date, repetition);
			
				
				activity.setType(routine);
				routine.setActivity(activity);
				
				routine.updateActivityStatus(App.currentDate);
			
			}
			else if(repetition == null) {
			
				activity = new MandatoryActivity(name);
				ActivityType single = new SingleDayActivityType(date);
			
				
				activity.setType(single);
				single.setActivity(activity);
				
				single.updateActivityStatus(App.currentDate);
				
			}
		}
		else if(activitySub == "H") {
				
			if(repetition != null) {
				
				activity = new HobbyActivity(name);
				ActivityType routine = new RoutineActivityType(date, repetition);
			
			
				activity.setType(routine);
				routine.setActivity(activity);
				
				routine.updateActivityStatus(App.currentDate);
				
				
			}
			else if(repetition == null) {
				
				activity = new HobbyActivity(name);
				ActivityType single = new SingleDayActivityType(date);
			
				
				activity.setType(single);
				single.setActivity(activity);
				
				single.updateActivityStatus(App.currentDate);
			
			}
			
		}
		else {
			System.out.println("activitySub expected 'M' or 'H' ");
		}
		if( activity==null) {
			System.out.println("Hoba");
		}

		return activity;
	}
	
	public void option1() {
		System.out.println("<<TODO List Menu>>");
		System.out.println("\t1-Add Mandatory Activity");
		System.out.println("\t2-Add Hobby Activity");
		System.out.println("\t3-Main Menu");
		
		String input = takeInput();
		String name,date;
		
		if(input.equals("1")) {
			System.out.println("Activity Name:");
			name = takeInput();
			System.out.println("Activity Date 'dd/mm/yyyy':");
			date = takeInput();
			System.out.println("<Repetition Option>");
			System.out.println("\t1-None\n\t2-Daily\n\t3-Weekly\n\t4-Monthly\n\t5-Custom");
			boolean hasDeadline = true;
			input = takeInput();
		
			switch (input) {
			case "1":
				App.activityList.add(createActivity(name, date, null,"M"));
				hasDeadline = false;
				break;
				
			case "2":
				App.activityList.add(createActivity(name, date, RoutineType.DAILY, "M"));
				break;
			case "3":
				App.activityList.add(createActivity(name, date, RoutineType.WEEKLY, "M"));
				break;
			case "4":
				App.activityList.add(createActivity(name, date, RoutineType.MONTHLY, "M"));
				break;
			case "5":
				System.out.println("Please enter your repetition frequency :");
				input = takeInput();
				
				Activity activity = new MandatoryActivity(name);
				ActivityType routine = new RoutineActivityType(date, RoutineType.CUSTOM);
				
				routine.setRepetition(Integer.parseInt(input));
				activity.setType(routine);
				routine.setActivity(activity);
				
				routine.updateActivityStatus(App.currentDate);
				
				App.activityList.add(activity);
				break;
			}
			if(hasDeadline == true){
				System.out.println("<Deadline Option>");
				System.out.println("\t1-None\n\t2-Add");
				input = takeInput();
				switch (input) {
				case "1":
					App.activityList.get(App.activityList.size()-1).getType().setDeadline("99/99/9999");
					break;
				case "2":
					System.out.println("Enter the deadline :");
					input = takeInput();
					App.activityList.get(App.activityList.size()-1).getType().setDeadline(input);
					break;
				}
			}
			option1();
		}
		else if(input.equals("2")) {
			System.out.println("Activity Name:");
			name = takeInput();
			System.out.println("Activity Date 'dd/mm/yyyy':");
			date = takeInput();
			System.out.println("<Repetition Option>");
			System.out.println("\t1-None\n\t2-Daily\n\t3-Weekly\n\t4-Monthly\n\t5-Custom");
			boolean hasDeadline = true;
			input = takeInput();
			
			switch (input) {
			case "1":
				App.activityList.add(createActivity(name, date, null, "H"));
				hasDeadline = false;
				break;
			case "2":
				App.activityList.add(createActivity(name, date, RoutineType.DAILY, "H"));
				break;
			case "3":
				App.activityList.add(createActivity(name, date, RoutineType.WEEKLY, "H"));
				break;
			case "4":
				App.activityList.add(createActivity(name, date, RoutineType.MONTHLY, "H"));
				break;
			case "5":
				System.out.println("Please enter your repetition frequency :");
				input = takeInput();
				
				Activity activity = new HobbyActivity(name);
				ActivityType routine = new RoutineActivityType(date, RoutineType.CUSTOM); //CUSTOM choice do nothing in class
				
				routine.setRepetition(Integer.parseInt(input));
				activity.setType(routine);
				routine.setActivity(activity);
				
				routine.updateActivityStatus(App.currentDate);
				
				App.activityList.add(activity);
				break;
			}
			if(hasDeadline == true){
				System.out.println("<Deadline Option>");
				System.out.println("\t1-None\n\t2-Add");
				input = takeInput();
				switch (input) {
				case "1":
					App.activityList.get(App.activityList.size()-1).getType().setDeadline("99/99/9999");
					break;
				case "2":
					System.out.println("Enter the deadline :");
					input = takeInput();
					App.activityList.get(App.activityList.size()-1).getType().setDeadline(input);
					break;
				}
			}
			option1();
		}
		else if(input.equals("3")) {
			display();
		}
		
	}
	public void option2() {
		System.out.println("Enter the date :");
		String input = takeInput();
		App.currentDate =input;
		for(Activity activity : App.activityList) {
			activity.getType().updateActivityStatus(App.currentDate);
		}
		listActivity(input, App.activityList);
		
		
		display();
	}
	public void option3() {
		System.out.println("Name of Hobby Activity:");
		String name = takeInput(); 
		System.out.println("Postpone Date 'dd/mm/yyyy':");
		String date = takeInput();
		System.out.println("Does activity have deadline?\n1-Yes\n2-No");
		String input = takeInput();
		switch(input){
		case "1":
			System.out.println("Please update deadline accordingly.");
			System.out.println("Enter the date :");
			String date2 = takeInput();
			for(Activity activity : App.activityList){
				if(name.equals(activity.getName())){
					activity.getType().setDeadline(date2);
				}
			}
		}
		
		for(Activity activity : App.activityList){
			if(name.equals(activity.getName())){
				if(activity instanceof MandatoryActivity){
					System.out.println("Mandatory activity cannot be postponed!");
				}
				else if(activity instanceof HobbyActivity){
					activity.getType().postpone(date);
				}
				else{
					System.out.println("Unexpected error.");
				}
			}
		}
		
		display();
	}
	
	public void option4() {
		
		if(App.activityList.size() != 0) {
		
		for(Activity activity : App.activityList) {
			activity.getType().updateActivityStatus(App.currentDate);
			System.out.println(activity);
		}
		}
		else {
			System.out.println("TODO list is empty.");
		}
		display();
	}
	
	public void option5(){
		System.out.println("Please enter the date :");
		String date = takeInput();
		listActivity(date,App.activityList);
		display();
		
	}
	
	public String takeInput() {
		
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		return data;
		
	}
	
	public void listActivity(String date,ArrayList<Activity> activityList){
		for(int i=0;i<activityList.size();i++){
			if(activityList.get(i).getType() instanceof SingleDayActivityType){
				if(date.equals(activityList.get(i).getType().getDate())){
					activityList.get(i).getType().updateActivityStatus(App.currentDate);
					System.out.println(activityList.get(i));
				}
			}
			else if(activityList.get(i).getType() instanceof RoutineActivityType){
				if(activityList.get(i).getType().compareDates(activityList.get(i).getType().getDeadline(),date) == 1){
					//do nothing
				}
				else{
					if(activityList.get(i).getType().compareDates(activityList.get(i).getType().getDate(),date) == 2){
						//do nothing
					}
					else{
						try {
							if(daysBetweenTwoDates(activityList.get(i).getType().getDate(),date) % activityList.get(i).getType().getRepetition() == 0){
								activityList.get(i).getType().updateActivityStatus(App.currentDate);
								System.out.println(activityList.get(i));
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else{
				System.out.println("Error!");
			}
		}
	}
	
	public int daysBetweenTwoDates(String d1,String d2) throws ParseException{
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		StringBuilder str1 = new StringBuilder(d1);
		str1.replace(2, 3, " ");
		str1.replace(5, 6, " ");
		StringBuilder str2 = new StringBuilder(d2);
		str2.replace(2, 3, " ");
		str2.replace(5, 6, " ");
		String dateString1 = str1.toString();
		String dateString2 = str2.toString();
		
		java.util.Date date1 = myFormat.parse(dateString1);
		java.util.Date date2 = myFormat.parse(dateString2);
		long diff = date2.getTime() - date1.getTime();
		String days = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		return Integer.parseInt(days);
	}

}
