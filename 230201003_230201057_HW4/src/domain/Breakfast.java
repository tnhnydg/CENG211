package domain;

import java.util.ArrayList;

/**
 * 
 * @author TunahanYadigarbigun-FurkanEmreYilmaz 230201003-230201057
 *
 */

public class Breakfast extends Meal {
	
	private static NutritionType[] nutritionTypes = {NutritionType.CEREALS,
													 NutritionType.DAIRYPRODUCT,
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
	
	public Breakfast(ArrayList<Nutrition> nutritionList){
		
		super(nutritionList);
	}
}