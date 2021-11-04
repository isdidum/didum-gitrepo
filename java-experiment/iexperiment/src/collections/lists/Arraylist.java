package collections.lists;

import java.util.*;
import collections.lists.Stack;
import callable.io.Print;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description Arraylist(): concrete class ArrayList
 */
public class Arraylist {
	private ArrayList<String> alist;
	private Print view;
	private Stack stck;
	/**
	 * @description Arraylist(): default constructor
	 */
	public Arraylist() {
		view = new Print();
		stck = new Stack();
		alist = new ArrayList<String>(6);
	}
	
	/**
	 * @description getArray(): accessor - contains array contants
	 * @return arr - array to be used in collections
	 */
	public String[] getArray() {
		String arr[] = {"C","B","A","D","E","F"};
		return arr;
	}

	/**
	 * @description addElement(): accessor - adds elements to arraylist
	 * @notes arraylist does guarantee the order of its elements as inserted
	 * @return alist
	 */
	private ArrayList<String> addElement() {
		try {
			for(int i=0; i<getArray().length; i++) {
				alist.add(i, getArray()[i]);
			}
			return alist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description removeElement(): accessor - removes and replace an element in arraylist
	 * @return alist
	 */
	private ArrayList<String> removeElement() {
		try {
			for(int i=0; i<getArray().length; i++) {
				if(alist.contains("C")) {
					alist.remove(getArray()[i]);
					alist.add(i, getArray()[i+1]);
				}
			}
			return alist;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description displayArr(): muattor - displays array contents via enhance for-loop
	 * @param array - array to be provided as a parameter
	 */
	private void displayArr(String array[]) {
		try {
			for(String i:array) {
				view.print(i+" ");
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description toArray(): mutator - converts ArrayList to actual Array
	 * @notes an ArrayList is first autoboxed in order to obtain an actual array
	 * @return new array
	 */
	private void convertToArray() {
		String newArr[] = new String[alist.size()];
		try {
			newArr = alist.toArray(newArr);
			popStack(newArr, newArr.length);
			//use enhanced for-loop when you need not modify and reverse contents of elements, otherwise, us an iterator
			view.print("Arraylist actual array: ");
			displayArr(newArr);
			view.println("");
			
			//sorts actual array
			Arrays.sort(newArr);
			view.print("Arraylist-sorted actual array: ");
			displayArr(newArr);
			view.println("");
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description popStack(): mutator - poping the stack
	 */
	private void popStack(String arr[], int sz) {
		stck.setStackArray(arr);
		for(int i=0; i<arr.length; i++) {
			stck.push(arr[i]);
		}
		view.print("Pop stack: ");
		for(int i=0; i<arr.length; i++) {
			view.print(stck.pop()+" ");
		}
		view.print("\n");
	}
	
	/**
	 * @description showArrlist(): muattor - displays arraylist contents via enhance for-loop
	 * @param array - arraylist to be provided as a parameter
	 */
	private void showArrList(ArrayList<String> array) {
		try {
			for(String i:array) {
				view.print(i+" ");
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description arrComparator(): mutator - sorts arraylist in reversed order
	 */
	private void arrComparator() {
		Comparator<String> revord = Collections.reverseOrder();
		try {
			Collections.sort(alist, revord);	//sorts list based on comparator
			view.print("Arraylist sorted in reversed order: ");
			showArrList(alist);
			
			Collections.shuffle(alist);	//shuffle list based on comparator
			view.print("\nArraylist shuffle list: ");
			showArrList(alist);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description addToString(): facilitator - displays array list
	 */
	private void addToString() {
		try {
			view.println("Arraylist initial size: "+ alist.size());
			view.println("Arraylist add element: "+ addElement());
			view.println("Arraylist replace elem: "+ removeElement());
			convertToArray();
			arrComparator();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Arraylist al = new Arraylist();
		al.addToString();
	}
}
