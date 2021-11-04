package collections.lists;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 12, 2013
 * @description Linkedlist(): concrete class LinkedList
 */
public class Linkedlist {
	//instance variables
	private Arraylist alist;
	private LinkedList<String> llist;
	private Print view;

	/**
	 * Linkedlist(): default constructor
	 */
	public Linkedlist() {
		alist = new Arraylist();
		llist = new LinkedList<String>();	//linkedlist does not have initial capacity
		view = new Print();
	}
	
	/**
	 * addElement(): accessor - adds element to the linked list
	 * @Notes linkedlist does guarantee the order of its elements as inserted
	 * @return linkedlist
	 */
	private LinkedList<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				llist.add(i, alist.getArray()[i]);
			}
			llist.addLast("A2");
			llist.addFirst("A1");		
			return llist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * delElement(): accessor - removes element from linked list
	 * @return linkedlist
	 */
	private LinkedList<String> delElement() {
		try {
			view.println("Linkedlist subbed elem: "+llist.subList(0, 3));
			llist.removeFirst();		//see also remove(int), remove()
			llist.removeLast();
			llist.remove(1);
			return llist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * setElement(): accessor - sets an element in linked list
	 * @return linkedlist
	 */
	private LinkedList<String> setElement() {
		try {
			String val = llist.get(2); 	//see also getFirst(), getLast()
			llist.set(2, val+" New");
			return llist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * arrComparator(): mutator - sorts arraylist in reversed order
	 */
	private void arrComparator() {
		Comparator<String> revord = Collections.reverseOrder();
		try {
			Collections.sort(llist, revord);	//sorts list based on comparator
			view.print("Linkedlist sorted in reversed order: ");
			for(String i: llist) {
				view.print(i+" ");
			}
			
			Collections.shuffle(llist);	//shuffle list based on comparator
			view.print("\nLinkedlist shuffle list: ");
			for(String i: llist) {
				view.print(i+" ");
			}
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * addToString(): facilitator - display array list
	 */
	private void addToString() {
		try {
			view.println("Linkedlist add element: "+ addElement());
			view.println("Linkedlist delete elem: "+ delElement());
			view.println("Linkedlist set element: "+ setElement());
			arrComparator();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addToString();
	}

}
