package by.pokumeiko.chef.kindsOfVegetables;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.Vegetables;

public final class Bean extends Vegetables {
	
	public Bean (String name, Double weight, Double calories) {
	      super(name, weight, calories);
	      if (name.isEmpty()) setName(Constant.BEAN_NAME.getValue());
	}
}
