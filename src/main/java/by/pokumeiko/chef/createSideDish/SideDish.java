package by.pokumeiko.chef.createSideDish;

import java.util.ArrayList;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.pokumeiko.chef.initialization.Constant;


import static by.pokumeiko.chef.initialization.InitializationFile.readData;

public class SideDish {
	private String nameSideDish = "";
	private ArrayList<Vegetables> sostavSideDish;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SideDish.class);
	
	public SideDish() {
		sostavSideDish = new ArrayList<Vegetables>();
	}
	
	public ArrayList<Vegetables> getSostavSideDish() {
		return sostavSideDish;
	}
	
	public void setSostavSideDish(Vegetables vegetables) {
		this.sostavSideDish.add(vegetables);
	}
	
	public String getNameSideDish() {
		return nameSideDish;
	}
	
	public void setNameSideDish(String nameSideDish) {
		this.nameSideDish = nameSideDish;
	}
	
	/**The method add vegetables to side dish and creates objects.*/
	public void makeSideDish(String pathString) {
		ArrayList<String> arrayVegetables = (readData(pathString));
		
		if (!this.sostavSideDish.isEmpty()) this.sostavSideDish.clear();
		Class clazz = null;
		for (String oneVegetables: arrayVegetables) {
			String[] Param =oneVegetables.toString().split("_");
			if (!Param[3].equals(Constant.TAG_SIDEDISH.getValue())) {
				try {
					String name_class = Constant.PACKAGE_NAME.getValue() + Param[3];
					clazz = Class.forName(name_class);
				    Class[] vegetablesClassParams = {String.class, Double.class, Double.class};
				    this.setSostavSideDish(((Vegetables) clazz.getConstructor(vegetablesClassParams).newInstance(Param[0], 
				    	Double.parseDouble(Param[1]),Double.parseDouble(Param[2]))));
				}
				catch (Exception e){}
			}
			else this.setNameSideDish(Param[0]);
		}	
	}
	
	/**The method returns calories in 100 grams.*/
	public Double get100CaloriesSideDish() {
		Double calories = 0.0;
		for (int i=0; i<this.sostavSideDish.size(); i++) {   
			calories += this.sostavSideDish.get(i).getCalories();
		}
		return calories;		
	}
	
	/**The method returns total calories.*/
	public Double getAllCaloriesSideDish() {
		Double calories = 0.0;
		for (int i=0; i<this.sostavSideDish.size(); i++) {   
			calories += (this.sostavSideDish.get(i).getWeight()*this.sostavSideDish.get(i).getCalories())/100;
		}
		return calories;		
	}

	/**The method sorts vegetables in side dish by name.*/
	public void sortingByName() {
		Collections.sort(this.sostavSideDish, ((Vegetables v1,Vegetables v2) ->
		         v1.getName().compareTo(v2.getName())));
	}
	
	/**The method finds vegetables in a side dish for a given calorie range.*/
	public  ArrayList<Vegetables> findVegetablesFromRange(Double startRange, Double endRange) {
		ArrayList<Vegetables> arrayVegetables = new ArrayList<Vegetables>();
		if (!this.sostavSideDish.isEmpty()) {
	        if (startRange>endRange) {
	        	LOGGER.info("Incorrect a given the range.");
		       	 return arrayVegetables;
	        }
	        else {
				for (int i=0; i<this.sostavSideDish.size(); i++) {   
					if ((this.sostavSideDish.get(i).getCalories() >= startRange) && (this.sostavSideDish.get(i).getCalories() <= endRange))
					arrayVegetables.add(this.sostavSideDish.get(i));
				}
				if (!arrayVegetables.isEmpty())	return arrayVegetables; 
				else {
					LOGGER.info("No ingredients in the range.");
					return arrayVegetables;
			    }
			}
		}
		else {
			LOGGER.info("No ingredients in the side dish.");
			return arrayVegetables;
		}
	}
}
