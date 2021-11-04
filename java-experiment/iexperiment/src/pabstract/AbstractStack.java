package pabstract;

import pinterface.InterfaceStack;

/**
 * AbstractStack: this is an abstract class growable stack via string definition
 * @author A., Didum
 * @date Match 24, 2013
 * @see callable.GStack
 * @see pinterface.InterfaceStack
 */
public abstract class AbstractStack implements InterfaceStack {
	
	/**
	 * AbstractStack(): default constructor
	 * @note invoke with setSize() & setStackArray()
	 */
	public AbstractStack() {
		this(null);		//chaining constructor: calls specific with array object
	}
	
	/**
	 * AbstractStack(): parameterized/specific constructor
	 */
	public AbstractStack(Object stackArray[]) {
		this(null,0);
	}
	
	/**
	 * Stack(): parameterized/specific constructor
	 */
	public AbstractStack(Object stackArray[], int size) {}
	
	/**
	 * setStack(): mutator - stack setter to be implemented in a subclass
	 */
	public abstract void setStack(Object stck[]);
	
	/**
	 * setStack(): method overload - stack setter to be implemented in a subclass
	 */
	public abstract void setStack(Object stck[], int size);
	
	/**
	 * setSize(): initial size of array
	 */
	public abstract void setSize(int size);
	
	/**
	 * push(): abstract method, implementation to be supplied in subclass
	 * @param item
	 */
	public abstract void push(Object oItem);
	
	/**
	 * pop(): concrete method with no body implementation
	 */
	public Object pop() {
		return null;
	}
	
	/**
	 * peek(): abstract method, implementation to be supplied in subclass
	 * @return
	 */
	public abstract Object peek();
	
	/**
	 * size(): concrete method, implementation to be supplied in subclass
	 * @return
	 */
	public int size(){return 0;}
	
	/**
	 * isEmpty(): concrete method, implementation to be supplied in subclass
	 * @return
	 */
	public boolean isEmpty(){return false;}
	
}
