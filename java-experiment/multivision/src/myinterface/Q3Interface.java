package myinterface;

/*
 * Notes: Interface
 * - provide a set of rules to follow, so does an Abstract class
 * - are created to be implemented - that's the ultimate goal of an Interface
 * - can only have abstract methods - methods w/o body implementation
 * - contains list of public methods, all methods are declared with 'public'
 * - concrete methods are methods w/o 'abstract' declaration
 * - you can implements multiple interfaces at a time, but you can only extend a class one at a time.
 * - Examples: Interface
 *   	public interface DeeInt1{...}
 *   	public interface DeeInt2{...}
 *   
 *   	public class DeeCncrt implements DeeInt1, DeeInt2, ..., infinity{...}
 *   	public class DeeClient {
 *   		public static void main(String args[]){...}
 *   	} 
 */

/**
 * @author A., Didum
 * date: October 18, 2012
 */
public interface Q3Interface {
	public int doAdd(int i, int j);
	public int doMinus(int i, int j);
	public int doTimes(int i, int j);
	public double doDivide(int i, int j);
}
