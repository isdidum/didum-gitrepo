package pclient;

import java.util.Scanner;

import pconcrete.Pro4_2;
import callable.io.Print;

public class Pro4_2Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * this program collects three input integers and determine if inputs make up a right-triangle
		 */
		
		int val1, val2, val3;
		Pro4_2 refpro42;
		Scanner scan = new Scanner(System.in);
		Print view = new Print();
		
		view.println("Enter 1st integer (0 to halt): ");
		val1 = scan.nextInt();
		while(val1 != 0) {
			view.println("Enter 2nd integer: ");
			val2 = scan.nextInt();
			
			view.println("Enter 3rd integer: ");
			val3 = scan.nextInt();
			
			refpro42 = new Pro4_2(val1, val2, val3);
			refpro42.addToString();
			
			view.println("Enter 1st integer (0 to halt): ");
			val1 = scan.nextInt();
		}

	}

}
