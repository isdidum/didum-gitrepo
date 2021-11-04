package collections.iterator;

import java.util.*;

import collections.lists.Arraylist;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description IteratorArrList(): concrete class
 * @notes <p>Iterator is the process of retrieving every element in a collection via forward scanning<br />
 * ListIterator allows you to scan the list backwards & insert or modify elements in list</p>
 */
public class IteratorArrList {
	//instance variables
	private Print out;
	private Arraylist alist;
	private ArrayList<String> arrlist = null;
	
	/**
	 * IteratorArrList(): default constructor
	 */
	public IteratorArrList() {
		out = new Print();
		alist = new Arraylist();
		arrlist = new ArrayList<String>(6);
	}
	
	/**
	 * addElement(): accessor - adds elements to arraylist
	 * @Notes arraylist does guarantee the order of its elements as inserted
	 * @return arrlist
	 */
	private ArrayList<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				arrlist.add(i, alist.getArray()[i]);
			}
			return arrlist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addToString(): facilitator - displays array deque list
	 */
	private void addToString() {
		try {
			addElement(); //invokes arrlist
			
			//displays contents of arraylist using iterator
			out.print("Original content of arraylist: ");
			Iterator<String> itr = arrlist.iterator();
			while(itr.hasNext() == true) {
				String elem = itr.next();
				out.print(elem+" ");
			}
			
			//modifies objects being iterated
			ListIterator<String> litr = arrlist.listIterator();
			while(litr.hasNext()) {
				String elem = litr.next();
				litr.set(elem + "*");
			}
			out.print("\nModified contents of arraylist: ");
			itr = arrlist.iterator();
			while(itr.hasNext()) {
				String elem = itr.next();
				out.print(elem + " ");
			}
			
			//displays list in reverse order or backwards
			out.print("\nModified list in reverse order: ");
			while(litr.hasPrevious() == true) {
				String elem = litr.previous();
				out.print(elem + " ");
			}
			
			//iterate objects without any modification
			out.print("\nEnhnace for-loop iteration: ");
			for(String i: arrlist) {
				out.print(i+" ");
			}
			
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		IteratorArrList ial = new IteratorArrList();
		ial.addToString();
	}

}
