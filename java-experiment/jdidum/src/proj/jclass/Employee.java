/**
 * Author: A., Didum
 * Date: September 22, 2012
 * Purpose: Compute the weekly pay of hourly employees
 */
package proj.jclass;

/**
 * @author didum4
 * Class Employee
 */
public class Employee {

	//private instance variables
	private String name;
	private int type;
	private double rate;
	private int hours;
	
	/**
	 * Employee(): constructor method
	 */
	public Employee() {
		name = "";
		type = 0;
		rate = 0;
		hours = 0;
	}
	
	//getNameRules(): accessor method - returns blank
	public String getNameRules() {
		return "nonblank";
	}
	
	//getTypeRules(): accessor method - return 1/2
	public String getTypeRule(){
		return "1 or 2";
	}
	
	//getRateRules(): accessor method - return a string
	public String getRateRules(){
		return "between 6.75 and 30.50, inclusive";
	}
	
	//getHourRules(): accessor method - return a string
	public String getHourRules(){
		return "between 1 and 60, inclusive";
	}
	
	//setName(): accessor method - returns false/true value
	public boolean setName(String nm){
		if(nm.equals(""))
			return false;
		else { 
			name = nm;
			return true;
		}
	}
	
	//setType(): accessor method - returns false/true value
	public boolean setType(int tp){
		if(tp != 1 && tp != 2)
			return false;
		else {
			type = tp;
			return true;
		}
	}
	
	//setRate(): accessor method - returns false/true value
	public boolean setRate(double rt){
		if(!(6.75 <= rt && rt <= 30.5))
			return false;
		else {
			rate = rt;
			return true;
		}
	}
	
	//setHours(): accessor method - returns false/true value
	public boolean setHours(int hrs){
		if(!(1 <= hrs && hrs <= 60))
			return false;
		else {
			hours = hrs;
			return true;
		}
	}
	
	//getName(): accessor method - returns name
	public String getName(){
		return name;
	}
	
	//getPay(): accessor method - returns pays
	public double getPay(){
		double pay;
		if(hours <= 40 || type == 2)
			pay = rate * hours;
		else
			pay = rate*40 + rate*2*(hours - 40);
		return pay;
	}
}
