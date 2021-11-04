//Author: A., Didum
//Date: September 16, 2012
//Purpose: Computes and displays salary of school teacher in Bellingham School District
//			based on experience

package proj;
//import java.util.*;

public class Proj4_8 {
	
	//global variables
	final static int years = 10;
	final static double balPrincipal = 2.0*Math.pow(10, 4);
	final static double rate = 2/100.00;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		displayOutput();
	}
	
	//computeSalary(): returns salary of a teacher at Bellingham School District
	public static void computeSalary(){
		double amountFinal[] = new double[years];
		int i;
		System.out.println("Year \t Principal of Teacher at BSD");
		System.out.println("-----\t| ----------");
		for(i=0; i<years; i++){
			amountFinal[i] = balPrincipal*Math.pow((1+rate), i);
			System.out.println(i + "\t| $"+ amountFinal[i]);
			System.out.println("-----\t| ----------");
		}
		
	}
	
	public static void displayOutput(){ 
		computeSalary();
	}
}
