package pclient;

import java.util.*;

import callable.io.Print;

/**
 * @author A., Didum
 * @date February 28, 2013
 * @description StringTokenizers(): demonstration class
 */
public class StringTokenizers {
	String str;
	Print view;
	//default constructor
	public StringTokenizers() {
		str = "Title=Fundamentals of Java;";
		str += "@2nd Edition ";
		str += "Author=Lambert and Osborne;";
		str += "@Copyright=2003;";
		view = new Print();
	}
	
	public void processToken() {
		StringTokenizer token = new StringTokenizer(str, "=@;");
		while(token.hasMoreTokens()) {
			String key = token.nextToken();
			String value = token.nextToken();
			view.println(key+" "+value);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringTokenizers tokens = new StringTokenizers();
		tokens.processToken();
	}

}
