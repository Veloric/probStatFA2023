/**
 * Card class, contains a value and suit.
 * NOTES: 1 = Ace, 11 = Jack, 12 = Queen, 13 = King
 * @author Kyle Geddes
 * 10/29/2023
 */
public class Card {
	
	private int value;
	private String suit;
	
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getValue(){
		return this.value;
	}

	public String getSuit(){
		return this.suit;
	}

	public boolean equals(Card compare){
		if(this.value == compare.value && this.suit == compare.suit){
			return true;
		} else {
			return false;
		}
	}

}
