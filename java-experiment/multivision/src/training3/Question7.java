/**
 * @author Didum
 * date: October 17, 2012
 */

package training3;

public class Question7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Right Skewed Right Triangle
		for(int x=1; x<5; x++){
			for(int y=0; y<x; y++){
				System.out.print(y);
			}
			System.out.println();
		}
		
		//Left Skewed Right Triangle
		/*for(int x = 0; x < 5; x++){
            for(int y = 5; y > 0; y--){
                if(x < y)System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }*/

	}
	
}
