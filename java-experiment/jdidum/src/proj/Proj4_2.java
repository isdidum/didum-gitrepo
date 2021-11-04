//Author: A., Didum
//Date: September 16, 2012
//Purpose: Collects length of three sides of a triangle to determine a right triangle

package proj;
import java.util.*;

public class Proj4_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double side1, side2, side3;
		String rt;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter side-a (0 to halt) [m]: ");
		side1 = input.nextDouble();
		while(side1 != 0){
			System.out.print("Enter side-b [m]: ");
			side2 = input.nextDouble();
			
			System.out.print("Enter side-c (hypotenus) [m]: ");
			side3 = input.nextDouble();
			
			rt = rightTriangle(side1, side2, side3);
			System.out.println(rt);
			
			System.out.print("\nEnter side-a (0 to halt) [m]: ");
			side1 = input.nextDouble();
		}		
		input.close();
	}
	
	//rightTriangle(): determine right triangle
	public static String rightTriangle(double s1, double s2, double s3){
		double hypotenus;
		hypotenus = Math.sqrt(Math.pow(s1, 2) + Math.pow(s2, 2));
		if(hypotenus == s3)
			return s1+", "+s2+", & "+s3+" makes a right triangle.\n Area = " 
				+ (1.0/2.0*s1*s2) + " m^2";
		else
			return s1+", "+s2+", & "+s3+" don\'t make a right triangle. \n Area = "
				+ (1.0/2.0*s1*s2) + " m^2";
	}

}
