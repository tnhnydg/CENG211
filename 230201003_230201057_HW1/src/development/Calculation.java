package development;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Calculation {
	

	public double calculate(Vehicle vehicle, Company company) {
		
		double typeCo = 0, horsepowerCo = 0, yearCo = 0;
		double age = 2017 - vehicle.getProducedYear();
		if (vehicle.getType() == VehicleType.CAR){
			typeCo = 1000;
			horsepowerCo = 10;
			if (age < 3)
				yearCo = 200;
			else 
				yearCo = 100;
		}
		else if (vehicle.getType() == VehicleType.BUS){
			typeCo = 2000;
			horsepowerCo = 10;
			if (age < 5)
				yearCo = 400;
			else
				yearCo = 200;
		}
		else if (vehicle.getType() == VehicleType.MOTORCYCLE){
			typeCo = 500;
			horsepowerCo = 3;
			if (age < 1)
				yearCo = 100;
			else
				yearCo = 50;
		}	
		
		double yearCost = typeCo / Math.pow(2, age);
		double hpCost =	vehicle.getHorsePower() * horsepowerCo;
		double accidentPenalty = vehicle.getAccidentpenalty() * yearCo;
		return company.getWeightX() * yearCost + company.getWeightY() * hpCost + company.getWeightZ() * accidentPenalty;
	}
	


}
