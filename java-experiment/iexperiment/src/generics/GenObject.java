package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 22, 2013
 * @description GenObject(): generics are simply parameterized types that are typed safe
 * @notes generics work with different data types: a class, an interface, or a method can be operated upon
 * <p>-they eliminate the need to manually caste and to type-check code by hand<br/>
 * -likewise, you can exends Type via GenObject<code>'<'Type extends Number'>'</code> or<br/>
 * -also, you can add many params via GenObject<code>'<'Type1, Type2, ...TypeN'>'</code><br/>
 * -finally, you can add interface & classes via GenObject<code>'<'Type extends MyClass & MyInterface'>'</p> 
 */
public class GenObject<Type> {
	//instance object of Type
	Type obj;
	Print view;
	
	/**
	 * GenObject(): specific constructor
	 */
	public GenObject(Type obj) {
		this.obj = obj;
		view = new Print();
	}
	
	/**
	 * getObject(): returns object's Type
	 * @return object
	 */
	public Type getObject() {
		return obj;
	}
	
	/**
	 * @Descripton showType(): show the object's Type
	 */
	void showType() {
		view.println("Type of \'Type\' is "+obj.getClass().getName());
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		GenObject<Integer> iObj = new GenObject<Integer>(2*4); //2*4 or new Integer(2*4)
		
		//show the type of data used by gObj
		iObj.showType();
		
		//get the value in gObj, no cast is needed
		int val1 = iObj.getObject();
		view.println(""+val1);
		
		GenObject<String> sObj = new GenObject<String>("Hi, I\'m Didum.");
		//show the type of data used by gObj
		sObj.showType();
			
		//get the value in gObj, no cast is needed
		String val2 = sObj.getObject();
		view.println(""+val2);
	}
}
