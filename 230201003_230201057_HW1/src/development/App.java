package development;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Company companyA = new Company(0.7,0.3,0.3);
		Company companyB = new Company(0.3,0.3,0.4);
		Company companyC = new Company(0.2,0.2,0.6);
		
		FileParser vehicleList = new FileParser();
		Calculation calculation1 = new Calculation();
		
		ArrayList<Vehicle> fileData = new ArrayList<Vehicle>();
		
		fileData = vehicleList.readFile();
		
		System.out.println("Company A's insurance cost offer for each vehicle respectively : ");
		for(int i = 0; i<fileData.size(); i++){
			System.out.print(fileData.get(i).getOwner()+" : ");
			System.out.println(calculation1.calculate(fileData.get(i),companyA));
		}
		System.out.println("Company B's insurance cost offer for each vehicle respectively : ");
		for(int i = 0; i<fileData.size();i++){
			System.out.print(fileData.get(i).getOwner()+" : ");
			System.out.println(calculation1.calculate(fileData.get(i),companyB));
		}
		System.out.println("Company C's insurance cost offer for each vehicle respectively : ");
		for(int i = 0; i<fileData.size();i++){
			System.out.print(fileData.get(i).getOwner()+" : ");
			System.out.println(calculation1.calculate(fileData.get(i),companyC));
		}
		
		
	}

}
