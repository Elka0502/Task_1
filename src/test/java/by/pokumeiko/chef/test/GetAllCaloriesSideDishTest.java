package by.pokumeiko.chef.test;

import org.junit.jupiter.api.*;

import by.pokumeiko.chef.kindsOfVegetables.*;
import by.pokumeiko.chef.createSideDish.*;

public class GetAllCaloriesSideDishTest {

	@Test
    public void testGetAllCaloriesSideDish() {
		SideDish sideDish = new SideDish();
    	sideDish.setSostavSideDish((Vegetables) new Onion ("Лук", 10.0, 10.0));
    	sideDish.setSostavSideDish((Vegetables) new Potato ("Картофель", 10.0, 20.0));
    	sideDish.setSostavSideDish((Vegetables) new Onion ("Лук", 30.2, 30.0));
    					
        Assertions.assertEquals(12.06, sideDish.getAllCaloriesSideDish());
    }
}
