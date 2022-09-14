package burgerama;

import java.util.ArrayList;
import java.util.List;

public class Burger {
	//attributes
	private boolean isDouble;
	private boolean withCheese;
	private boolean withBacon;
	private boolean isMeal;
	
	private double cost;
	private List<String> freeToppings = new ArrayList<String>(); 
	
	//constructor
	public Burger() {
		isDouble = false;
		withCheese = false;
		withBacon = false;
		isMeal = false;
		calculateCost();
	}
	
	public Burger(boolean...values) {
		if(values.length >= 1) {
			isDouble = values[0];
		}
		if(values.length >= 2) {
			withCheese = values[1];
		}
		if(values.length >=3) {
			withBacon = values[2]; 
		}
		if(values.length >=4) {
			isMeal = values[3];
		}
		calculateCost();
	}
	
	//behaviors
	@Override
	public String toString() {
		String output;
		if(isDouble == false) {
			output = "Single";
		}
		else {
			output = "Double";
		}
		
		if(withCheese == true && withBacon == false) {
			output = String.format("%s cheeseburger", output);
		}
		else if(withCheese == true && withBacon == true) {
			output = String.format("%s bacon cheeseburger", output);
		}
		else if(withCheese == false && withBacon == false) {
			output = String.format("%s hamburger", output);
		}
		else if(withCheese == false && withBacon == true) {
			output = String.format("%s hamburger with bacon", output);
		}
		
		if(isMeal == true) {
			output = String.format("%s combo.\n", output);
		}
		else {
			output += ".\n";
		}
		if(!freeToppings.isEmpty()) {
			output += "With: ";
			for(String topping: freeToppings) {
				
				if(freeToppings.indexOf(topping) != freeToppings.size() - 1) {
					output += topping + ",";					
				}
				else {
					output += topping + ".\n";
				}
				
			}
		}
		output += String.format("Price: $%.2f\n", getCost());
		return output;
	}
	
	public void calculateCost() {
		cost = 0.0;
		if(isDouble == false) {
			cost += 3.5;
		}
		else {
			cost += 4.75;
		}
		
		if(withCheese == true) {
			cost += .5;
		}
		if(withBacon == true) {
			cost += 1.25;
		}
		if(isMeal == true) {
			cost += 4;
		}
		
	}
	
	public void addTopping(String value) {
		freeToppings.add(value);
	}
	public void delTopping(String value) {
		freeToppings.remove(value);
	}
	
	
	//getters and setters
	public boolean getDouble() {return isDouble;}
	public boolean getCheese() {return withCheese;}
	public boolean getBacon() {return withBacon;}
	public boolean getMeal() {return isMeal;}
	public List<String> getToppings() {return freeToppings;}
	public double getCost() {
		calculateCost();
		return cost;
		}
	public void setDouble(boolean value) {isDouble = value;}
	public void setCheese(boolean value) {withCheese = value;}
	public void setBacon(boolean value) {withBacon = value;}
	public void setMeal(boolean value) {isMeal = value;}
	
	
}
