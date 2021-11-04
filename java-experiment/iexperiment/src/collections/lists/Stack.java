
package collections.lists;
import callable.io.Print;
/**
 * Stack(): this is fixed size stack implementation
 * @author A., Didum
 * @date February 08, 2013
 * @notes Stack is a subclass of Vector that implements last-in, first-out stack element.
 * Array to be used is to be defined in client class
 */
public class Stack extends Print {
	
	private static final long serialVersionUID = 1L;
	//private instance variables that cannot be accessed by a subclass
	private Object stackArray[];	
	private int pos;
	private int size;	//size of array
	
	/**
	 * Stack(): default constructor
	 * @note invoke with setSize() & setStackArray()
	 */
	public Stack() {
		this(null,0);		//chaining constructor: calls specific with array object
		pos = -1;
		size = 0;
		stackArray = new Object[size];
	}
	
	/**
	 * Stack(): parameterized/specific constructor
	 */
	public Stack(Object stackArray[]) {
		this(null,0); //chaining constructor: calls specific with array object and integer size
		pos = -1;
		size = stackArray.length;
		this.stackArray = new Object[size];
		this.stackArray = stackArray;
	}
	
	/**
	 * Stack(): parameterized/specific constructor
	 */
	public Stack(Object stackArray[], int size) {
		pos = -1;
		this.size = size;
		this.stackArray = new Object[size];
		this.stackArray = stackArray;
	}
	
	/**
	 * setSize(): sets the initial size of the array. Invoke with default constructor
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * setStackArray(): defines array for stack. Invoke with default constructor
	 * @param stackArray
	 */
	public void setStackArray(Object stackArray[]){
		this.stackArray = new Object[size];
		this.stackArray = stackArray;
	}
	
	/**
	 * push(): mutator - adds an element onto the stack
	 */
	public void push(Object item) {
		try {
			if(pos == stackArray.length-1) {
				println("Stack-overflow: cannot add \'"+item+"\' to a full stack");
			} else {
				stackArray[++pos] = item;
			}
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * pop(): mutator - pops an element from the top of the stack, returns null if underflow
	 */
	public Object pop() {
		try {
			if(pos < 0) {
				println("Stack-underflow: cannot pop from an underflow stack");
				return null; //-1
			} else {
				return stackArray[pos--];
			}
		} catch (Exception err) {err.printStackTrace();}
		return null; //-1
	}
	
	/**
	 * peek(): retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return
	 */
	public Object peek(){
		if(isEmpty()) {
			println("Stack-empty: cannot peek from an empty stack");
			return null;
		}
		return stackArray[pos];
	}
	
	/**
	 * size(): returns the number of elements in the stack
	 * @return
	 */
	public int size(){ 
		return pos;
	}
	
	/**
	 * isEmpty(): return true for empty stack, false otherwise.
	 * @return boolean
	 */
	public boolean isEmpty(){
		return (pos == -1);
	}
}
