package collections.maps;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description Treemap(): concrete class
 * @notes Hash map accepts null-key & null-value and forbids Iterable Interface, <br />
 * 	meaning, cannot use enhance for-loop nor iterator to cycle through elements.
 */
public class Treemap {
	//instance variables
	private Print view;
	private TreeMap<String, Double> tmap; //<key, value> both are objects
	
	/**
	 * Treemap(): default constructor
	 * @Notes Treemap sorts elements in ascending key order
	 */
	public Treemap() {
		view = new Print();
		tmap = new TreeMap<String, Double>();
	}
	
	/**
	 * putElement(): accessor - adds elements to hash map
	 * @Notes treemap does guarantee the order of its elements as inserted and accepts <br /> 
	 * 	null keys & null values. Sorts its elements in ascending key order.
	 * @return tmap
	 */
	private TreeMap<String, Double> putElement() {
		try {
			//puts elements into hash map
			tmap.put("Dee Abraham", new Double(123.45));
			tmap.put("Didum Abe", new Double(-30.50));
			tmap.put("Alex Yorka", new Double(65.324));
			tmap.put("Peter Tonta", new Double(85.65));
			return tmap;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addToString(): facilitator - displays hash map entries
	 */
	private void addToString() {
		try {
			view.println("Treemap put element: "+ putElement());
			view.println("");
			
			//gets a set of the entries
			Set<Map.Entry<String, Double>> set = tmap.entrySet();
			
			//displays the set
			for(Map.Entry<String, Double> key: set) {
				view.print(key.getKey() + ": ");
				view.println(key.getValue()+"");
			}
			view.println("");
			
			//Deposit 120.25 into Didum's account
			double bal = tmap.get("Didum Abe");
			tmap.put("Didum Abe", bal+120.25);
			view.println("Didum's new balance: "+tmap.get("Didum Abe"));
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Treemap tm = new Treemap();
		tm.addToString();
	}

}
