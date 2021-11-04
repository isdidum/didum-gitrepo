package xceptions;

import callable.io.*;

/**
 * @author A., Didum
 * @date March 24, 2013
 * @description OwnException(): This is a demonstration of creating own exception
 */
public class ObjXception extends Exception {
	private static final long serialVersionUID = 1L;
	private int sum, count;
	
	/**
	 * @description ObjXception(): default constructor
	 */
	public ObjXception() {
		super();
		sum = 0;
		count = 0;
	}
	
	/**
	 * @description ObjXception(): specific constructor
	 * @param s
	 */
	public ObjXception(String s){
		super(s);
		sum = 0;
		count = 0;
	}
		
	/**
	 * @description ObjXception(): specific constructor
	 * @param iValue
	 */
	public ObjXception(int...iValue){
		for(int i=0; i<iValue.length; i++){
			sum += iValue[i];
			count += 1;
		}
	}

	/**
	 * @description xception(): mutator
	 * @throws ObjXception 
	 */
	void xception() throws ObjXception {
		Output.println("Invoked xception()");
		if(Math.ceil(sum/count) <= count) {
			Output.println("{sum="+sum+", count="+count+"}");
			throw new ObjXception("[New ObjXception()]");
		} else {
			Output.println("{sum:"+sum+", count:"+count+", mean:"+Math.ceil(sum/count)+"}");
		}
		Output.println("Normal exit");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjXception xcep = new ObjXception(8,5,7,2,5);
		try {
			xcep.xception();
		} catch (ObjXception err) {err.printStackTrace();}
	}
}

