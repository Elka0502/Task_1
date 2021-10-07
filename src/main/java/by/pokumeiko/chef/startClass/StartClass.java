package by.pokumeiko.chef.startClass;

import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.pokumeiko.chef.initialization.Constant;
import by.pokumeiko.chef.createSideDish.*;

public class StartClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartClass.class);
	 
	public static void main(String[] args) {
		LOGGER.debug("\nStart chef");
		SideDish sideDish = new SideDish();
		
		sideDish.makeSideDish(Constant.FILE_PATH.getValue());
		LOGGER.info("Салат \"{}\"", sideDish.getNameSideDish());
		printRecipe(sideDish); 
		
		printCalories(sideDish);
		
		sideDish.sortingByName();
		LOGGER.info("Салат (отсортированный) \"{}\"", sideDish.getNameSideDish());
		printRecipe(sideDish);
		
		printVegetablesFromCaloriesRange(sideDish);
		System.out.println("Result in file: result.log");
		LOGGER.debug("Stop chef");
	}
	
	/**The method prints recipe of side dish.*/    
	private static void printRecipe(SideDish sideDish) {
		for (Vegetables strRecipe: sideDish.getSostavSideDish()) {  
			LOGGER.info("{} - {} г ({} кКал в 100 г)", 
					strRecipe.getName(), strRecipe.getWeight(), strRecipe.getCalories());
		}
		LOGGER.info("-".repeat(40));
	}
	
	/**The method prints calories of recipe of side dish.*/  
	private static void printCalories(SideDish sideDish) {
		LOGGER.info(String.format("Энергетическая ценность: \n всего - %s кКал;\n в 100г -  %s кКал",
				sideDish.getAllCaloriesSideDish(), sideDish.get100CaloriesSideDish()));
		LOGGER.info("-".repeat(40));
	}
	
	/**The method prints vegetables from a given calorie range.*/
	private static void printVegetablesFromCaloriesRange(SideDish sdish) {
		if (!sdish.getSostavSideDish().isEmpty()) {
			
			System.out.print("Input the start of the range: ");
			Scanner scan = new Scanner(System.in);
			String scanStart =   scan.nextLine().replace(",",".");
			System.out.print("Input the end of the range: ");
			String scanEnd = scan.nextLine().replace(",",".");
			LOGGER.info("Овощи из заданного диапазона:");
			if (NumberUtils.isParsable(scanStart)&&NumberUtils.isParsable(scanEnd)) {
				Double startRange =(Double.parseDouble(scanStart));
				Double endRange = (Double.parseDouble(scanEnd));
				for (Vegetables strRecipe: sdish.findVegetablesFromRange(startRange, endRange)) {  
					LOGGER.info(String.format("%s - (%s ККал в 100г)",
							strRecipe.getName(), strRecipe.getCalories()));	
				}
			}
			else LOGGER.info("Input start or end of range is not numeric.");
			scan.close();
		}
		LOGGER.info("-".repeat(40));
	}	

}