package dataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import domain.Drink;
import domain.Food;
import domain.Meal;
import domain.Nutrition;
import domain.NutritionType;
import domain.Person;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class FileProcessor {

	private String path;
	
	public FileProcessor() {
		
		
	}
	
	public FileProcessor(String path) {
		setPath(path);
		
	}

	public void initializeNutritions(ArrayList<Nutrition> nutritions) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(getPath()));
		
		while(scanner.hasNextLine()) {
			
			String line = scanner.nextLine();
			String[] tokens = line.split(",");
			
			if(tokens[4].equals("Food")) {
				
				Food food = new Food(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), NutritionType.valueOf(tokens[3].toUpperCase(Locale.ENGLISH)));
				nutritions.add(food);
			}
			else if(tokens[4].equals("Drink")) {
				
				Drink drink = new Drink(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), NutritionType.valueOf(tokens[3].toUpperCase(Locale.ENGLISH)));	
				nutritions.add(drink);
			}
			else {
				
				System.out.println("Unexpected stage");
			}
			
			
		}
		
		scanner.close();
	}
	
	public void saveInformation(Person person) throws FileNotFoundException{
		PrintWriter outFile = new PrintWriter(new File(this.path));
		for(Meal m : person.getMealList()){
			outFile.print(m.getClass().getName().substring(7) + " - ");
			for(Nutrition n : m.getNutritionList()){
				
				outFile.println(n.getName() + "," + n.getUnit() + "," + n.getCalorie() + "," + n.getType() + "," + n.getClass().getName().substring(7) + ";");
			}
			outFile.println();
		}
		outFile.close();
		
		
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
