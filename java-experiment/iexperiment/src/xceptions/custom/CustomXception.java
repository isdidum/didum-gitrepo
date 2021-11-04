
package xceptions.custom;

//import callable.staticprint.Printable;

/**
 * @author A., Didum
 * @date March 24, 2013
 * @description CustomXception(): This is a demonstration of creating own custom exception
 */
public class CustomXception extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @description CustomXception(): specific constructor
	 * @param sString
	 */
	public CustomXception(String s) {
		super(s);
	}
	
	/**
	 * @description CustomXception(): specific constructor
	 */
	public CustomXception(String s, Throwable t){
		super(s, t);
	}
	
	/**
	 * @description CustomXception(): default constructor
	 */
	public CustomXception() {
		super();
	}
	
	public static void xCeption(String string) throws CustomXception {
		//Output.println("CustomException["+sXception+"]\n");
		//throw new CustomXception(); //folder path
		throw new CustomXception("Exception["+string+"]");
	}
	
	/**
	 * @description main(): application entry point
	 * @param args 
	 */
	public static void main(String args[]){ //throws CustomXception{
		try{
			CustomXception.xCeption("xcep.ver.01");
		}catch(CustomXception err){err.printStackTrace();}
	}
}
