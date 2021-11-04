package collections.queues;

import java.util.*;
import collections.lists.Arraylist;
import callable.io.Print;
/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description Arraydeque(): concrete class
 */
public class Arraydeque {
	//instance variables
	private Print view;
	private Arraylist alist;
	private ArrayDeque<String> adeque = null;
	
	/**
	 * Arraydeque(): default constructor
	 */
	public Arraydeque() {
		view = new Print();
		alist = new Arraylist();
		adeque = new ArrayDeque<String>();
	}
	
	/**
	 * addElement1(): accessor - adds element to array deque set
	 * @Notes Arraydeque does guarantee the order of its elements as inserted, <br />
	 * 	using add().
	 * @return arraydeque list
	 */
	private ArrayDeque<String> addElement1() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				adeque.add(alist.getArray()[i]);
			}
			return adeque;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addElement2(): accessor - adds element to array deque set
	 * @Notes Arraydeque does guarantee the order of its elements as inserted using pop().
	 * @return arraydeque list
	 */
	private ArrayDeque<String> addElement2() {
		try {
			view.print("Pop element2: ");
			while(adeque.peek() != null) {
				view.print(adeque.pop()+" ");
			}
			view.println("");
			return adeque;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addElement3(): accessor - adds element to array deque set
	 * @Notes Arraydeque does guarantee the order of its elements as inserted, <br />
	 * 	but also reverses element output using push().
	 * @return arraydeque list
	 */
	private ArrayDeque<String> addElement3() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				adeque.push(alist.getArray()[i]);
			}
			return adeque;
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
			view.println("Add element1: "+ addElement1());
			addElement2();
			view.println("push element3: "+ addElement3());
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Arraydeque adq = new Arraydeque();
		adq.addToString();
	}
}

