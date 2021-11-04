package pconcrete;

import pinterface.IfaceExtendsB;
import callable.io.Print;

public class IfaceExtends implements IfaceExtendsB {
	private Print view;
	
	public IfaceExtends() {
		view = new Print();
	}
	
	@Override
	public void method1() {
		view.println("Implement method-1.");
	}

	@Override
	public void method2() {
		view.println("Implement method-2.");		
	}

	@Override
	public void method3() {
		view.println("Implement method-3.");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IfaceExtends ex = new IfaceExtends();
		ex.method1();
		ex.method2();
		ex.method3();
	}
}
