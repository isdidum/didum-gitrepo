package collections.sets;

import java.util.*;

import collections.lists.Arraylist;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description Treeset(): concrete class
 */
public class Treeset {
	//instance variables
	private Print view;
	private Arraylist alist;
	private TreeSet<String> tset = null;
	
	/**
	 * Treeset(): default constructor
	 */
	public Treeset() {
		view = new Print();
		alist = new Arraylist();
		tset = new TreeSet<String>();
	}
	
	/**
	 * addElement(): accessor - adds element to liked hash set
	 * @Notes treeset does not guarantee the order of its elements as inserted, <br />
	 * 	but orders element output from least to greatest.
	 * @return tree set list
	 */
	private TreeSet<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				tset.add(alist.getArray()[i]);
			}
			return tset;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * navigableSet(): accessor - uses subSet() defined in NavigableSet Interface
	 */
	private void navigableSet() {
		try {
			view.println("Subset elem: "+tset.subSet("B", "E"));
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * addToString(): facilitator - displays tree set list
	 */
	private void addToString() {
		try {
			view.println("Add element: "+ addElement());
			navigableSet();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Treeset ts = new Treeset();
		ts.addToString();
	}
}

