package training2;

public class Day3ArgsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Monday 4 is the user-input value: Program argument (textbox)
		String firstArg = args[0];
		System.out.println("First args = "+firstArg); //run as configuration, (x)=Arguments tab, type Monday 4
		int num = Integer.parseInt((args[1]));
		
		System.out.println("integer = "+(num+5)); // type Monday 4, test with args[1]
		double num1 = Double.parseDouble(args[1]);
		System.out.println("double = "+num1);
	}

}
