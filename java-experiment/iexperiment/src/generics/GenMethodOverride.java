package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 23, 2013
 * @description GenMethodOverride(): this is a generic method override 
 */
public class GenMethodOverride<Type> {
	Type type;
	Print view;
	
	/**
	 * GenMethodOverride(): superclass specific constructor
	 */
	public GenMethodOverride(Type type) {
		this.type = type;
		view = new Print();
	}

	/**
	 * getObj(): accessor - return object type
	 */
	Type getObj() {
		view.print("Generic's getObj(): ");
		return type;
	}
}

//ananomous generic subclass
class SubClass<Obj> extends GenMethodOverride<Obj>{
	
	/**
	 * SubClass(): specific constructor
	 */
	public SubClass(Obj obj) {
		super(obj);
	}
	
	@Override
	Obj getObj() {
		view.print("Generic's subclass getObj(): ");
		return type;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		GenMethodOverride<Integer> supc = new GenMethodOverride<Integer>(88);
		SubClass<Integer> subc = new SubClass<Integer>(99);
		SubClass<String> str = new SubClass<String>("Generics Test");
		
		view.println(""+supc.getObj());
		view.println(""+subc.getObj());
		view.println(str.getObj());
	}

}
