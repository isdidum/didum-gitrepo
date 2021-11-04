/**
 * Training day-1
 * October 15, 2012
 */

package com.djava;

public class GreatestOfThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Method-One
		byte a = 4;
		byte b = 6;
		byte c = 1;
		
		//check if a>b
		if(a > b){
			//check if a>c
			if(a > c){
				System.out.println("a is the greatest");
			} else if(c > b){
				System.out.println("c is the greatest");
			}
		} else if(b > c){
			System.out.println("b is the greatest");
		} else {
			System.out.println("c is the greatest");
		}
	}	
}
