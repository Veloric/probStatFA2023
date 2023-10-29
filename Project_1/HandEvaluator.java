/**
 * Evaluates a set of cards, and preforms a Monte Carlo simulation with poker rules.
 * @author Kyle Geddes
 * 10/29/2023
 */

import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {

	private ArrayList<Card> deck;
	
	public void populateDeck(int totalCards) {
		this.deck = new ArrayList<Card>(totalCards);
		int maxSuitType = 13;
		int location = 0;
		int value = 1;
		for(int i = 0; i < maxSuitType; i++) {
			this.deck.add(new Card(value, "Hearts"));
			location = location + 1;
			value = value + 1;
		}
		value = 1;
		for(int i = location; i < location + maxSuitType; i++){
			this.deck.add(new Card(value, "Spades"));
			value = value + 1;
			location = location + 1;
		}
		value = 1;
		for(int i = location; i < location + maxSuitType; i++){
			this.deck.add(new Card(value, "Diamonds"));
			location = location + 1;
			value = value + 1;
		}
		value = 1;
		for(int i = location; i < location + maxSuitType; i++){
			this.deck.add(new Card(value, "Clubs"));
			location = location + 1;
			value = value + 1;
		}
		this.shuffle();
	}

	/**
	 * Shuffles an array of cards. (Knowledge obtained from: https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist)
	 * @param deck - Array of cards being shuffled.
	 */
	public void shuffle(){
		Collections.shuffle(this.deck);
	}

	/**
	 * Helper function that resets the deck to the standard 52 cards, then shuffles it.
	 */
	private void _resetDesk(){
		this.populateDeck(52);
		this.shuffle();
	}

	/**
	 * Randomly selects a card, and remove it from the deck
	 * @return - The card selected.
	 */
	public Card drawCard(){
		Card selected = this.deck.get((int)Math.random() * this.deck.size());
		deck.remove(selected);
		return selected;
	}

	/**
	 * 
	 * @param amount - Amount of cards to draw in the hand.
	 * @return - An ArrayList of cards
	 */
	public ArrayList<Card> drawHand(int amount){
		ArrayList<Card> hand = new ArrayList<Card>(amount);
		for(int i = 0; i < amount; i++){
			Card selected = this.drawCard();
			hand.add(selected);
		}
		_resetDesk();
		return hand;
	}

	/**
	 * Evaluates a pair (according to Poker rules)
	 * @param hand1 - Hand to evaluate
	 * @return - True if pair found, false otherwise.
	 */
	public boolean evaluatePair(ArrayList<Card> hand1){
		for(int i = 0; i < hand1.size(); i++){
			for(int j = 0; j < hand1.size(); j++){
				if((hand1.get(i).getValue() == hand1.get(j).getValue() == true) && (hand1.get(i).equals(hand1.get(j))) == false){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Evaluates a three of a kind (according to Poker rules)
	 * @param hand - Hand to evaluate
	 * @return - True if found, false otherwise.
	 */
	public boolean evaluateThreeKind(ArrayList<Card> hand){
		int matches = 0;
		for(int i = 0; i < hand.size(); i++){
			for(int j = 0; j < hand.size(); j++){
				if(!hand.get(i).equals(hand.get(j))){
					if(hand.get(i).getValue() == hand.get(j).getValue()){
						matches = matches + 1;
					}
				}
			}
			if(matches == 3){
				return true;
			}
		}
		return false;
	}

	/**
	 * Evaluates a four of a kind (according to Poker rules)
	 * @param hand - Hand to evaluate
	 * @return - True if found, false otherwise.
	 */
	public boolean evaluateFourKind(ArrayList<Card> hand){
		int matches = 0;
		for(int i = 0; i < hand.size(); i++){
			for(int j = 0; j < hand.size(); j++){
				if(!hand.get(i).equals(hand.get(j))){
					if(hand.get(i).getValue() == hand.get(j).getValue()){
						matches = matches + 1;
					}
				}
			}
			if(matches == 4){
				return true;
			}
		}
		return false;
	}

	/**
	 * Evaluates a Straight (according to Poker rules)
	 * @param hand - Hand to evaluate
	 * @return - True if found, false otherwise.
	 */
	public boolean evaluteStraight(ArrayList<Card> hand){
		boolean test = false;
		for(int i = 1; i < hand.size(); i++){
			if(hand.get(i).getValue() == hand.get(i - 1).getValue() + 1){
				test = true;
			} else {
				test = false;
			}
		}
		return test;
	}


}
