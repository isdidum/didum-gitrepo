package collections.comparator;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @Date Feb 11, 2013
 * ComparatorTSet(): concrete class
 * @Notes gives you the ability to govern how elements are stored within sorted collections and maps. <br />
 * 	Java uses A before B and 1 before 2 etc... Now, you can change this constructor with set or map
 */
public class ComparatorTSet implements Comparator<String> {
	/**
	 * ComparatorTSet(): default constructor
	 */
	public ComparatorTSet() {
		//dont need a constructor
	}
	
	/**
	 * compare(): implements Comparator
	 */
	@Override
	public int compare(String a, String b) {
		String astring, bstring;
		astring = a;
		bstring = b;
		
		// reverses the comparison
		return bstring.compareTo(astring);
	}
	// no need to override equals
//}

/**
 * @author A., Didum
 * @description CompClient(): default class declaration
 * @Notes To run it, right click on ComparatorTSet.java, then click run as configuration <br />
 * 	by selecting collections.ComClient.java 
 *
class CompClient {*/
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String args[]) {
		Print view = new Print();
		TreeSet<String> ts = new TreeSet<String>(new ComparatorTSet());
		
		//adds elements to the tree set
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		
		//displays the elements
		view.print("Elements: ");
		for(String elem: ts) {
			view.print(elem+" ");
		}
	}

}

