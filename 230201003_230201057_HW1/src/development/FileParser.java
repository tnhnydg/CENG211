package development;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class FileParser {

	public ArrayList<Vehicle> readFile() throws FileNotFoundException {
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		ArrayList<String[]> mydata = new ArrayList<String[]>();
		
		Scanner input = new Scanner(new File("files//vehicles.dat"));
		
		while(input.hasNext()){
			String line = input.nextLine();
			String[] parts = line.split(", ");
			mydata.add(parts);
		}
		
		for (int i =0;i<mydata.size();i++){
			
			vehicles.add(new Vehicle(mydata.get(i)[0],mydata.get(i)[1],Integer.parseInt(mydata.get(i)[2]),Integer.parseInt(mydata.get(i)[3]),Double.parseDouble(mydata.get(i)[4]),VehicleType.valueOf(mydata.get(i)[5].toUpperCase())));
				
		}	
		
		input.close();
		
		return vehicles;
	}
	

}
