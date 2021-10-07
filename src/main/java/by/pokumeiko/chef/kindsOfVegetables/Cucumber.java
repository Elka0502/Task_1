package by.pokumeiko.chef.kindsOfVegetables;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.Vegetables;

public final class Cucumber extends Vegetables {
	
	public Cucumber (String name, Double calories, Double weight) {
	      super(name, calories, weight);
	      if (name.isEmpty()) setName(Constant.CUCUMBER_NAME.getValue());
	}
}
