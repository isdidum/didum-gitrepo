package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 22, 2013
 * @description GenInterface(): this is a generic interface 
 */
public interface GenInterface<Type extends Comparable<Type>> {
	//abstract methods
	Type min();	
	Type max();
}

//ananomous inner class - no access modifier allowed
class ClassInterface<Type extends Comparable<Type>> implements GenInterface<Type>{
	Type vals[];
	
	/**
	 * ClassInterface(): specific constructor
	 * @param type
	 */
	ClassInterface(Type[] type){
		vals = type;
	}
	
	@Override
	public Type min() {
		try {
			Type v = vals[0];
			for(int i=0; i<vals.length; i++) {
				if(vals[i].compareTo(v) < 0)v = vals[i];
			}
			return v;
		}catch(Exception err) {err.printStackTrace();}
		return null;
	}
	
	@Override
	public Type max() {
		try {
			Type v = vals[0];
			for(int i=0; i<vals.length; i++) {
				if(vals[i].compareTo(v) > 0) v = vals[i];
			}
			return v;
		}catch(Exception err) {err.printStackTrace();}
		return null;
	}
}

//ananomous inner class
class GenInterfaceClient {
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Integer inum[] = {2, 6, 3, 8, 6};
		Character chs[] = {'b', 'r', 'p', 'w'};
		
		ClassInterface<Integer> iObj = new ClassInterface<Integer>(inum);
		ClassInterface<Character> cObj = new ClassInterface<Character>(chs);
		
		//get the value in iObj, no cast is needed
		view.println("Max integer value: "+iObj.max());
		view.println("Min integer value: "+iObj.min());
		
		view.println("Max character value: "+cObj.max());
		view.println("Min character value: "+cObj.min());
	}
}