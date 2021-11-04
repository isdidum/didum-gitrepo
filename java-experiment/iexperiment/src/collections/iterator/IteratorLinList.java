package collections.iterator;
import java.util.*;

import pconcrete.Address;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description IteratorLinList(): concrete class
 * @notes <p>Iterator is the process of retrieving every element in a collection via forward scanning<br />
 * ListIterator allows you to scan the list backwards & insert or modify elements in list</p>
 */
public class IteratorLinList {
	//private instance variable
	/**uses user-defined class, <code>Address</code>, in collection linkedlist*/
	private LinkedList<Address> mlist = null;
	private Print view;
	/**
	 * IteratorLinList(): default constructor
	 */
	public IteratorLinList() {
		view = new Print();
		mlist = new LinkedList<Address>();
	}
	
	/**
	 * addElement(): accessor - adds elements to arraylist
	 * @Notes arraylist does guarantee the order of its elements as inserted
	 * @return mlist
	 */
	private LinkedList<Address> addElement() {
		try {
			// address class can be modified to read objects dynamically from a database or an external file
			mlist.add(new Address("Angel Diamond", "3337 Willow Crescent", "34","Fairfax", "Virginia", "22030"));
			mlist.add(new Address("Vicki Pagel", "7208 E 100th Terrance", "","Kansas City", "Missouri", "64134"));
			mlist.add(new Address("Sumeet Gandhi", "757 E Main Street", "301","Lansdale", "Pennsylvania", "19446"));
			mlist.add(new Address("Neka H. Baddom", "3709 Trip Street", "205","Ames", "Iowa", "50014"));
			mlist.add(new Address("Tom Scheir", "555 S Ash Ave", "05","Independence", "Missouri", "64055"));
			return mlist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addElement(): accessor - adds elements to arraylist
	 * @Notes arraylist does guarantee the order of its elements as inserted
	 * @return mlist
	 */
	private void itrElement() {
		try {
			for(Address i: mlist) {
				view.print(i+"\n\n");
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * addToString(): facilitator - displays array list
	 */
	private void addToString() {
		try {
			//view.println("Linkedlist add element: "+ addElement());
			addElement();
			itrElement();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
	IteratorLinList ill = new IteratorLinList();
		ill.addToString();
	}

}
