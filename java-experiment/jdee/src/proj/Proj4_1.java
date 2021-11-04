//Author: A., Didum
//Date: September 15, 2012
//Purpose: Collects two integer inputs and compute to display their quotient and remainder as outputs

package proj;
import java.util.*;

public class Proj4_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int val1, val2, largeVal, smallVal;
		int quotient, remainder;
		
		System.out.print("Enter an integer (0 to halt): ");
		val1 = input.nextInt();
		
		while(val1 != 0){
			System.out.print("Enter an integer: ");
			val2 = input.nextInt();
			
			//divide large by small number
			largeVal = largeValue(val1, val2);
			smallVal = smallValue(val1, val2);
						
			quotient = largeVal / smallVal;
			remainder = largeVal % smallVal;
			if(remainder == 0){
				System.out.printf("Large value is %1.2f%n", (double)largeVal); // p.693 Java 5.0
				System.out.printf("Small value is %1.2f%n", (double)smallVal); // p.693 Java 5.0
				System.out.println("Quotient = "+quotient+ " Remainder = "+remainder);
				System.out.println("Fraction = "+largeVal+"/"+smallVal+ " --> " + quotient+" ~~> " + (double)largeVal/(double)smallVal);
			} else {
				System.out.printf("Large value is #%1.2f%n", (double)largeVal); // p.693 Java 5.0
				System.out.printf("Small value is #%1.2f%n", (double)smallVal); // p.693 Java 5.0
				System.out.println("Quotient = "+quotient+ " Remainder = "+remainder);
				System.out.println("Fraction = "+largeVal+"/"+smallVal+ " --> " + quotient+ " " 
				+ remainder + "/" +smallVal+" ~~> " + (double)largeVal/(double)smallVal);
			}
			
			
			System.out.print("\nEnter an integer (0 to halt): ");
			val1 = input.nextInt();
		}
		
		
		input.close();
	}
	
	//largeValue(): returns largest of val1 and val2
	public static int largeValue(int v1, int v2){
		int temp = 0;
		if(v1 > v2){
			temp = v1;
			v1 = v2;
			v2 = temp;
		} else {
			temp = v2;
			v2 = v1;
			v1 = temp;
		}
		return temp; 
	}
	
	//smallValue(): returns smallest of val1 and val2
	public static int smallValue(int v1, int v2){
		int temp = 0;
		if(v1 < v2){
			temp = v1;
			v1 = v2;
			v2 = temp;
		} else {
			temp = v2;
			v2 = v1;
			v1 = temp;
		}
		return temp; 
	}
}
