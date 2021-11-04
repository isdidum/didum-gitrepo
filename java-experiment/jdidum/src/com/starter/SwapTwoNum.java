//@author: A., Didum
//Date: October 15, 2012
//Purpose: Swap two numbers with a third variable, also see Assignment2 under training1-package 

package com.starter;

import java.util.*;

public class SwapTwoNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numA, numB;
		
		System.out.print("Enter an integer (-1 to halt): ");
		numA = input.nextInt();
		while(numA != -1){
			System.out.print("Enter an integer: ");
			numB = input.nextInt();
			
			//mySwap(): invocation
			System.out.println(mySwap(numA,numB));
			
			System.out.print("Enter an integer (-1 to halt): ");
			numA = input.nextInt();
		}
		input.close();

	}
	
	//mySwap(): accessor - method
	public static String mySwap(int i, int j){
		int temp;
		temp = i;
		i = j;
		j = temp;
		return "Swapped ("+temp+","+i+") as: ("+i+" and "+j+")";
	}

}
