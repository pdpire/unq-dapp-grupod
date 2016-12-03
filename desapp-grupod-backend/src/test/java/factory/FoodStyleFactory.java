package factory;

import model.FoodStyle;

public class FoodStyleFactory {
	
	public static FoodStyle anyFoodStyle(){
		
		FoodStyle fs = new FoodStyle("value");
		
		return fs;
	}

}
