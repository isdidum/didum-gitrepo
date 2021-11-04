/**
 * @author Didum
 * date: October 21, 2012
 */

package myclient;

import myconcrete.EmpMgrConcrete;

public class EmpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmpMgrConcrete emp = new EmpMgrConcrete("Engineering");
		System.out.println(emp.getDetails());
	}

}
