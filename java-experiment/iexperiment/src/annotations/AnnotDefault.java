package annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 23, 2013
 * @description Annots(): this annotation interface is marked to be retained at run-time
 * @notes annotations are ways to add supplemental information into a source file, which does not change the actions of a program
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotDefault {
	String str() default "Test string";
	int val() default 1300;
}

// ananomous inner class
class AnnotsDefault {
	@AnnotDefault()	//using default values
		
	/**
	 * @description initMethod(): processes annotation
	 */
	public static void initMethod() {
		Print view = new Print();
		AnnotsDefault ao = new AnnotsDefault();
		try {
			// get a class that represents this object
			Class<?> c = ao.getClass();
			
			// get a method that represents this method
			Method m = c.getMethod("initMethod");
			
			// get annotation for this class
			AnnotDefault anno = m.getAnnotation(AnnotDefault.class);
			
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

