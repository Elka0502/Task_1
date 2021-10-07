package by.pokumeiko.chef.kindsOfVegetables;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.Vegetables;

public final class Carrot extends Vegetables {
	
	public Carrot (String name, Double calories, Double weight) {
	      super(name, calories, weight);
	      if (name.isEmpty()) setName(Constant.CARROT_NAME.getValue());
	}
}
