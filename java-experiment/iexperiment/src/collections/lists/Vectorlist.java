package collections.lists;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description Vectorlist(): concrete class Vector
 */
public class Vectorlist {
	private Vector<String> vlist;
	private Print view;
	private Arraylist alist;
	
	/**
	 * Vectorlist(): default constructor
	 */
	public Vectorlist() {
		view = new Print();
		alist = new Arraylist();
		vlist = new Vector<String>(6, 1);
	}
	
	
	/**
	 * addElement(): accessor - adds elements to arraylist
	 * @Notes vector does guarantee the order of its elements as inserted
	 * @return alist - vector type
	 */
	private Vector<String> addElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				vlist.add(i, alist.getArray()[i]);
			}
			return vlist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * removeElement(): accessor - removes and replace an element from vector
	 * @return alist - vector type
	 */
	private Vector<String> removeElement() {
		try {
			for(int i=0; i<alist.getArray().length; i++) {
				if(vlist.contains("C")) {
					vlist.remove(alist.getArray()[i]);
					vlist.add(i, alist.getArray()[i+1]);
				}
			}
			vlist.addElement("G");
			vlist.addElement("H");
			return vlist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * displayVect(): muattor - displays vector contents via enhance for-loop
	 * @param array - array to be provided as a parameter
	 */
	private void displayVect(String array[]) {
		try {
			for(String i:array) {
				view.print(i+" ");
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * toArray(): mutator - converts Vector to actual Array
	 * @Notes an Vector is first autoboxed in order to obtain an actual array
	 * @return new array
	 */
	private void vectorToArray() {
		String newArr[] = new String[vlist.size()];
		try {
			newArr = vlist.toArray(newArr);
			//use enhanced for-loop when you need not modify and reverse contents of elements, otherwise, us an iterator
			view.print("Vector to actual array: ");
			displayVect(newArr);
			view.println("");
			
			//sorts actual array
			Arrays.sort(newArr);
			view.print("Vector-sorted actual array: ");
			displayVect(newArr);
			view.println("");
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * showVectlist(): muattor - displays vector contents via enhance for-loop
	 * @param array - vector to be provided as a parameter
	 */
	private void showVectList(Vector<String> array) {
		try {
			for(String i:array) {
				view.print(i+" ");
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * arrComparator(): mutator - sorts vector in reversed order
	 */
	private void arrComparator() {
		Comparator<String> revord = Collections.reverseOrder();
		try {
			Collections.sort(vlist, revord);	//sorts list based on comparator
			view.print("Vector sorted in reversed order: ");
			showVectList(vlist);
			
			Collections.shuffle(vlist);	//shuffle list based on comparator
			view.print("\nVector shuffle list: ");
			showVectList(vlist);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * addToString(): facilitator - displays vector
	 */
	private void addToString() {
		try {
			view.println("Vector initial size: "+ vlist.size());
			view.println("Vector add element: "+ addElement());
			view.println("Vector replace elem: "+ removeElement());
			vectorToArray();
			arrComparator();
			view.println("\nVector current capacity: "+vlist.capacity());
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Vectorlist vl = new Vectorlist();
		vl.addToString();
	}
}
