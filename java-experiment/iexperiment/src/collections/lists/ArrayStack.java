package collections.lists;

import java.util.ArrayList;

/**
 * ArrayStack: Linear collections with access restricted to one end, top. This is based on arrays and linked structures
 * @author A., Didum
 * @date August 07, 2013
 * @notes This program adhere to a last-in first-out (LIFO) implementation/protocol
 */
public class ArrayStack {
	private ArrayList<Object> list;
	
	/**
	 * ArrayStack(): default constructor
	 */
	public ArrayStack() {
		list = new ArrayList<Object>();
	}
	
	/**
	 * peekTop(): returns top element but does not truncate stack size
	 * @return top element
	 */
	public Object peekTop(){
		try{
			if(list.isEmpty()) throw new IllegalStateException("Stack is empty");
			return list.get(list.size() - 1);
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * push(): accessor - pushes an element to the list, ArrayList
	 * @param obj
	 */
	public void push(Object obj){
		try{
			list.add(obj);
		}catch(Exception err){err.printStackTrace();}
	}
	
	/**
	 * pop(): accessor - pops an element from the list, ArrayList
	 * @return
	 */
	public Object pop(){
		try{
			if(list.isEmpty()) throw new IllegalStateException("Stack is empty");
			return list.remove(list.size() - 1);
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * size(): returns the size of the list
	 * @return
	 */
	public int size(){
		try{
			return list.size();
		}catch(Exception err){err.printStackTrace();}
		return 0;
	}
}
