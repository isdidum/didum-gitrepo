package collections.maps;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 14, 2013
 * @description HashTable(): concrete class HashTable
 * @notes Hash table accepts null-key & null-value and forbids Iterable Interface, <br />
 * 	meaning, cannot use enhance for-loop nor iterator to cycle through elements.
 */
public class HashTable {
	//instance variables
	private Print view;
	private Hashtable<String, Double> htable; //<key, value> both are objects
	
	/**
	 * HashTable(): default constructor
	 */
	public HashTable() {
		view = new Print();
		htable = new Hashtable<String, Double>(6);
	}
	
	/**
	 * putElement(): accessor - adds elements to hash map
	 * @Notes hashmap does guarantee the order of its elements as inserted and accepts null keys & null values
	 * @return hmap
	 */
	private Hashtable<String, Double> putElement() {
		try {
			//puts elements into hash map
			htable.put("Dee Abraham", new Double(110.45));
			htable.put("Didum Abe", new Double(-35.50));
			htable.put("Peter Tonta", new Double(95.65));
			htable.put("Alex Yorka", new Double(85.324));
			return htable;
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
			view.println("Hasbtable put element: "+ putElement());
			view.println("");
			
			//gets a set of the entries
			Set<Map.Entry<String, Double>> set = htable.entrySet();
			
			//displays the set
			for(Map.Entry<String, Double> key: set) {
				view.print(key.getKey() + ": ");
				view.println(key.getValue()+"");
			}
			view.println("");
			
			//Deposit 125.35 into Didum's account
			double bal = htable.get("Didum Abe");
			htable.put("Didum Abe", bal+125.35);
			view.println("Didum's new balance: "+htable.get("Didum Abe"));
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.addToString();
	}

}
