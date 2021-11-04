//Author: A., Didum
//Date: September 03, 2012
//Purpose: Finds prime numbers in the range of lower and upper limits provided by end-user

package com.starter;

import java.util.*; //imports all util methods

public class FindPrime {
	//global variable
	static int lower, upper;
	
	/**
	 * @param args
	 * main(): application entry point to client
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j;
		double innerLimit;
		
		System.out.print("Enter lower limit (-1 to halt): ");
		lower = input.nextInt();
		
		while(lower != -1) {
			System.out.print("Enter upper limit: ");
			upper = input.nextInt();
			
			//Prime = natural number greater than 1 that has no positive divisors other than 1 and itself
			for(i = lower; i <= upper; i++){ 		//p.192, use a while loop for multiple pairs
				innerLimit = (int)Math.sqrt(i); 	//type cast
				for(j = 2; j <= innerLimit; j++){
					if(i % j == 0) break;
				} 
				if(j > innerLimit)
					System.out.println(i + " is prime \t j="+j);
			}
			System.out.print("\nEnter lower limit (-1 to halt): ");
			lower = input.nextInt();
		}
		input.close();
	} //main(): ends

}
