package myclient;

import myconcrete.Q3Concrete;
/**
 * @author A., Didum
 * date: October 17, 2012
 */
public class Q3Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Q3Concrete q3 = new Q3Concrete();
		
		System.out.println("Add: "+ q3.doAdd(4, 7));
		System.out.println("Minus: "+ q3.doMinus(7, 2));
		System.out.println("Divide: "+ q3.doDivide(2, 7));
		System.out.println("Times: "+ q3.doTimes(3, 5));
	}
}
