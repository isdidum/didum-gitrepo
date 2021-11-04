package enums;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 21, 2013
 * @description Fruits(): type-safe, new style enum definition
 */
public enum Fruits {
	Apple(1.06), Banana(1.42), Orange(0.67), Grape(1.44), Pineapple(3.87), Strawberry(1.23); 
	
	//instance variables
	private double price;
	
	/**
	 * @description Fruits(): specific constructor
	 */
	Fruits(double price) {
		this.price = price;
	}
	
	/**
	 * @description Fruits(): default constructor
	 */
	Fruits() {
		this(0.0);	//chaining enum constructor
	}
	
	/**
	 * @description getPrice(): returns price of each fruit
	 * @return fruit price
	 */
	double getPrice() {
		try {
			return price;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}
}

//anonymous Innner class //run this program via Run Configurations...
class FruitClient {
	public static void main(String args[]) {
		Print view = new Print();
		
		view.println("Pineapple costs "+Fruits.Pineapple.getPrice());
		view.println("\nPrice of each fruit:");
		for(Fruits f : Fruits.values()) { //advanced for-loop
			view.println(f + " costs $"+ f.getPrice());
		}
	}
}
