//Author: A., Didum
//Date: September 02, 2012
//Purpose: Converts from pounds to kilograms and vice-versa 

package com.starter;

import java.util.*; //imports all util methods


public class PoundsToKg {
	//static variable is essentially a global variable
	static double lbmkg;
	
	/**
	 * @param args
	 * CTRL+Space = Code Assist
	 * main(): application entry point to client (HelloWorld.java)
	 */
	public static void main(String[] args){		
		//Requests the inputs
		Scanner keyboard = new Scanner(System.in);
		int option;
		
		do {
			System.out.print("Enter pounds/kilogram (-1 to halt): ");
			lbmkg = keyboard.nextDouble();
			if(lbmkg == -1.00 || lbmkg == -1) break;
			
			System.out.println("Please Select Dimension");
			System.out.println("(1). kg");
			System.out.println("(2). lbm");
			System.out.print("Enter an integer associated with dimension: ");
			option = keyboard.nextInt(); 
			
			//myMeny(): invocation
			myMenu(option);
			
		} while(lbmkg != -1.00 || lbmkg != -1);
		
		keyboard.close(); //
	}
	/**
	 * additional methods go outside of method main
	 */
	
	//myMenu(): mutator method
		public static void myMenu(int myOpt){
			switch(myOpt){
			case 1:
				double mlbm = toPounds(lbmkg);
				System.out.println(lbmkg + "[kg] = "+mlbm+"[lbm]");
				break;
			case 2:
				double mkg = toKilograms(lbmkg);
				System.out.println(lbmkg + "[lbm] = "+mkg+"[kg]");
				break;
			default:
				System.out.println("Invalid entry - not an option!");
				break;
			}
		}
	
	//toPounds(): accessor method - converts from kilogram to pounds
		public static double toPounds(double given){
			double vKg = given*2.205;
			return vKg;
		}
	
	//toKilogram(): accessor method - converts from pounds to kilogram
	public static double toKilograms(double given){
		double vLbm = given/2.205;
		return vLbm;
	}
}
