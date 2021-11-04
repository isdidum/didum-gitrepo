/**
 * Training day-3
 * October 17, 2012
 */

package training2;

public class InclassDay3Gof3Nums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Method-One : Command Line Inputs: "4" "6" "1"
		String a = args[0];
		String b = args[1];
		String c = args[2];
		//byte a = 4;
		//byte b = 6;
		//byte c = 1;
		byte ia = Byte.parseByte(a);
		byte ib = Byte.parseByte(b);
		byte ic = Byte.parseByte(c);
		//check if a>b
		if(ia > ib){
			//check if a>c
			if(ia > ic){
				System.out.println("a is the greatest");
			} else if(ic > ib){
				System.out.println("c is the greatest");
			}
		} else if(ib > ic){
			System.out.println("b is the greatest");
		} else {
			System.out.println("c is the greatest");
		}

	}

}
