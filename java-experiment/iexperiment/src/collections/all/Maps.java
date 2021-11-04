package collections.all;

import java.util.*;

import callable.io.Print;
/**
 * @author A., Didum
 * @date Februrary 26, 2013
 * @description Maps(): general purpose collections using maps in <code>java.util</code>
 */
public class Maps {
	//instance var
	Map<Object, Object> map;
	
	/**
	 * Maps(): default constructor
	 * @Notes any of the collections in collections.maps could replace HashMap in this example <br />
	 * maps accepts null keys and null values
	 */
	public Maps() {
		map = new HashMap<Object, Object>();
	}
	
	/**
	 * getMap(): accessor - adds elements to map contents
	 * @return
	 */
	private Map<Object, Object> getMap(){
		map.put("one", "1st");
		map.put("two", new Integer(2));
		map.put("3rd", "third");
		map.put("3rd", "III");			//overwrites the previous assignment, duplicate elements, not allowed
		map.put("fourth", new Float(5.0F));
		map.put("double", new Double(8.45));
		map.put("char", new Character('D'));
		map.put("4th", new Integer(4));		
		map.put("string", new String("mapString"));
		return map;
	}
	
	/**
	 * getMapKeys(): accessor - returns map keys
	 * @return keys
	 */
	public Collection<Object> getMapKeys(){
		Collection<Object> keys = map.keySet();
		return keys;
	}
	
	/**
	 * getMapValues(): accessor - returns map values
	 * @return values
	 */
	public Collection<Object> getMapValues(){
		Collection<Object> values = map.values();
		return values;
	}
	
	/**
	 * getMapEntry(): accessor - returns set view of key value mappings
	 * @return entry
	 */
	public Collection<Object> getMapEntry(){
		Collection<Object> entry = map.values();
		return entry;
	} 
	
	/**
	 * toString(): facilitator - returns results
	 */
	public String toString() {
		//could replace getMap() with map
		return "Original contents: "+String.valueOf(getMap())	//original contents
				+"\nKeys: "+String.valueOf(getMapKeys())		//map keys
				+"\nValues: "+String.valueOf(getMapValues())	//map values
				+"\nEntry: "+String.valueOf(getMapEntry()); 	//map entrysets
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		Maps map = new Maps();
		
		view.println("Here is the output: \n"+map.toString());
	}

}
