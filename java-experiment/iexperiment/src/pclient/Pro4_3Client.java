/**
 * @author Didum
 * date: January 17, 2013
 */
package pclient;

import java.util.Scanner;

import pconcrete.Pro4_3;
import callable.io.Print;

public class Pro4_3Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * this program collects total call length in minutes and calculate its cost
		 */
		
		Scanner scan = new Scanner(System.in);
		Pro4_3 refPro43;
		Print view = new Print();
		
		view.println("Enter total call length (0 to halt): ");
		int len = scan.nextInt();
		
		while(len != 0) {
			refPro43 = new Pro4_3(len);
			refPro43.addToString();
			
			view.println("Enter total call length (0 to halt): ");
			len = scan.nextInt();
		}
		
	}

}
