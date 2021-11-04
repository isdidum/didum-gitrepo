package enums;

import callable.io.Print;

/**
 * @author A., Didum
 * @date February 26, 2013
 * @description SuitClient(): demonstration of enum Suit
 */
public class SuitClient {
	private Suit suit;
	private int rank;
	
	/**
	 * SuitClient(): specific constructor
	 * @Notes this class invokes advanced enum type, namely, Suit <br />
	 * public methods on enumerated types are accessible
	 */
	public SuitClient(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int getRank() {
		return rank;
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		SuitClient suit = new SuitClient(Suit.SPADES, 2);
		view.println("card1 is the "+ suit.getRank() +" of "+suit.getSuit().getName());

	}

}
