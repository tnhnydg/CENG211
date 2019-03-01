package development;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Vehicle {
	
	
	private String owner;
	private String model; //brand
	private int year;
	private int hp;  //horsepower
	private double ap; //accidentpenalty
	private VehicleType type;
	
	
	public Vehicle(String owner,String model,int year,int hp,double ap,VehicleType type){
		
		setOwner(owner);
		setModel(model);
		setProducedYear(year);
		setHorsepower(hp);
		setAccidentpenalty(ap);
		setType(type);
		
	}
	
	
	public void setOwner(String owner){
		if (owner == null)
			this.owner = "NO NAME GIVEN";
		else
			this.owner=owner;
	}
	
	public void setModel(String model){	
		if (model == null)
			this.model = "NO BRAND GIVEN";
		else
			this.model=model;
	}
	
	public void setProducedYear(int year){	
		if (year > 0 && year < 2018){
			this.year = year;
		}
		else {
			this.year = 2017;
		}
	}
	
	public void setHorsepower(int hp){
		{
			if (hp <= 0)
				this.hp = 0;
			else
				this.hp=hp;
		}
	}
	
	public void setAccidentpenalty(double ap){
		if (ap < 0)
			this.ap = 1.0;
		else
			this.ap=ap;
	}
	
	public void setType(VehicleType type){
		if (type == null)
			this.type = VehicleType.CAR;
		else
			this.type=type;
	}
	
	
	public String getOwner(){
		return this.owner;
	}
	
	public String getBrand(){
		return this.model;
	}
	
	public int getProducedYear(){
		return this.year;
	}
	
	public int getHorsePower(){
		return this.hp;
	}
	
	public double getAccidentpenalty(){
		return this.ap;
	}
	
	public VehicleType getType(){
		return this.type;
	}
	
	public String toString(){
		return "Vehicle [owner=" + getOwner() + ", brand=" + getBrand() + ", producedyear=" + getProducedYear() + ", housepower="+ getHorsePower() + ", accidentpenalty=" + getAccidentpenalty() + ", type=" + getType() + "]";
	}
	

}
