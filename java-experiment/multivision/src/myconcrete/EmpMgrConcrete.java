/**
 * @author Didum
 * date: October 21, 2012
 */

package myconcrete;

import myconcrete.EmpConcrete;

public class EmpMgrConcrete extends EmpConcrete{
	
	//instance variable
	private String dept;
	
	/**
	 * Manager(): default constructor for subclass
	 * EmpConcrete(): superclass
	 */
	public EmpMgrConcrete(String dpt) {
		dept = dpt;
	}

	//getDetails(): accessor method - calls parent method to modify content
	public String getDetails(){
		//Invoking Overridden Methods - a subclass method may invoke a superclass method using super keyword
		String str = super.getDetails() + "\nDepartment: "+ dept;
		return str;
	}
}
