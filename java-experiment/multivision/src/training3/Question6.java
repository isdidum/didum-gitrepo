/**
 * @author Didum
 * date: October 17, 2012
 */

package training3;

public class Question6 {
	
	public static final int IARR_SIZE = 100;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int iArr[] = new int[IARR_SIZE];
		
		for(int i=0; i<IARR_SIZE; i++) 
			iArr[i] = i;
		
		/*for(int j=0; j<iArr.length; j++){
			if(j % 2 == 0)
				System.out.println("Even numbers: "+ iArr[j]);
		}*/
		
		//Enhanced for-loop
		for(int j: iArr){
			if(j % 2 == 0)
				System.out.println("Even numbers: "+ iArr[j]);
		}
	}
}
