package collections.property;

import java.util.*;
import java.io.*;

import callable.io.Print;

/**
 * PropertyLoad: concrete class Property
 * @author A., Didum
 * @date Feb 14, 2013
 * @notes Property is a subclass of Hashtable and is used to maintain lists of values<br />
 * 	in which both the key and value are of type String. Hence, Hashtable accepts null-key <br />
 * 	& null-value and forbids Iterable Interface, meaning, cannot use enhance for-loop <br /> nor iterator to cycle through elements.
 */
public class PropertyLoad {
	// instance variable
	Print view;
	Properties prop;
	BufferedReader breader;
	String name, number;
	boolean changed = false;
	FileInputStream filein;
	private String path = "C:/Users/Didum/Documents/wksp/java/iexperiment/src/collections/property";
	
	/**
	 * PropertyLoad(): default constructor
	 */
	public PropertyLoad() {
		name = "";
		number = "";
		view = new Print();
		prop = new Properties();
		try {
			filein = new FileInputStream(path+"/phone.dat");
		} catch(FileNotFoundException err) {/*ignores missing file*/}
		breader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * phoneBook(): mutator - add elements to property list
	 */
	private void phoneBook() throws IOException {
		//if phonebook file already exists, load existing phone number
		try {
			String fileAlreadyExist = "A FILE ALREADY EXISTS WITH NAMES AND PHONE-NUMBERS IN IT\n";
			fileAlreadyExist += "YOU MAY NOW LOOK UP NUMBERS BY PROVIDING NAMES.\n";
			String noFileExist = "NO FILE IS FOUND IN THE DIRECTORY CONTAINING USER DATA\n";
			noFileExist += "YOU MAY NOW ENTER USER DATA BY PROVIDING NAMES AND PHONE-NUMBERS.\n";
			
			if(filein != null) {
				view.println(fileAlreadyExist);
				prop.load(filein);
				filein.close();
				lookUpNumber();
			} else {
				view.println(noFileExist);
				userEntryData();
				saveEntryData();
				lookUpNumber();
			}
		} catch (IOException err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * userEntryData(): mutator - collects new names and phone numbers
	 */
	private void userEntryData() {
		try {
			view.println("Enter new name: ");
			name = breader.readLine();
			while(!name.equals("quit") || !name.equals("q")) {
				view.println("Enter new number: ");
				number = breader.readLine();
				
				if(name.equals("quit") || name.equals("q")) continue;
				prop.put(name, number);
				changed = true;
				
				view.println("Enter new name ('quit or q' to halt): ");
				name = breader.readLine();
			}
			
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * saveUserData(): mutator - saves collected user data to an output file
	 */
	private void saveEntryData() {
		try {
			if(changed) {
				FileOutputStream fileout = new FileOutputStream(path+"/phone.dat");
				prop.store(fileout, "Telephone Book");
				fileout.close();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * lookUpNumber(): mutator - looks up number given a name
	 */
	private void lookUpNumber() {
		try {
			view.println("Enter name to find ('quit' to halt): ");
			name = breader.readLine();
			while(!name.equals("quit") || !name.equals("q")) {
				if(name.equals("quit") || name.equals("q")) continue;
				number = (String) prop.getProperty(name);
				view.println("Phone: "+number);
				
				view.println("Enter name to find ('quit or q' to halt): ");
				name = breader.readLine();
			}
		} catch (Exception err) {err.printStackTrace();	}
	}
	
	/**
	 * addToString(): facilitator - displays hash map entries
	 */
	private void addToString() {
		try {
			phoneBook();
		}catch(Exception err) {err.printStackTrace();}
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyLoad p = new PropertyLoad();
		p.addToString();
	}

}
