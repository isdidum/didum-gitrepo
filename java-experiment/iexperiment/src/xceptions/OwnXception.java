package xceptions;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 24, 2013
 * @Description OwnException(): This is a demonstration of creating own exception
 */
public class OwnXception extends Exception {
	private static final long serialVersionUID = 1L;
	private int detail;
	private Print view;
	
	public OwnXception(int a) {
		detail = a;
		view = new Print();
	}
	
	public String toString() {
		return "OwnException["+detail+"]";
	}
	
	void compute(int a) throws OwnXception {
		view.println("Called compute("+a+")");
		if(a > 10) {
			throw new OwnXception(a);
		}
		
		view.println("Normal exit");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OwnXception xcep = new OwnXception(0); //this can be replaced with an ananymous inner class
		try {
			xcep.compute(1);
			xcep.compute(10);
			xcep.compute(15);
		} catch (OwnXception e) {e.printStackTrace();}
	}

}
