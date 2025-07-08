/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author ???
 * @version ???
 */

/*
 * UML CLASS DIAGRAM:
 * -------------------------------------------------------
 *   Card
 * -------------------------------------------------------
 * - value : int
 * - suit : char
 * + HEART : char			//static constant with value ♥
 * + DIAMOND : char			//static constant with value ♦
 * + CLUB : char			//static constant with value ♣
 * + SPADE : char			//static constant with value ♠
 * + DEFAULT_VALUE : int	//static constant with value 1
 * + DEFAULT_SUIT : char	//static constant with value ♥
 * -------------------------------------------------------
 * + Card()
 * + Card(value : int, suit : char)
 * + Card(original : Card)
 * + setValue(value : int) : boolean
 * + setSuit(suit : char) : boolean
 * + setAll(value : int, suit : char) : boolean
 * + getSuit() : char
 * + getValue() : int
 * + getPrintValue() : String
 * + getPrintCard() : String
 * + toString() : String
 * + equals(otherCard : Card) : boolean
 * + printCard() : void
 * -------------------------------------------------------
 */

public class Card {
	public static final char HEART = '♥';
	public static final char DIAMOND = '♦';
	public static final char CLUB = '♣';
	public static final char SPADE = '♠';
	public static final int DEFAULT_VALUE = 1;
	public static final char DEFAULT_SUIT = HEART;
	private int value;
	private char suit;

	public Card() {
		setAll(DEFAULT_VALUE, DEFAULT_SUIT);
	}

	// Full constructor
	public Card(int value, char suit) {
		if (!setAll(value, suit)) {
			System.out.println("Invalid card: " + value + " " + suit);
			System.exit(1);
		}
	}

	// Copy constructor
	public Card(Card original) {
		if (original == null) {
			System.out.println("Cannot copy null Card object");
			System.exit(1);
		}
		this.value = original.value;
		this.suit = original.suit;
	}

	/*** MUTATOR METHODS (SETTERS) ***/
	public boolean setValue(int value) {
		if (value >= 1 && value <= 13) {
			this.value = value;
			return true;
		}
		return false;
	}

	public boolean setSuit(char suit) {
		if (suit == HEART || suit == DIAMOND || suit == CLUB || suit == SPADE) {
			this.suit = suit;
			return true;
		}
		return false;
	}

	public boolean setAll(int value, char suit) {
		boolean validValue = (value >= 1 && value <= 13);
		boolean validSuit = (suit == HEART || suit == DIAMOND || suit == CLUB || suit == SPADE);
		if (validValue && validSuit) {
			this.value = value;
			this.suit = suit;
			return true;
		}
		return false;
	}

	/*** ACCESSOR METHODS (GETTERS) ***/
	public char getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String getPrintValue() {
		switch (value) {
			case 1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
			default: return String.valueOf(value);
		}
	}

	public String getPrintCard() {
		String top = " _____";
		String mid = "|" + getPrintValue();
		if (getPrintValue().length() == 1) mid += " ";
		mid += "  |\n";
		String suitLine = "|  " + suit + "  |\n";
		String bot = "|__" + getPrintValue();
		if (getPrintValue().length() == 1) bot += " ";
		bot += "_|";
		return top + "\n" + mid + suitLine + bot;
	}

	/*** OTHER REQUIRED METHODS ***/
	public String toString() {
		return getPrintValue() + " " + suit;
	}

	public boolean equals(Card other) {
		return this.value == other.value && this.suit == other.suit;
	}

	/*** EXTRA METHODS ***/
	public void printCard() {
		System.out.println(getPrintCard());
	}
}

