package by.pokumeiko.chef.kindsOfVegetables;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.Vegetables;

public final class Beet extends Vegetables {
	
	public Beet (String name, Double calories, Double weight) {
	      super(name, calories, weight);
	      if (name.isEmpty()) setName(Constant.BEET_NAME.getValue());
	}
}	      