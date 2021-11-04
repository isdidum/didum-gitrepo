package pconcrete;

import callable.io.Print;
/**
 * @author A., Didum
 * @date: January 17, 2013
 * @description Pro4_3(): concrete class
 */
public class Pro4_3 {
	//private instance variables
	private double twoMinutes;
	private double oneMinute;
	private double addedMinute;
	private int callLength;
	private Print view;
	
	/**
	 * Pro4_3(): default constructor
	 */
	public Pro4_3() {
		this(0);
		callLength = 0;
		addedMinute = 0.50;
		twoMinutes = 1.15;
		oneMinute = twoMinutes / 2;
		view = new Print();
	}
	
	/**
	 * Pro4_3(): specific constructor
	 */
	public Pro4_3(int totalLength) {
		callLength = totalLength;
		addedMinute = 0.50;
		twoMinutes = 1.15;
		oneMinute = twoMinutes / 2;
		view = new Print();
	}
	
	/**
	 * addToString(): mutator - calculates and displays cost
	 */
	public void addToString() {
		double cost;
		try {
			cost = oneMinute * callLength + addedMinute;
			view.printf("Total cost = $%1.2f%n", cost); //printf(str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
