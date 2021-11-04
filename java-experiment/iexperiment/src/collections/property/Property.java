package collections.property;

import java.util.*;

import callable.io.Print;
/**
 * Property(): concrete class Property
 * @author A., Didum
 * @date Feb 14, 2013
 * @notes Property is a subclass of Hashtable and is used to maintain lists of values<br />
 * 	in which both the key and value are of type String. Hence, Hashtable accepts null-key <br />
 * 	& null-value and forbids Iterable Interface, meaning, cannot use enhance for-loop <br /> nor iterator to cycle through elements.
 */
public class Property {
	// instance variable
	Print view;
	Properties prop;
	
	/**
	 * Property(): default constructor
	 */
	public Property() {
		view = new Print();
		prop = new Properties();
	}
	
	/**
	 * constProp(): accessor - property constant list
	 */
	private String[] constProp1() {
		try {
			String arrProp1[] = {"Iowa", "Missouri", "Washington", "Illinois"};
			return arrProp1;
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * constProp2(): accessor - property constant list
	 */
	private String[] constProp2() {
		try {
			String arrProp2[] = {"Des Moines", "St. Louis", "Olympia", "Springfield"};
				return arrProp2;
			} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * addProperty(): mutator - add elements to property list
	 */
	private void addProperty() {
		try {
			for(int i=0; i<constProp1().length; i++) {
				//stores key & value element pairs in prop list (state=key, capital=value)
				prop.put(constProp1()[i], constProp2()[i]);
			}
			view.print("Property object: "+prop+"");
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * setProperty(): mutator - add elements to property list
	 */
	private void setProperty() {
		try {
			view.println("");
			// get a set-view of the keys
			Set<Object> states = prop.keySet();
			for(Object name: states) {
				view.println(name+" has the capital of "+prop.getProperty((String)name)+".");
			}
			
			// search a state not in the list
			String str = prop.getProperty("Wisconsin", "Not Found");
			view.println("\nThe capital of Wisconsin is "+ str);
			
			prop.put("Wisconsin", "Madison");
			prop.put("Florida", "Tallahassee");
			
			view.print("Property object: "+prop+"");
			// search a state that is in the list
			String str1 = prop.getProperty("Wisconsin");
			view.println("\nThe capital of Wisconsin is "+ str1);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * addToString(): facilitator - displays hash map entries
	 */
	private void addToString() {
		try {
			addProperty();
			setProperty();
		}catch(Exception err) {err.printStackTrace();}
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Property p = new Property();
		p.addToString();
	}

}
