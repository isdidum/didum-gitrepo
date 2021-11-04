package proj;

import callable.io.KeyboardReader;

public class Decimal2Binary{

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		KeyboardReader key = new KeyboardReader();
		
		key.println("Examples of a whole decimal digits are: 13, 26, 9, and 157");
		int input = key.readInt("Enter the decimal digit: ");
		if(input != -1)
			key.println("Decimal digit = "+input+"_10", "Binary digit = "+toBinary(input)+"_2");
		
		while(input != -1){ //Ctrl + z to quit infinite loop in a console window
			input = key.readInt("\nEnter decimal digit (-1 to halt): ");
			if(input != -1){
				key.println("Decimal digit = "+input+"_10", "Binary digit = "+toBinary(input)+"_2");
			}
		}
	}
	
	/**
	 * toBinary(): returns a binary representation of a whole decimal number 
	 * @param quotient
	 * @return binary
	 */
	static String toBinary(int quotient) {
		String binary = "";
		if (quotient == 0) return "0";
        
        while (quotient > 0) {
        	//String string = String.valueOf(quotient).split("\\.")[0];	//extract integer value of quotient
			//int intv = Integer.valueOf(string); //converts string to integer
            int remainder = quotient % 2;
            binary = remainder + binary;
            quotient = quotient / 2;
        }
        return binary;
    }
}
