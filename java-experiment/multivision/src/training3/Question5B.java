/**
 * @author Didum
 * date: October 17, 2012
 */

package training3;

//import java.util.Scanner;

public class Question5B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int fibonacci;

		for(int i = 1; i < 50; i++) {
			//useFibonacci(): method invocation
			fibonacci = useFibonacci(i);
			if (fibonacci > 100) break;
			System.out.println("Fibonacci("+i+") = "+fibonacci);
		}
	}
	
	//useFibonacci(): accessor method - calculates Fibonacci via Recursive Method (calls itself)
	public static int useFibonacci(int n){
		if(n <= 2)
			return 1;
		else
			return useFibonacci(n-1) + useFibonacci(n-2);
	}

}
