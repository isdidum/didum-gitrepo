package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 22, 2013
 * @description GenConstructor(): this is a generic constructor method with one or more parameters 
 */
public class GenConstructor {
	//instance var
	private double val;
	private Print view;
	/**
	 * GenConstructor(): specific constructor
	 * @param arg
	 */
	<Type extends Number> GenConstructor(Type arg) {
		val = arg.doubleValue();
		view = new Print();
	}
	
	/**
	 * showValue(): facilitator
	 */
	void showVal() {
		view.println("Value: "+val);
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		GenConstructor t1 = new GenConstructor(100);
		GenConstructor t2 = new GenConstructor(125.50F);
		
		t1.showVal();
		t2.showVal();
	}

}
