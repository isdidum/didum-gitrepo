/**
 * Training day-1: Assignment2
 * October 15, 2012
 */
package training1;

import java.util.*;

public class Assignment2 {

	/**
	 * @param args
	 * directive: Swap two numbers without a third variable
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		
		System.out.print("Enter an integer (-1 to halt): ");
		a = input.nextInt();
		
		while(a != -1) {
			System.out.print("Enter an integer: ");
			b = input.nextInt();
		
			//swap(): invocation
			System.out.println(swap(a,b));
			
			System.out.print("Enter an integer (-1 to halt): ");
			a = input.nextInt();
		}
		input.close();
	}
	
	//swap(): mutator method - swaps two numbers without a third variable
	public static String swap(int myA, int myB){
		myA = myA + myB;
		myB = myA - myB;
		myA = myA - myB;
		return "Numbers swapped: "+ myA +" and "+ myB;
	}

}
