package collections.sets;

import java.util.*;

import collections.lists.Arraylist;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description Hashset(): concrete class
 */
public class Hashset {
	//instance variables
	private Print view;
	private Arraylist alist;
	private HashSet<String> hset = null;
	
	/**
	 * Hashset(): default constructor
	 */
	public Hashset() {
		view = new Print();
		alist = new Arraylist();
		hset = new HashSet<String>();
	}
	
	/**
	 * addElement(): accessor - adds element to hash set
	 * @Notes hashset does not guarantee the order of its elements as inserted
	 * @return hashset list
	 */
	private HashSet<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				hset.add(alist.getArray()[i]);
				//add(i, alist.getArray()[i]);
			}
			return hset;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * addToString(): facilitator - displays hast set list
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
		Hashset hs = new Hashset();
		hs.addToString();
	}
}
