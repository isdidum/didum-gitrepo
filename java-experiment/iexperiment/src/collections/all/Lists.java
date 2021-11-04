package collections.all;

import java.util.*;

import callable.io.Print;
/**
 * @author A., Didum
 * @date February 26, 2013
 * @description Lists(): general purpose collections using lists in <code>java.util</code>
 */
public class Lists {
	//instance var
	List<Object> list;
	
	/**
	 * Lists(): default constructor
	 * @Notes any of the collections in collections.lists could replace ArrayList in this example
	 */
	public Lists() {
		list = new ArrayList<Object>();
	}
	
	/**
	 * getList(): accessor - adds elements to the list
	 * @return list
	 */
	private List<Object> getList(){
		list.add("one");
		list.add("two");
		list.add("3rd");
		list.add(new Integer(4));
		list.add(new Float(5.0F));
		list.add(new Double(8.45d));
		list.add(new Character('D'));
		list.add(new Integer(4));		//duplicate, is added
		list.add("two");				//duplicate, is added
		return list;
	}
	
	/**
	 * toString(): facilitator - returns results
	 */
	public String toString() {
		return String.valueOf(getList()); //could replace getList() with list
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Lists list = new Lists();
		
		view.println("Here is the output: \n"+list.toString());

	}

}
