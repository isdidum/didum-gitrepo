package generics;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 22, 2013
 * @description GenExtends(): this generic extends class Number &serves as template for floating-point & integer average calcuations
 */
public class GenExtends<Type extends Number> {
	//instance object of Type, namely, arrays of numbers or a class derived
	Type obj[];
	
	/**
	 * GenExtends(): specific constructor
	 */
	GenExtends(Type[] obj) {
		this.obj = obj;
	}
	
	/**
	 * getObject(): returns object's Type
	 * @return object
	 */
	public double getAverage() {
		try {
			double sum = 0.0;
			for(int i=0; i<obj.length; i++) {
				sum += obj[i].doubleValue();
			}
			return sum / obj.length;
		} catch(Exception err) {err.printStackTrace();}
		return 0.0;
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Integer inum[] = {2,1,3,5,4};
		Double dnum[] = {2.0,1.0,3.0,5.0,4.0};
		//String str[] = {"2","1","3","5","4"}; this won't compile b/c String is not a subclass of Number
		GenExtends<Integer> iObj = new GenExtends<Integer>(inum);
		GenExtends<Double> dObj = new GenExtends<Double>(dnum);
		
		//get the value in iObj, no cast is needed
		int ints = (int)iObj.getAverage();
		view.println("Integer average: "+ints);
		
		//get the value in dObj, no cast is needed
		double dbl = dObj.getAverage();
		view.println("Double average: "+dbl);
	}
}
