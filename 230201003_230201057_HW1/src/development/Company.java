package development;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Company {
	
	private double x;//YearCostWeight
	private double y;//HpCostWeight
	private double z;//AccidentPenaltyWeight
	
	public Company(double x,double y,double z){
		setWeightX(x);
		setWeightY(y);
		setWeightZ(z);
	}
	
	public void setWeightX(double x){
		if (x > 0){
			this.x = x;
		}
		else {
			this.x = 1;
		}
	}
	
	public void setWeightY(double y){
		if (y > 0){
			this.y = y;
		}
		else {
			this.y = 1;
		}
	}
	
	public void setWeightZ(double z){
		if (z > 0){
			this.z = z;
		}
		else {
			this.z = 1;
		}
	}
	
	public double getWeightX(){
		return this.x;
	}
	public double getWeightY(){
		return this.y;
	}
	public double getWeightZ(){
		return this.z;
	}
	public String toString(){
		return ("Company [weightX=" + this.getWeightX() + ", weightY=" + this.getWeightY() + ", weightZ=" + this.getWeightZ() + "]");
	}
	

}
