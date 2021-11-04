/**
 * Training day-1: Assignment1
 * October 15, 2012
 */
package training1;

import java.util.*;

public class Assignment1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//invokes scanner class for reading user-inputs
		Scanner input = new Scanner(System.in);
		int int1, int2;
		
		System.out.print("Enter an integer (0 to halt): ");
		int1 = input.nextInt();
		while(int1 != 0){
			System.out.print("Enter an integer: ");
			int2 = input.nextInt();
			
			//getAB(): invocation
			getAB(int1, int2);
			
			System.out.print("Enter an integer (0 to halt): ");
			int1 = input.nextInt();
		}
		input.close();
	}
	
	//getAB(): mutator method - takes two integer values as formal-parameters
	public static void getAB(int getA, int getB){
		String add, minus, times, divide;
		int gMinus;
		double gdiv;
		
		//checks to ensure A is not equal to B
		if(getA != getB){
			//checks for larger value
			if(getA > getB){
				gdiv = (double)getA / getB;
				divide = "Division of ("+ getA + ","+ getB +") = "+ (gdiv);
				gMinus = getA - getB;
			} else { 
				gdiv = (double)getB / getA;
				divide = "Division of ("+ getB + ","+ getA +") = "+ (gdiv);
				gMinus = getB - getA;
			}
			
			add = "\nAddition of ("+ getA + ","+ getB +") = "+ (getA+getB);
			minus = "Subtraction of ("+ getA + ","+ getB +") = "+ (gMinus);
			times = "Multiplication of ("+ getA + ","+ getB +") = "+ (getA*getB);
			
			System.out.println(add);
			System.out.println(minus);
			System.out.println(times);
			System.out.println(divide);
		} else {
			System.out.println("---------------------------");
			System.out.println("Can\'t have exact integers.");
			System.out.println("---------------------------");
		}
	}

}
