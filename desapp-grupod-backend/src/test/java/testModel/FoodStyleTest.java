package testModel;

import org.junit.Test;
import static org.junit.Assert.*;

import factory.FoodStyleFactory;
import model.FoodStyle;

public class FoodStyleTest {
	
	@Test
	public void compareTest(){
		FoodStyle foodStyle = FoodStyleFactory.anyFoodStyle();
		FoodStyle foodStyleCompare = FoodStyleFactory.anyFoodStyle();
		
		assertTrue(foodStyle.compare(foodStyleCompare));
	}

}
