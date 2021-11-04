/**
 * @author Didum
 * date: October 17, 2012
 */

package myclient;

import myconcrete.Q5AConcrete;

public class Q5AClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ask is a reference variable to class Question5A imported from package training3class
		Q5AConcrete ask = new Q5AConcrete();
		System.out.println("Add: $"+ ((ask.myMoney1)+(ask.myMoney2)));
		System.out.println("Times: $"+ ((ask.myMoney1)*(ask.myMoney2)));
		System.out.println("Divide: $"+ ((ask.myMoney1)/(ask.myMoney2)));
		System.out.println("Minus: $"+ ((ask.myMoney1)-(ask.myMoney2)));
	}

}
