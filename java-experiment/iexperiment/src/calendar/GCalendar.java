
package calendar;

import java.util.*;

import callable.io.Print;

/**
 * @author Didum
 * @date Feb 11, 2013
 * @description GCalendar() - concrete class
 */
public class GCalendar {
	//instance variables
	private String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private String wkdays[] = {"Sun", "Sat", "Mon", "Tue", "Wed", "Thu", "Fri"};
	private String suffix;
	private int year;
	private GregorianCalendar gcalendar;
	private Print view;
	
	/**
	 * @description GCalendar() - default constructor
	 */
	public GCalendar() {
		year = 0;
		suffix = "AM";
		view = new Print();
		gcalendar = new GregorianCalendar();
	}
	
	/**
	 * @description getDay(): accessor - helper method that gets current day of week
	 * @return day
	 */
	private String getDay() {
		try {
			return wkdays[gcalendar.get(Calendar.DAY_OF_WEEK)];
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description getMonth(): accessor - helper method that gets current month
	 * @return month
	 */
	private String getMonth() {
		try {
			return months[gcalendar.get(Calendar.MONTH)];
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description getDate(): accessor - helper method that gets current date
	 * @return date
	 */
	private int getDate() {
		try {
			return gcalendar.get(Calendar.DATE);
		} catch(Exception err) {
			err.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @description getYear(): accessor - helper method that gets current year
	 * @return year
	 */
	private int getYear() {
		try {
			year = gcalendar.get(Calendar.YEAR);
			return year;
		} catch(Exception err) {
			err.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @description getHour(): accessor - helper method that gets current hour
	 * @return hour
	 */
	private int getHour() {
		int hrs = 0;
		try {
			hrs = gcalendar.get(Calendar.HOUR_OF_DAY);
			if(hrs == 0) {
				return hrs = 12;
			} else if(hrs == 12) {
				suffix = "PM";
				return hrs;
			} else if(hrs > 12) {
				suffix = "PM";
				hrs -= 12;
				return hrs;
			} else {
				return hrs;
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
		return 0;
	}
	
	/*private String apm() {
		//return String.valueOf(gcalendar.get(Calendar.AM_PM));
	}*/
	
	/**
	 * @description getMinute(): accessor - helper method that gets current minutes
	 * @return minutes
	 */
	private int getMinute() {
		try {
			return gcalendar.get(Calendar.MINUTE);
		} catch(Exception err) {
			err.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @description getSecond(): accessor - helper method that gets current seconds
	 * @return seconds
	 */
	private int getSecond() {
		try {
			return gcalendar.get(Calendar.SECOND);
		} catch(Exception err) {
			err.printStackTrace();
		}
		return 0;
	}
		
	/**
	 * @description toString(): facilitator - helper method to process and display output
	 */
	public void addToString() {
		try {
			view.print("Date: ");
			view.print(getDay()+", "+getMonth()+" "+getDate()+", ");
			view.println(String.valueOf(getYear()));
			view.print("Time: ");
			view.print(String.valueOf(getHour()) +":"+String.valueOf(getMinute())+":"+String.valueOf(getSecond())+" "+suffix);
			if(gcalendar.isLeapYear(year)) {
				view.print("\nThe current year is a leap year.");
			} else {
				view.print("\nThe current year is not a leap year.");
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description main(): mutator - application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		GCalendar cal = new GCalendar();
		cal.addToString();
	}
}
