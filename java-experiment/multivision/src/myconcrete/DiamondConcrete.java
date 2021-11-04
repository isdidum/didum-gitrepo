/**
 * @author Didum
 * date: October 17, 2012 
 */
package myconcrete;


public class DiamondConcrete {

	/*
	 * DevDiamond(): default constructor
	 */
	public DiamondConcrete() {
		
	}
	
	//getDiamond(): mutator - method
	public void getDiamond(){
		String singlesp = " ";
		String newline = "\n";
		
		//algorithm for top pyramid
		for(int x=1; x<10; x+=2) {
			for(int y=0; y<9-x/2; y++){
				System.out.print(singlesp);
			}
			
			for(int y=0; y<x; y++){
				System.out.print(y);
			}
			
			System.out.print(newline);
		}
		
		//algorithm for bottom pyramid
		for(int i=7; i>0; i-=2) {
			for(int y=0; y<9-i/2; y++){
				System.out.print(singlesp);
			}
			
			for(int y=0; y<i; y++){
				System.out.print(y);
			}
		      
			System.out.print(newline);
		}
	}
}
