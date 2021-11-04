/**
 * Author: A., Didum
 * Date: September 22, 2012
 * Purpose: Compute the weekly pay of hourly employees
 */
package proj.jclient;
import proj.jclass.Employee;

import java.io.*;
import java.util.*;


public class EmployeeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		Employee emp;			// employee
		String name;			// name
		int type;				// type
		int hours;				// hours worked
		double rate;			// hourly pay rate
		String prompt;			// user prompt
		
		while(true) {
			//get the name and break if blank
			System.out.println("Enter employee name (or leave blank to quit): ");
			name = input.nextLine();
			
			name = name.trim(); 	//trims off leading and trailing spaces
			if(name.length() == 0) break;
			emp = new Employee();
			emp.setName(name);
			
			//get the type until valid
			while(true) {
				prompt = "	Type ("+emp.getTypeRule()+"): ";
				System.out.println(prompt);
				String strType = input.nextLine();
				type = Integer.parseInt(strType);
				if(emp.setType(type)) break;
			}
			
			//get the hourly pay rate until valid
			while(true) {
				prompt = "	Hourly rate ("+emp.getRateRules()+"): ";
				System.out.println(prompt);
				String strRate = input.nextLine();
				rate = Double.parseDouble(strRate);
				if(emp.setRate(rate)) break;
			}
			
			//get the hours worked until valid
			while(true){
				prompt = "	Hours worked ("+emp.getHourRules()+"): ";
				System.out.println(prompt);
				String strHours = input.nextLine();
				hours = Integer.parseInt(strHours);
				if(emp.setHours(hours)) break;	
			}
		
			//print the name and pay
			System.out.println("	The weekly pay for "+emp.getName()+" is $"+emp.getPay());
		}
	
	}
}
