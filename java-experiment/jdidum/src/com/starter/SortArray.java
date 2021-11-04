//Author: A., Didum
//Date: September 04, 2012
//Purpose: collects list of integer input values and sorts the list in descending order

package com.starter;
import java.util.*; //imports all util methods

public class SortArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int cntr = 0, num;
		int sortAsnd[] = new int[7]; //p.243, int[] sortAsnd; //normal way to declare array
		
		do {
			System.out.print("Enter an integer (0 to halt): ");
			num = keyboard.nextInt();
			cntr += 1;
			sortAsnd[cntr] = num;
			
			if(num == 0){
				cntr -= 1;
				break;
			}
		} while(cntr > 0 && num != 0);
		
		//orderDescending(): invocation then use enhanced for-loop
		orderDescending(sortAsnd);
		for(int k:sortAsnd)
			System.out.print("DESCENDING ORDER (Z-A) = " + k+"\n");
		
		keyboard.close();
	}
	/**
	 * @param orderAsnd
	 * orderAscend(): mutator method
	 * sort: descending order(Z-A) - from highest to lowest
	 */
	public static void orderDescending(int orderAsnd[]){
		int temp;
		
		for(int i=0; i<orderAsnd.length; i++){
			for(int j=i+1; j<orderAsnd.length; j++){
				if(orderAsnd[i] < orderAsnd[j]){
					temp = orderAsnd[i];
					orderAsnd[i] = orderAsnd[j];
					orderAsnd[j] = temp;
				}
			}
		}
	}

}
