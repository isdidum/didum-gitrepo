/**
 * @author Didum
 * date: October 18, 2012
 */

package myclient;

import myconcrete.Q4Concrete;

public class Q4Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Q4Concrete q4 = new Q4Concrete();
		q4.upperCaseNameCheck("My NaMe Is DiDuM.");
		q4.convertLowerToUpperCase("my name is didum.");
		q4.stringsToIntegers("7");
	}

}
