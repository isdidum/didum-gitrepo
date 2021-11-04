//Author: A., Didum
//Date: September 05, 2012
package com.starter;

import java.io.*; 		//necessary for I/O files
import java.util.*;		//necessary for reading inputs


public class ReadFileTest {

	/**
	 * @param args
	 * absolute path: "/Users/didum4/documents/workspace/jdidum/src/jtxt/multivision.txt"
	 * relative path: "../../jtxt/multivision.txt"
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		final double COST_TEST = 1.5/2;
		System.out.printf("The cost is $%1.3f%n", COST_TEST); // p.693 Java 5.0
		String myLine, curLine; 
		String strAry[]; Scanner input;
		
		
		try {
			File file = new File("C:/Users/Didum/oraclewrksp/jdidum/src/jtxt/multivision.txt");
			//File file = new File("../../jtxt/multivision.txt");
			input = new Scanner(file);
			curLine = input.nextLine();
			
			if(curLine.contains(":")){
				myLine = java.util.Arrays.toString(curLine.split(":"));
				strAry = curLine.split(":");
				System.out.println("Current line = "+curLine+"\nMy line = "+myLine+"\nString array = "+strAry);
							
				String fChar, sChar;
				fChar = strAry[0].substring(0, 1);
				sChar = strAry[1].substring(0, 1);

				for(int i=0; i<strAry.length; i++){
					if(i == 0) System.out.println("Firstname: "+fChar.toUpperCase() + strAry[i].substring(1));
					if(i == 1) System.out.println("Lastname: "+sChar.toUpperCase() + strAry[i].substring(1));
					if(i == 2) System.out.println("City: "+strAry[i]);
					if(i == 3) System.out.println("State: "+strAry[i]);
				}
				
				input.close();
			} else {
				getError();
			}
			
		} catch(Exception e) {
			System.err.print("Error: "+ e.getMessage() + "\n Description: "+ e.toString());
		}	
	}
	//getError(): accessor method - returns error message
	public static String getError(){
		return "Text lines do not contain the character of ':'.";
	}
}
