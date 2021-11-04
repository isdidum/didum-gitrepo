package collections.all;

import java.util.*;

import callable.io.Print;
/**
 * @author A., Didum
 * @date February 26, 2013
 * @description Sets(): general purpose collections using sets in <code>java.util</code>
 */
public class Sets {
	//instance var
	Set<Object> set;
	
	/**
	 * Sets(): default constructor
	 * @notes any of the collections in collections.sets could replace HashSet in this example
	 */
	public Sets() {
		set = new HashSet<Object>();
	}
	
	/**
	 * getSet(): add - elements to the set
	 * @return
	 */
	private Set<Object> getSet(){
		set.add("one");
		set.add("two");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add(new Double(8.45));
		set.add(new Character('D'));
		set.add(new Integer(4));	//duplicate, not added
		set.add("two");				//duplicate, not added
		return set;
	}
	
	/**
	 * toString(): facilitator - returns results
	 */
	public String toString() {
		return String.valueOf(getSet()); //could replace getSet() with set
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Sets set = new Sets();
		
		view.println("Here is the output: \n"+set.toString());

	}

}
