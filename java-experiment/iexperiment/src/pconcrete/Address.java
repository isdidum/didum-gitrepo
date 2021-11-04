package pconcrete;

/**
 * @author A., Didum
 * @date Feb 11, 2013
 * @description Address(): concrete class Address
 * @see collections.iterator.IteratorLinList.java
 */
public class Address {
	//private instance variable
	private String name;
	private String street;
	private String city;
	private String state;
	private String zcode;
	private String apt;
	
	/**
	 * @description Address(): specific constructor
	 */
	public Address(String nam, String str, String apt, String cty, String st, String zp) {
		name = nam;
		street = str;
		this.apt = apt;
		city = cty;
		state = st;
		zcode = zp;
	}
	
	/**
	 * @description Address(): default constructor
	 */
	public Address() {
		this("", "", "", "", "", "");
	}
	
	/**
	 * @description toString(): facilitator - displays user data to console window 
	 */
	public String toString() {
		return name +"\n"+ street +" "+ apt +"\n" + city +", "+ state +" "+zcode;
	}

}
