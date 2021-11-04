package collections.maps;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description Hashmap(): concrete class HashMap
 * @notes Hash map accepts null-key & null-value and forbids Iterable Interface, <br />
 * 	meaning, cannot use enhance for-loop nor iterator to cycle through elements.
 */
public class Hashmap {
	//instance variables
	private Print view;
	private HashMap<String, Double> hmap; //<key, value> both are objects
	
	/**
	 * Hashmap(): default constructor
	 */
	public Hashmap() {
		view = new Print();
		hmap = new HashMap<String, Double>(6);
	}
	
	/**
	 * putElement(): accessor - adds elements to hash map
	 * @Notes hashmap does guarantee the order of its elements as inserted and accepts null keys & null values
	 * @return hmap
	 */
	private HashMap<String, Double> putElement() {
		try {
			//puts elements into hash map
			hmap.put("Dee Abraham", new Double(123.45));
			hmap.put("Didum Abe", new Double(-30.50));
			hmap.put("Peter Tonta", new Double(85.65));
			hmap.put("Alex Yorka", new Double(65.324));
			return hmap;
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
			view.println("Hashmap put element: "+ putElement());
			view.println("");
			
			//gets a set of the entries
			Set<Map.Entry<String, Double>> set = hmap.entrySet();
			
			//displays the set
			for(Map.Entry<String, Double> key: set) {
				view.print(key.getKey() + ": ");
				view.println(key.getValue()+"");
			}
			view.println("");
			
			//Deposit 120.25 into Didum's account
			double bal = hmap.get("Didum Abe");
			hmap.put("Didum Abe", bal+120.25);
			view.println("Didum's new balance: "+hmap.get("Didum Abe"));
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Hashmap hm = new Hashmap();
		hm.addToString();
	}

}
