/**
 * @author Didum
 * date: October 21, 2012
 */

package myconcrete;

import java.util.Date;

public class EmpConcrete {
	//instance variables
	private String name;
	private String bday;
	private double salary;
	private Date date;
	
	/*
	 * EmpConcrete(): default constructor
	 */
	public EmpConcrete() {
		name = "Sean";
		salary = 20200.51;
		bday = "12/20/1965";
		date = new Date();
	}
	
	//getDetails(): accessor method - returns a string representation of instance vars
	public String getDetails(){
		String str = "Name: "+name+"\nSalary: $"+salary+"\nBirthday: "+bday+"\nDate: "+date;
		return str;
	}

}
