package generics.nongeneric;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 23, 2013
 * @description NonGeneric(): a non-generic class as the superlass of a generic subclass
 */
public class NonGeneric {
	int num;
	
	/**
	 * NonGeneric(): superclass specific constructor
	 */
	public NonGeneric(int i) {
		num = i;
	}
	
	/**
	 * getNum(): accessor - returns number of superclass
	 * @return number
	 */
	int getNum() {
		return num;
	}
}
//Anonymous generic innner subclass
class SubGeneric<Type> extends NonGeneric {
	Type obj1;
	/**
	 * SubGeneric(): subclass specific constructor
	 * @param obj
	 * @param i
	 */
	public SubGeneric(Type obj, int i) {
		super(i);
		obj1 =  obj;
	}
	
	/**
	 * getObj(): accessor - returns object of subclass
	 */
	Type getObj() {
		return obj1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		SubGeneric<String> sg = new SubGeneric<String>("Hello ", 47);
		view.print(sg.getObj());
		view.println(""+sg.getNum());
	}

}
