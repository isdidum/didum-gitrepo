package objects;

import callable.io.Print;

/**
 * ObjAsParam(): Using objects as parameters
 * @author A., Didum
 * @date March 24, 2013
 */
public class ObjAsParam {
	private int a, b;
	private String c;
	
	public ObjAsParam(int a, int b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * equals(): facilitator - return true/false if obj equals invoking object
	 * @notes Objects are passed by reference whereas Primitives are passed by value
	 * <p>-Use equals to compare objects or referenced types<br/>
	 * -Use == to compare primitive types</p>
	 */
	boolean equals(ObjAsParam obj) {
		try {
			if(obj.a == a && obj.b == b && obj.c.equals(c)) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		ObjAsParam obj1 = new ObjAsParam(100,22,"cat");
		ObjAsParam obj2 = new ObjAsParam(100,22,"cat");
		ObjAsParam obj3 = new ObjAsParam(-1,-1,"cat");
		
		view.println("obj1 ?= obj2: "+ obj1.equals(obj2));
		view.println("obj2 ?= obj3: "+ obj2.equals(obj3));
		view.println("obj3 ?= obj1: "+ obj3.equals(obj1));
	}

}
