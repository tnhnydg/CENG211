package domain;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public abstract class Meal {
	
	private int totalCalorie;
	private ArrayList<Nutrition> nutritionList;
	
	public Meal() {
		
	}
	
	public Meal(ArrayList<Nutrition> nutritionList){
		
		setNutritionList(nutritionList);
		
	}
	public void addNutrition(Nutrition nutrition) { 
		
		getNutritionList().add(nutrition);
		
	}
	public void removeNutrition(Nutrition nutrition) {
		
		getNutritionList().remove(nutrition);
		
	}
	
	public int computeTotalCalorie(){
		totalCalorie = 0;
		if (nutritionList.size() != 0){
			for(Nutrition n : nutritionList){
				totalCalorie += n.getCalorie();
			}
		}
		return totalCalorie;
	}
	
	public int getTotalCalorie() {
		return totalCalorie;
	}
	
	public void setTotalCalorie() {
		totalCalorie = computeTotalCalorie();
	}
	
	public ArrayList<Nutrition> getNutritionList() {
		return nutritionList;
	}
	
	public void setNutritionList(ArrayList<Nutrition> nutritionList) {
		this.nutritionList = nutritionList;
	}
	
	public String toString() {
		
		return "Meal =[" +String.valueOf(this.getClass()).split("\\.")[1] +" = " + getNutritionList() + "]";
	}
	

}
