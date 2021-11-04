package enums;

/**
 * @author A., Didum & Multivision
 * @date February 26, 2013
 * @description Suit(): Advanced enumeration technique
 */
public enum Suit {
	//these constants call Suit specific constructor
	SPADES("Spades"),
	HEARTS("Hearts"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	private final String name;
	/**
	 * Suit(): specific constructor
	 * @param name
	 */
	private Suit(String name) {
		this.name = name;
	}
	
	/**
	 * getName(): accessor - returns a name
	 * @Note this method is accessible outside of enum since it's declared as public
	 */
	public String getName() {
		return name;
	}
}
