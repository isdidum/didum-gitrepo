//creation: 12/27/2014
package proj; 

import callable.io.KeyboardReader;
import callable.io.Output;

/**
 * @author Dee
 * @description Binary2Decimal() converts digital binary numbers into decimals 
 */
public class Binary2Decimal extends Output{
	/**
	 * @param args
	 * binary digits consist of 0s and 1s only
	 */
	public static void main(String[] args) {
		//invokes class KeyboardReader object to read input from user
		KeyboardReader reader = new KeyboardReader();
		
		println("Examples of binary digits are: 1101, 11010, 01001, and 10011101");
		println("Corresponding decimal representations are: 13, 26, 9, and 157");
		String input = reader.readLine("Enter the binary digit: ");
		if (input.equals("0"))
			println("Binary digit = "+input, "Decimal value = "+toDecimal(input)+"_10");
		else if(toDecimal(input) != -1)
			println("Binary digit = "+input+"_2", "Decimal value = "+toDecimal(input)+"_10");
		else println("AI-msg: invalid input entry");
		
		while(!input.equals("0")){ //Ctrl + z to quit infinite loop in a console window
			input = reader.readLine("\nEnter the binary digit (0 to halt): ");
			if (input.equals("0"))
				println("Binary digit = "+input, "Decimal value = "+toDecimal(input)+"_10");
			else if(toDecimal(input) != -1)
				println("Binary digit = "+input+"_2", "Decimal value = "+toDecimal(input)+"_10");
			else println("AI-msg: invalid input entry");
		}
	}
	
	/**
	 * this method converts binary string literal to character array then to integer array
	 * @param binary of type String
	 * @return integer array
	 */
	static int[] toIntArray(String binary){
		char chrArray[] = binary.toCharArray();		//converts to characters
		int intArray[] = new int[chrArray.length];	//assigns integer array to lenght of char array
		int cntr = 0;
		for(char chr : chrArray){ //assigns and converts each char to integer array
			intArray[cntr] = Integer.parseInt(String.valueOf(chr)); //chr=unicode
			cntr++;
		}
		return intArray;
	}
	
	/**
	 * this method converts binary digits to its corresponding decimal values
	 * @param binary of type String
	 * @return decimal integer value
	 */
	static int toDecimal(String binary){		
		int length = toIntArray(binary).length-1;
		int decimal = 0, i = 0;
		
		//check for possible invalid entry
		if(binary.isEmpty() || binary.length() == 0) return -1;
		for(int val : toIntArray(binary)){
			if(val > 1) return -1;
		}
		
		//k is the variable decrementing the super script and i is the variable incrementing toIntArray() array
		for(int k=length; k>=0; k--){ //i-=1 or i=i-1
			decimal += toIntArray(binary)[i] * (int) Math.pow(2, k); //binary digits are base 2 driven
			println("For k="+k+", Char="+toIntArray(binary)[i]+", Decimal: "+decimal);
			i++;
		}
		return decimal;
	}
}
