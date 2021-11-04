package myconcrete;

import myinterface.*;

/**
 * @author A., Didum
 * @Date: October 18, 2012
 */
public class Q3Concrete implements Q3Interface{
	//private instance variables go here..
	
	/**
	 * @Description Question3(): default constructor
	 */
	public Q3Concrete() {}

	@Override
	public int doAdd(int i, int j) {
		// implements details or add body here...
		int iadd=0;
		try{
			iadd = i+j;
			return iadd;
		} catch(Exception e){e.printStackTrace();}
		return 0;
	}

	@Override
	public int doMinus(int i, int j) {
		// implements details or add body here...
		int large = 0;
		try {
			if(i > j) { 
				large = i - j;
			} else {
				large = j - i;
			}
			return large;
		} catch (Exception e){e.printStackTrace();}
		return 0;
	}

	@Override
	public int doTimes(int i, int j) {
		// implements details or adds body here...
		int itimes = 1;
		try{
			itimes = i * j;
			return itimes;
		} catch(Exception e){e.printStackTrace();}
		return 0;
	}

	@Override
	public double doDivide(int i, int j) {
		// implements details or adds body here...
		double large = 1;
		try {
			if(i > j) { 
				large = (double)i / j;
			} else {
				large = (double)j / i;
			}
			return large;
		} catch (Exception e) {e.printStackTrace();}
		return 0.0;
	}
	
}
