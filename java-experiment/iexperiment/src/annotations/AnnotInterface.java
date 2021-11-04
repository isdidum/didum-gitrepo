package annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 23, 2013
 * @description Annots(): this annotation interface is marked to be retained at run-time
 * @notes annotations are ways to add supplemental information into a source file, which does not change the actions of a program
 * <p>-Cannot include an extends clause<br/>
 * -created through interface<br/>
 * -consists solely of methods declarations<br/>
 * -don't provide bodies for methods</p>
 */
@Retention(RetentionPolicy.RUNTIME)
//public @interface AnnotInterface {
public @interface AnnotInterface {
	String str();
	int val();
}

// ananomous inner class
class AnnotsClass {
	@AnnotInterface(str="Didum Annotation", val=400)	//using default values
		
	/**
	 * @description initMethod(): processes annotation
	 */
	public static void initMethod() {
		Print view = new Print();
		AnnotsClass ao = new AnnotsClass();
		try {
			// get a class that represents this object
			Class<?> c = ao.getClass();
			
			// get a method that represents this method
			Method m = c.getMethod("initMethod");
			
			// get annotation for this class
			AnnotInterface anno = m.getAnnotation(AnnotInterface.class);
			
			// display the values
			view.println(anno.str() +" "+ anno.val());
		}catch(NoSuchMethodException e) {e.printStackTrace();}
	}
	
	/**
	 * @description main(): application entry point
	 * @param args
	 */
	public static void main(String args[]) {
		initMethod();
	}
}

