package by.pokumeiko.chef.initialization;

public  enum Constant {
    
	PACKAGE_NAME ("by.pokumeiko.chef.kindsOfVegetables."),
    FILE_PATH ("resource.xml"),
    TAG_SIDEDISH ("SideDish"),
	ATTRIBUT_NAME ("name"),
	ATTRIBUT_CALORIES ("calories"),
	ATTRIBUT_WEIGHT ("weight"),
	
	BEAN_NAME ("Фасоль"),
	BEET_NAME ("Свекла"),
	CARROT_NAME ("Морковь"),
	CUCUMBER_NAME ("Огурец"),
	ONION_NAME ("Лук"),
	POTATO_NAME ("Картофель");
	
	private final String value;
	
	private Constant (final String value) {
		this.value = value; 
	}
	
	public String getValue() {
		return value;
	}
}



