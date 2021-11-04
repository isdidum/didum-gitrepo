/**
 * Training day-1
 * October 15, 2012
 */

package com.djava;

public class ShortCircuit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//method 2-shortcircuit
		byte a=10; byte b=20; byte c=15;
		
		if((a>b) && (a>c)){
			System.out.println("a is the greatest");
		} else if((b>a) && (b>c)){
			System.out.println("b is the greatest");
		} else
			System.out.println("c is the greatest");

	}

}
