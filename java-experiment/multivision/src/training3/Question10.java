/**
 * @author Didum
 * date: October 17, 2012
 */

package training3;

import java.util.GregorianCalendar;
import java.util.Calendar;


public class Question10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//useSwitch(): invocation
		useSwitch(17);
	}
	
	//findSqrt(): accessor method - returns square root
	public static double findSqrt(double gInput){
		return Math.sqrt(gInput);
	}
	
	//curDate(): mutator method - get current date
	public static void curDate(){
		Calendar myCal = new GregorianCalendar();
		int mm, dd, yr;
		mm = myCal.get(Calendar.MONTH);
		yr = myCal.get(Calendar.YEAR);
		dd = myCal.get(Calendar.DAY_OF_MONTH);
		System.out.println("Current date: " + dd + "/" + (mm + 1) + "/" + yr);
	}
	
	//useSplit(): mutator method - use split method
	public static void useSplit(){
		String str, splitList[], c1, c2, c3, c4, c5;
		str = "I:am:learning:core:java";
		splitList = str.split(":");
		c1 = splitList[0];
		c2 = splitList[1];
		c3 = splitList[2];
		c4 = splitList[3];
		c5 = splitList[4];
		
		System.out.println(c1+"\n"+c2+"\n"+c3+"\n"+c4+"\n"+c5);
	}
	
	//useSwitch(): mutator method - prints out current date
	public static void useSwitch(int a1){
		char myChar = 'y';
		switch(myChar){
		case 'x':
			String iStr = Double.toString(findSqrt(a1)); //converts double to String
			System.out.println("Sqrt("+a1+") = "+ iStr);
			break;
		case 'y':
			curDate();
			break;
		case 'z':
			useSplit();
			break;
			default: 
			System.out.println("Invalid");
		}
	}
}
