package collections.sets;

import java.util.*;

import collections.lists.Arraylist;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description LinkedHashset(): concrete class
 */
public class LinkedHashset {
	//instance variables
	private Print view;
	private Arraylist alist;
	private LinkedHashSet<String> lhset = null;
	
	/**
	 * LinkedHashset(): default constructor
	 */
	public LinkedHashset() {
		view = new Print();
		alist = new Arraylist();
		lhset = new LinkedHashSet<String>();
	}
	
	/**
	 * addElement(): accessor - adds element to liked hash set
	 * @Notes linkedhashset does guarantee the order of its elements as inserted
	 * @return linkedhashset list
	 */
	private LinkedHashSet<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				lhset.add(alist.getArray()[i]);
				//add(i, alist.getArray()[i]);
			}
			return lhset;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * addToString(): facilitator - displays linked list set
	 */
	private void addToString() {
		try {
			view.println("Add element: "+ addElement());
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedHashset lhs = new LinkedHashset();
		lhs.addToString();
	}
}

