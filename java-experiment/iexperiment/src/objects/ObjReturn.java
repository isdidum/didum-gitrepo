package objects;

import callable.io.Print;

/**
 * ObjReturn: Returning objects
 * @author A., Didum
 * @date March 24, 2013
 * @notes Object is the default of all classes be it extended or not
 */
public class ObjReturn extends Object {
	int a;
	
	public ObjReturn(int i) {
		a = i;
	}
	
	/**
	 * incrementByFour(): accessor - return object incremented by 4
	 * @return object
	 */
	ObjReturn incrementByFour() {
		ObjReturn obj = new ObjReturn(a+4);
		return obj;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		ObjReturn obj1 = new ObjReturn(2);
		ObjReturn obj2 = null;
		
		obj2 = obj1.incrementByFour();
		view.println("obj1.a: "+obj1.a);
		view.println("obj2.a: "+obj2.a);
		
		obj2 = obj2.incrementByFour();
		view.println("obj2.a after second increase: "+obj2.a);
	}

}
