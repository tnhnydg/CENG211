package domain;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Lunch extends Meal {
	
	private static NutritionType[] nutritionTypes = {NutritionType.MEAT,
													 NutritionType.FRUIT,
													 NutritionType.VEGETABLE};
	
	public static boolean containsType(NutritionType type) {

		boolean logic = false;

		for(NutritionType typ : nutritionTypes) {
			if(typ == type) {
				logic = true;
			}
		}
		return logic;
	}
	
	public Lunch(ArrayList<Nutrition> nutritionList){
		
		super(nutritionList);
	}
}
