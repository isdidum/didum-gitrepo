package pclient;

import callable.io.Print;
//import collections.lists.Stack;
import callable.GStack;


public class StackClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print p = new Print();
		/*String[] str = new String[5]; //this works
		Stack stack = new Stack(str);
		stack.push("apple");
		stack.push("orange");
		stack.push("mango");
		stack.push("pineapple");
		stack.push("grapes");
		stack.push("banana");
		p.println("pop1: "+stack.pop());
		p.println("pop2: "+stack.pop());
		p.println("pop3: "+stack.pop());
		p.println("peek-1: "+stack.peek()+" size: "+stack.size());
		p.println("pop4: "+stack.pop());
		p.println("peek-2: "+stack.peek()+" size: "+stack.size()+" length: "+str.length);
		p.println("pop5: "+stack.pop());
		*/
		
		String[] s = new String[4];
		GStack gro = new GStack(s, 4);
		p.println("peek-1: "+gro.peek());
		gro.push("XML");
		gro.push("JavaScript");
		gro.push("Java");
		gro.push("Restful APIs");
		gro.push("JSON");
		gro.push("AJAX");
		gro.push("JNDI");
		p.println("peek-2: "+gro.peek());
		p.println("pop-1: "+gro.pop());
		p.println("size(): "+gro.size()+" length:"+gro.getStack().length);
		for(int i=0; i<gro.getStack().length; i++)
			p.println(""+i+", "+gro.getStack()[i]);
	}
}
