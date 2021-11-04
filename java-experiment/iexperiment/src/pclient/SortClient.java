
package pclient;

import java.util.*;

import callable.Sort;

/**
 * @author A., Didum
 * @date January 17, 2013
 * @description SortClient(): Client or demo class
 */
public class SortClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int SIZE = 8;
		Scanner scan = new Scanner(System.in);
		Sort refSort = null;
		int cntr = 0;
		double alist[] = new double[SIZE], input;
		double olist[] = new double[SIZE];
		double elist[] = new double[SIZE];
		
		while(cntr != SIZE) {
			System.out.println("Enter a value: ");
			input = scan.nextDouble();
			alist[cntr] = input;

			if(alist[cntr] % 2 == 0)
				elist[cntr] = alist[cntr];
			else if(alist[cntr] % 2 != 0)
				olist[cntr] = alist[cntr];

			cntr++;
			if(cntr == SIZE) {
				break;
			}
		}//ends while-loop
		System.out.println("Enter an integer lower bound: ");
		int lower = scan.nextInt();
		System.out.println("Enter an integer upper bound: ");
		int upper = scan.nextInt();
		
		refSort = new Sort(SIZE, alist, lower, upper);
		refSort.displayContents(alist, alist, elist, olist);
		//refSort.findPrime();
	}

}
