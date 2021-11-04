/**
 * @author Didum
 * date: October 17, 2012
 */
package training3;

import java.util.Scanner;

public class Question2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double bal, irate;
		int yrs;
		
		System.out.print("Enter balance: ");
		bal = input.nextDouble();
		
		System.out.print("Enter rate: ");
		irate = input.nextDouble();
		
		System.out.print("Enter number of years: ");
		yrs = input.nextInt();
		
		//findInterest(): method invocation
		String fIntr = findInterest(bal, irate, yrs);
		System.out.println("Interest = $"+ fIntr);
		
		input.close();
	}
	//findInterest(): accessor method
	public static String findInterest(double p, double rate, int numYrs){
		double intr;
		intr = p*rate*numYrs;
		String itr = Double.toString(intr);
		return itr;
	}
}
