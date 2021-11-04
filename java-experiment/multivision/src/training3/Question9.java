/**
 * @author Didum
 * date: October 17, 2012
 */
package training3;

import java.util.Scanner;

public class Question9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double iA, iB;
		
		System.out.print("Enter 1st number (-1 to halt): ");
		iA = input.nextDouble();
		while(iA != -1){
			System.out.print("Enter 2nd number: ");
			iB = input.nextDouble();

			//minOfTwoNums(): method invocation
			minOfTwoNums(iA, iB);
			System.out.print("Enter 1st number (-1 to halt): ");
			iA = input.nextDouble();
		}
		
		input.close();
	}
	
	//minOfTwoNums(): mutator method - uses condiation operator to find minimum number
	public static void minOfTwoNums(double iNum, double jNum){
		double minNum;
		minNum = (iNum > jNum) ? jNum : iNum;
		minNum = (jNum > iNum) ? iNum : jNum;
		
		System.out.println("Minimum = "+minNum);
	}

}
