package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 22, 2013
 * @description GenMethod(): this is a generic method with one or more parameters 
 */
public class GenMethod {
	/**
	 * GenMethod(): specific constructor
	 */
	GenMethod() {
		//default constructor
	}
	
	/**
	 * isInMethod(): determines if an object is in an array
	 * @return
	 */
	static <Type, V extends Type> boolean isInMethod(Type x, V[] y) {
		for(int i=0; i<y.length; i++) {
			if(x.equals(y[i])) return true;
		}
		return false;
	}
		
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Integer inum[] = {2,1,3,5,4};
		int num[] = {3,2,7,1,0};
		//GenExtends<Integer> iObj = new GenExtends<Integer>(inum);
		
		//checks if 3 in a value in object passed as a parameter
		for(int i=0; i<num.length; i++) {
			if(isInMethod(num[i], inum)) view.println("Integer found, value : "+num[i]);
			else view.println("Integer not found, value : "+num[i]);
		}
		
		String istr[] = {"one", "two", "three", "four", "five"};
		String sval[] = {"six","one","eight","four","nine"};
		view.println("");
		//checks if 3 in a value in object passed as a parameter
		for(int i=0; i<sval.length; i++) {
			if(isInMethod(sval[i], istr)) view.println("Integer found, value : "+sval[i]);
			else view.println("Integer not found, value : "+sval[i]);
		}
	}
}
