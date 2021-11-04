package callable;

import pabstract.AbstractStack;
import callable.io.Print;
//import pinterface.InterfaceStack;

/**
 * GStack: this is a growable stack
 * @author A., Didum
 * @date Match 24, 2013
 * @see pinterface.InterfaceStack
 * @see pabstract.AbstractStack
 */
public class GStack extends AbstractStack/* implements InterfaceStack*/ {
	private Object stackArray[] = null; //private instance variables are not visible in childclass
	protected int pos;
	protected int size;
	private Print p = new Print();
		
	public GStack(){
		this(null,0);
		pos = -1;
		size = 0;
		stackArray = new Object[size];
	}
	
	/**
	 * StackGrowble(): specific constructor
	 * @param stackArray
	 */
	public GStack(Object[] stackArray) {
		super(null,0);
		pos = -1;
		size = stackArray.length;
		this.stackArray = new Object[size];
		this.stackArray = stackArray;
	}
	
	/**
	 * GStack(): specific constructor with array and integer
	 * @param stackArray
	 * @param size
	 */
	public GStack(Object stackArray[], int size){
		this.size = size;
		pos = -1;
		this.stackArray = new Object[this.size];
		this.stackArray = stackArray;
	}
	
	/**
	 * setSize(): pins the size of the array
	 */
	@Override
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * setStack(): mutator - defines the stack array
	 */
	@Override
	public void setStack(Object stackArray[]) {
		this.stackArray = new String[size];
		this.stackArray = stackArray;
	}
	
	/**
	 * setStack(): mutator - defines the stack array
	 */
	@Override
	public void setStack(Object stackArray[], int size) {
		this.size = size;
		this.stackArray = new String[this.size];
		this.stackArray = stackArray;
	}
	
	/**
	 * getStack(): accessor - returns an array of elements
	 * @return stack array
	 */
	public Object[] getStack() {
		try {
			return stackArray;
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * push(): Adds an element onto the stack
	 */
	@Override
	public void push(Object oItem) {
		//prevents stack overflow - the list is full
		if(pos == stackArray.length-1) {
			//allocate a larger stack if Stack is full by doubling its size
			//p.println("Stack-overflow: cannot add \'"+oitem+"\' to a full stack");
			Object temp[] = new String[stackArray.length * 2];
			for(int i=0; i<stackArray.length; i++) {
				temp[i] = stackArray[i];
			}
			stackArray = temp;
			stackArray[++pos] = oItem;
		} else {
			stackArray[++pos] = oItem;
		}
	}
	
	/**
	 * pop(): Removes and returns the top element from the stack. Truncates stack array
	 */
	@Override
	public Object pop(){
		if(pos < 0) {
			p.println("Stack-underflow: cannot pop from an underflow stack");
			return null;
		} else {
			return stackArray[pos--];
		}
	}

	
	/**
	 * peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 */
	@Override
	public Object peek() {
		if(isEmpty()) {
			p.println("Stack-empty: cannot peek from an empty stack");
			return null;
		}
		return stackArray[pos];
	}
	
	/**
	 * size(): returns the number of elements in the stack
	 * @return integer
	 */
	@Override
	public int size() {
		return pos;
	}

	/**
	 * isEmpty(): true for empty, false otherwise.
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return (pos == -1);
	}

}
