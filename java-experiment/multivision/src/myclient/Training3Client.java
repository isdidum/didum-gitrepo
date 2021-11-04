package myclient;

import myconcrete.Training3Concrete;

public class Training3Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Training3Concrete t3 = new Training3Concrete();
		
		System.out.println("Add: "+ t3.doAdd(2, 3));
		System.out.println("Minus: "+ t3.doMinus(2, 3));
		System.out.println("Divide: "+ t3.doDivide(2, 5));
		System.out.println("Times: "+ t3.doTimes(3, 5));
	}

}
