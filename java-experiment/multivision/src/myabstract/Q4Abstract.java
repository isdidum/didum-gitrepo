/**
 * @author Didum
 * date: October 18, 2012
 */

package myabstract;

//import statements go here...

/*
 * Notes: Abstract classs
 * - provide a set of rules to follow, so does an Interface
 * - are created to be extended - that's the ultimate goal of an abstract class
 * - concrete methods are still allowed in abstract classes
 * - concrete methods are methods w/o 'abstract' declaration
 * - never, never use 'final' on abstract methods/variables/classes?
 * - has no constructor as it cannot be instantiated
 * - Example: Abstract
 *   	public abstract class A1Abs1{...}
 *   	public abstract class A1Abs2{...}
 *   
 *   	public class A1Cncrt extends A1Abs1{...}
 *   	public class A1Cncrt extends A1Abs2{...}
 *   
 *   	public class A1Client {
 *   		public static void main(String args[]){...}
 *   	}
 */
public abstract class Q4Abstract {
	//uppperCaseNameCheck(): abstract method
	public abstract void upperCaseNameCheck(String istr);
	
	//lowerToUpperCase(): abstract method
	public abstract void convertLowerToUpperCase(String istr);
	
	//stringsToIntegers(): concrete method
	public void stringsToIntegers(String istr){
		int myint=0;
		try {
			myint = Integer.parseInt(istr);
			System.out.println("iii. String ("+istr+"+10) = "+(myint+10));
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
