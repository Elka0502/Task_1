package by.pokumeiko.chef.test;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import by.pokumeiko.chef.kindsOfVegetables.*;
import by.pokumeiko.chef.createSideDish.*;

public class Get100CaloriesSideDishTest {
	
	@ParameterizedTest
    @MethodSource("sumCalories")
	public void testGet100CaloriesSideDish (SideDish sideDish, Double result) {
			
		SideDish sd = sideDish;
		Double resultCalories = result;
 
		Double sumCalories = sd.get100CaloriesSideDish(); 
		
        Assertions.assertEquals(resultCalories, sumCalories);
    }
	
	public static Stream<Object> sumCalories() {
		SideDish sideDish = new SideDish();
    	sideDish.setSostavSideDish((Vegetables) new Onion ("Лук", 10.0, 10.0));
    	sideDish.setSostavSideDish((Vegetables) new Potato ("Картофель", 10.0, 20.0));
    	sideDish.setSostavSideDish((Vegetables) new Onion ("Лук", 30.2, 30.0));
    	
    	SideDish sideDish1 = new SideDish();
    	sideDish1.setSostavSideDish((Vegetables) new Onion ("Лук", 10.0, 100.0));
    	sideDish1.setSostavSideDish((Vegetables) new Potato ("Картофель отварной", 10.0, 220.0));
    	sideDish1.setSostavSideDish((Vegetables) new Onion ("Лук зеленый", 30.2, 70.0));
		
    	return Stream.of (
				 Arguments.of (sideDish, 60.0),
				 Arguments.of (sideDish1, 390.0)
		);
	}
}
