package collections.comparator;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description ComparatorTSet(): concrete class
 * @dotes gives you the ability to govern how elements are stored within sorted collections and maps. <br />
 * 	Java uses A before B and 1 before 2 etc... Now, you can change this constructor with set or map
 */
public class ComparatorTMap implements Comparator<String> {
	/**
	 * ComparatorTSet(): default constructor
	 */
	public ComparatorTMap() {
		//dont need a constructor
	}
	
	/**
	 * compare(): implements Comparator
	 */
	@Override
	public int compare(String a, String b) {
		String astr, bstr;
		int i, j, k;
		
		astr = a;
		bstr = b;
		
		//find index of beginning of last name
		i = astr.lastIndexOf(' ');
		j = bstr.lastIndexOf(' ');
		
		// compares last names and return in alphebetical order 
		k = astr.substring(i).compareTo(bstr.substring(j));
		if(k == 0) { // last names match, check entire name
			return astr.compareTo(bstr);
		} else {
			return k;
		}
	}
	// no need to override equals

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String args[]) {
		Print view = new Print();
		TreeMap<String, Double> tmap = new TreeMap<String, Double>(new ComparatorTMap());
		
		//puts elements into hash map
		tmap.put("Dee Abraham", new Double(123.45));
		tmap.put("Didum Abe", new Double(-30.50));
		tmap.put("Alex Yorka", new Double(65.324));
		tmap.put("Peter Tonta", new Double(85.65));
			
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
	}

	

}


