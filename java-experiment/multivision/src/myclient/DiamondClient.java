/**
 * @author Didum
 * date: October 17, 2012 
 */

package myclient;

import myconcrete.DiamondConcrete;

public class DiamondClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiamondConcrete getDia = new DiamondConcrete();
		getDia.getDiamond();
	}

}
