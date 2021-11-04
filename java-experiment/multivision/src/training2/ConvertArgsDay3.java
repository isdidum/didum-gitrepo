package training2;

public class ConvertArgsDay3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//invokes scanner class for reading user-inputs
		
		String int1 = args[0], int2= args[1];
		int keepA, keepB;
		keepA = Integer.parseInt(int1);
		keepB = Integer.parseInt(int2);
		//getAB(): invocation
		getAb(keepA, keepB);
	}
	
	//getAB(): mutator method - takes two integer values as formal-parameters
	public static void getAb(int getA, int getB){
		String add, minus, times, divide;
		int gMinus;
		double gdiv;
		
		//checks to ensure A is not equal to B
		if(getA != getB){
			gMinus = getA - getB;
			add = "\nAddition = "+ (getA+getB);
			minus = "Subtraction = "+ (gMinus);
			times = "Multiplication = "+ (getA*getB);
			gdiv = (double)getB / getA;
			divide = "Division = " + (gdiv);
			
			System.out.println(add);
			System.out.println(minus);
			System.out.println(times);
			System.out.println(divide);
		} else {
			System.out.println("---------------------------");
			System.out.println("Can\'t have exact integers.");
			System.out.println("---------------------------");
		}
	}
}
