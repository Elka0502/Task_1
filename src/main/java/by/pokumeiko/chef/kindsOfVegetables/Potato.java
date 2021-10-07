package by.pokumeiko.chef.kindsOfVegetables;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.Vegetables;

public final class Potato extends Vegetables {
	
	public Potato (String name, Double calories, Double weight) {
	      super(name, calories, weight);
	      if (name.isEmpty()) setName(Constant.POTATO_NAME.getValue());
	}
}
