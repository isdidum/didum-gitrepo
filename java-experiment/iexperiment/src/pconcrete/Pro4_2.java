package pconcrete;

import callable.io.Print;
/**
 * @author Didum
 * date: January 16, 2013
 */
public class Pro4_2 {
	//private instance variables
	private int a, b, c;
	private int leg1, leg2, large;
	private Print view;
	
	/**
	 * Pro4_2(): default constructor
	 */
	public Pro4_2() {
		this(0, 0, 0);		//chaining constructor
		leg1 = leg2 = large = 0;
		view = new Print();
	}
	/**
	 * Pro4_2(): specific constructor
	 * @param sideA - side a
	 * @param sideB - side b
	 * @param sideC - side c
	 */
	public Pro4_2(int sideA, int sideB, int sideC) {
		a = sideA;
		b = sideB;
		c = sideC;
		leg1 = (leg2 = (large = 0));
		view = new Print();
	}
	
	/**
	 * findLargeSide(): accessor - finds larger value
	 * @return larger side
	 */
	public int findLargeSide() {
		try {
			if((a > b && a > c) || (a > b && b <= c && a >= c)) {
				large = a;
				leg1 = b;
				leg2 = c;
			} else if((b > a && b > c) || (b > c && c <= a && b >= a)) {
				large = b;
				leg1 = a;
				leg2 = c;
			} else if((c > a && c > b) || (c > a && a <= b && c >= b)) {
				large = c;
				leg1 = a;
				leg2 = b;
			}else if(a == b && b == c) {
				large = a;
				leg1 = b;
				leg2 = c;
			}
			return large;
		}catch(Exception e){
			e.printStackTrace();
		}
		return large;
	}
	
	/**
	 * @Descripton isRightTriangle(): accessor - return true/false
	 * @return boolean
	 */
	public boolean isRightTriangle() {
		boolean isTriangle = false;
		try {
			int lhs = leg1*leg1 + leg2*leg2;
			int rhs = findLargeSide()*findLargeSide();
			if(lhs == rhs) {
				isTriangle = true;
				return isTriangle;
			}else {
				isTriangle = false;
				return isTriangle;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isTriangle;
	}
	
	/**
	 * addToString(): mutator - displays results
	 */
	public void addToString() {
		String str = "";
		try {
			//int x = Integer.parseInt(args[0]);
			//char x = Character.parseInt(args[0]);
			if(isRightTriangle() == false)str = a +", "+ b+", "+c+" is a right triangle? " + isRightTriangle();
			view.println(str);
			view.println("A="+leg1*leg1+" B="+leg2*leg2 + " C="+large*large);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
