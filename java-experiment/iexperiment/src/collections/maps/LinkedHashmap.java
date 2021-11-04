package collections.maps;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description LinkedHashmap(): concrete class LinkedHashMap
 * @notes Linked Hash Map accepts null-key & null-value and forbids Iterable Interface, <br />
 * 	meaning, cannot use enhance for-loop nor iterator to cycle through elements.
 */
public class LinkedHashmap {
	//instance variables
	private Print view;
	private LinkedHashMap<String, Integer> lhmap; //<key, value> both are objects
	
	/**
	 * LinkedHashmap(): default constructor
	 */
	public LinkedHashmap() {
		view = new Print();
		lhmap = new LinkedHashMap<String, Integer>(6);
	}
	
	/**
	 * putElement(): accessor - adds elements to hash map
	 * @Notes linkedhashmap does guarantee the order of its elements as inserted and accepts null keys & null values
	 * @return lhmap
	 */
	private LinkedHashMap<String, Integer> putElement() {
		try {
			//puts elements into hash map
			lhmap.put("Dee Abraham", new Integer(113));
			lhmap.put("Didum Abe", new Integer(-35));
			lhmap.put("Peter Tonta", new Integer(95));
			lhmap.put("Alex Yorka", new Integer(88));
			return lhmap;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addToString(): facilitator - displays linked hash map entries
	 */
	private void addToString() {
		try {
			view.println("LinkedHashMap put element: "+ putElement());
			view.println("");
			
			//gets a set of the entries
			Set<Map.Entry<String, Integer>> set = lhmap.entrySet();
			
			//displays the set
			for(Map.Entry<String, Integer> key: set) {
				view.print(key.getKey() + ": ");
				view.println(key.getValue()+"");
			}
			view.println("");
			
			//Deposit 134 into Didum's account
			int bal = lhmap.get("Didum Abe");
			lhmap.put("Didum Abe", bal+134);
			view.println("Didum's new balance: "+lhmap.get("Didum Abe"));
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedHashmap lhm = new LinkedHashmap();
		lhm.addToString();
	}

}

