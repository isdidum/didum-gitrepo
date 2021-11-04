package pinterface;

/**
 * InterfaceStack: this is an interface growable stack via string definition
 * @author A., Didum
 * @see callable.GStack
 * @see pabstract.AbstractStack
 * @date Match 24, 2013
 */
public interface InterfaceStack {
	
	/**
	 * push(): mutator - stores an element to the top of the stack
	 * @param oItem - item to be added stack array
	 */
	public void push(Object oItem);
	
	/**
	 * pop(): accessor - retrieves an element from the stack & truncates stack
	 */
	public Object pop();
	
	/**
	 * setStack(): mutator - pins down the stack array
	 * @param stck - an array
	 */
	public void setStack(Object stck[]);
	
	/**
	 * setStack(): method overload - pins down the stack array to push items into it
	 * @param stck - an array
	 * @param size - an integer
	 */
	public void setStack(Object stck[], int size);
	
	/**
	 * peep(): accessor - retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return object
	 */
	public Object peek();
	
	/**
	 * size(): returns the number of elements in the stack
	 * @return integer
	 */
	public int size();
	
	/**
	 * isEmpty(): return true if stack is empty, false otherwise.
	 * @return boolean
	 */
	public boolean isEmpty();
}
