package collections.queues;

import java.util.*;
import collections.lists.Arraylist;
import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 13, 2013
 * @description Priorityqueue(): concrete class
 */
public class Priorityqueue {
	//instance variables
	private Print view;
	private Arraylist alist;
	private PriorityQueue<String> pqueue = null;
	
	/**
	 * Priorityqueue(): default constructor
	 */
	public Priorityqueue() {
		view = new Print();
		alist = new Arraylist();
		pqueue = new PriorityQueue<String>(6);
	}
	
	/**
	 * addElement(): accessor - adds element to array deque set
	 * @Notes Priorityqueue does not guarantee the order of its elements as inserted using add().
	 * @return priorityqueue list
	 */
	private PriorityQueue<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				pqueue.add(alist.getArray()[i]);
			}
			return pqueue;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * addToString(): facilitator - displays priority queue list
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
		Priorityqueue pq = new Priorityqueue();
		pq.addToString();
	}
}

