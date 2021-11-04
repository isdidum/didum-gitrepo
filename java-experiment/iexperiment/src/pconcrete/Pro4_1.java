
package pconcrete;

import java.util.Scanner;
import callable.io.Print;


/**
 * @author A., Didum
 * @date: January 16, 2013
 * @description Pro4_1(): This program outputs quotient and remainder given numerator & denominator
 */
public class Pro4_1 {
	//instance variables
	private int numer;
	private int denom;
	private Print view;
	
	/**
	 * @Descripton Pro4_1(): default constructor
	 */
	public Pro4_1() {
		this(0, 0);		//chaining constructor - always first statement
		view = new Print();
	}
	/**
	 * Pro4_1(): specific constructor
	 */
	public Pro4_1(int numer, int denom) {
		view = new Print();
		this.numer = numer;
		this.denom = denom;
	}
	
	/**
	 * setNumerator(): mutator - collects numerator
	 * @param numerator
	 */
	public void setNumerator(int numer) {
		try {
			this.numer = numer; 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * setDenominator(): mutator - collects denominator
	 * @param denominator
	 */
	public void setDenominator(int denom) {
		try {
			this.denom = denom; 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getNumerator(): accessor - collects numerator
	 * @return numerator
	 */
	private int getNumerator() {
		try {
			return numer;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numer;
	}
	
	/**
	 * getDenominator(): accessor - collects denominator
	 * @return denomonator
	 */
	private int getDenominator() {
		try {
			return denom;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return denom;
	}
	
	/**
	 * getQuotient(): accessor - returns quotient
	 * @return quotient
	 */
	private int getQuotient() {	
		int quo = 0;
		try {			
			quo = getNumerator() / getDenominator();
			return quo;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return quo;
	}
	
	/**
	 * getQuotient(): accessor - returns remainder
	 * @return remainder
	 */
	private int getRemainder() {	
		int rem = 0;
		try {			
			rem = getNumerator() % getDenominator();
			return rem;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rem;
	}
	
	/**
	 * toString(): facilitator - displays results
	 * @return results
	 */
	public String toString() {
		String string = "";
		try {
			//int x = Integer.parseInt(args[0]);
			//char x = Character.parseInt(args[0]);
			if(getRemainder() == 0) {
				string = numer +"/"+ denom + " = " +getQuotient();
				view.println("");
			} else if(getRemainder() != 0 && (numer/denom) > 0) {
				string = numer +"/"+ denom + " = " +getQuotient() + " rem "+ getRemainder();
			} else if((numer/denom) <= 0 && getRemainder() != 0) {
				string = numer +"/"+ denom + " = " +getQuotient() + " rem "+ getRemainder()+"/"+denom;
			}
			return string;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		int nume, deno;
		Scanner scan = new Scanner(System.in);
		Print view = new Print();
		
		view.println("This program collects two input integers and displays their quotient and remainder as output");
		view.println("Enter numerator (0 to halt): ");
		nume = scan.nextInt();
		while(nume != 0) {
			view.println("Enter denominator: ");
			deno = scan.nextInt();
			Pro4_1 refpro4 = new Pro4_1(nume, deno);
			view.println(refpro4.toString());
			view.println("Enter numerator (0 to halt): ");
			nume = scan.nextInt();
		}
	}
	
}
