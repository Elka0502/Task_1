package by.pokumeiko.chef.createSideDish;

public abstract class Vegetables {
	private String name = "";
	private Double calories = 0.0;
	private Double weight = 0.0;
	
	public Vegetables(String name, Double weight, Double calories) {
		this.name = name;
		this.weight = (weight<0?-weight:weight);
		this.calories = (calories<0?-calories:calories);
	}

	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
	
	public Double getCalories() {
		return calories;
	}
	
	public Double getWeight() {
		return weight;
	}
}
