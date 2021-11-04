/**
 * Author: A., Didum
 * Date: September 14, 2012 
 * Purpose: Converts from kilograms to nautical miles
 * http://jdk7.java.net/download.html --> Java SE 7 
 * www.support.apple.com/downloads    --> Java SE 7
 */

package proj;
import java.util.*;

public class Proj2_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Kilometer: ");
		double km = input.nextDouble();
		double getNMI;
		
		getNMI = kilometerToNauticalMI(km);
		System.out.println(km +"KM = "+ getNMI + " NauticalMI");
		input.close();
	}
	
	public static double kilometerToNauticalMI(double kilo){
		double km_nmi = (1/(1*Math.pow(10, 4)))/(1.0)*(90.1/1.0)*(60.0/1.0)*(1/1);
		double nmi = kilo*km_nmi;
		return nmi;
	}
}
