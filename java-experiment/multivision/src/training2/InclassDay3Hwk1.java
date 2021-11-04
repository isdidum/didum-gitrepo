/**
 * @author Didum
 * date: October 17, 2012
 */
package training2;

public class InclassDay3Hwk1 {

	/**
	 * @param args
	 * directive: write a program that takes two parameters in a method, using switch statement
	 * to display +, -, *, /
	 * question: are the operators to be provided by end-user?
	 */
	public static void main(String[] args) {
		// Command Line input: "1" "2" "*"
		String inum1 = args[0];
		String inum2 = args[1];
		char iopr = args[2].charAt(0);
		
		//getSwitch(): invocation
		getSwitch(inum1, inum2, iopr);
	}
	
	//getSwitch(): mutator method
	public static void getSwitch(String num1, String num2, char opr){
		/*
		 * Notes: for command line input: use "x" instead of "*"
		 */
		int xi = Integer.parseInt(num1);
		int xj = Integer.parseInt(num2);
		
		switch(opr){
		case '+':
			System.out.println("Add: "+ (xi+xj));
			break;
		case '-':
			System.out.println("Minus: "+ (xi-xj));
			break;
		case '/':
			System.out.println("Divide: "+ (double)xi/xj);
			break;
		case 'x':
			System.out.println("Times: "+ (xi*xj));
			break;
			default:
				System.out.println("Invalid ouput");
		}
	}
}
