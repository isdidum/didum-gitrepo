/**
 * @author Didum
 * date: October 17, 2012
 */
package myconcrete;

//add implements interface
public class Training3Concrete {

	/**
	 * TestTraining3(): default constructor
	 */
	public Training3Concrete() {
		
	}
	
	public int doAdd(int i, int j){
		return (i+j);
	}
	
	public int doMinus(int i, int j){
		return (i-j);
	}
	
	public int doTimes(int i, int j){
		return (i*j);
	}
	
	public double doDivide(int i, int j){
		return (double)i/j;
	}
}
