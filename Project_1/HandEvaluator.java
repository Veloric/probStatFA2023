/**
 * Evaluates a set of cards, and preforms a Monte Carlo simulation with poker rules.
 * @author Kyle Geddes
 * 10/29/2023
 */

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {

	private ArrayList<Card> deck;
	
	public void populateDeck(int totalCards) {
		this.deck = new ArrayList<Card>(totalCards);
		int maxSuitType = 13;
		for(int i = 0; i < maxSuitType; i++){
			this.deck.add(new Card(i, "Hearts"));
		}
		for(int i = 0; i < maxSuitType; i++){
			this.deck.add(new Card(i, "Clubs"));
		}
		for(int i = 0; i < maxSuitType; i++){
			this.deck.add(new Card(i, "Spades"));
		}
		for(int i = 0; i < maxSuitType; i++){
			this.deck.add(new Card(i, "Diamonds"));
		}
		
		this.shuffle();
	}

	/**
	 * Shuffles an array of cards. (Knowledge obtained from: https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist)
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
	public boolean evaluateStraight(ArrayList<Card> hand){
		boolean test = false;
		for(int i = 0; i < hand.size() - 1; i++){
			if(hand.get(i + 1).getValue() == hand.get(i).getValue() - 1){
				test = true;
			} else {
				// At first fail, it's over.
				test = false;
				return test;
			}
		}
		return test;
	}

	/**
	 * Test for a flush in the hand.
	 * @param hand - Hand to test
	 * @return - False if mismatched suits, true otherwise.
	 */
	public boolean evaluateFlush(ArrayList<Card> hand){
		Card first = hand.get(0);
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).getSuit() != first.getSuit()){
				return false;
			}
		}
		return true;
	}

	/**
	 * Evaluates a StraightFlush, it must pass both straight and flush tests
	 * @param hand - Hand to test
	 * @return = Result of flush and straight, true if and only if both pass.
	 */
	public boolean evaluateStraightFlush(ArrayList<Card> hand){
		return evaluateFlush(hand) && evaluateStraight(hand);
	}

	public boolean evaluateFullHouse(ArrayList<Card> hand){
		return evaluateThreeKind(hand) && evaluatePair(hand);
	}

	public boolean evaluateRoyalFlush(ArrayList<Card> hand){
		boolean test = false;
		Card first = hand.get(0);
		int count = 0;
		// If any of the suits do not match the first card, automatically disqualify.
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).getSuit() != first.getSuit()){
				return false;
			}
			if(hand.get(i).getValue() == 1 || hand.get(i).getValue() == 13 || hand.get(i).getValue() == 12 || hand.get(i).getValue() == 11 || hand.get(i).getValue() == 10){
				count = count + 1;
			}
		}
		// Check to see if all the exodia pieces are present. (In lets say, a 10 card deck, as long as the exodia pieces are present, the rest doesn't matter)
		if(count >= 5){
			test = true;
		}
		return test;
	}

	public boolean evaluateHighCard(ArrayList<Card> hand){
		int count = 0;
		boolean test = false;
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).getValue() == 1 || hand.get(i).getValue() == 13 || hand.get(i).getValue() == 12 || hand.get(i).getValue() == 11){
				count = count + 1;
			}
		}
		if(count == 1){
			test = true;
		}
		return test;
	}

	public boolean outputToFile(double[] stats, String[] descs, String fileName){
		boolean success = false;
		// Attempt to make a file.
		try{
			File newFile = new File(fileName);
			newFile.createNewFile();
		}catch(IOException e){
			return success;
		}
		//Now write to it
		try{
			FileWriter writer = new FileWriter(fileName);
			for(int i = 0; i < stats.length; i++){
				writer.write(descs[i] + "," + stats[i] * 100 + "\n");
			}
			writer.close();
			success = true;
		} catch(IOException e){
			return success;
		}
		return success;
	}

	public String simulate(int totalTrials){
		int passPair = 0;
        int passThree = 0;
        int passFour = 0;
        int passStraight = 0;
        int passFlush = 0;
        int passFullHouse = 0;
        int passStraightFlush = 0;
        int passRoyal = 0;
        int passHighCard = 0;
        for(int i = 0; i < totalTrials; i++){
            ArrayList<Card> hand = drawHand(5);
            if(evaluatePair(hand)){
                passPair = passPair + 1;
            }
            if(evaluateThreeKind(hand)){
                passThree = passThree + 1;
            }
            if(evaluateFourKind(hand)){
                passFour = passFour + 1;
            }
            if(evaluateStraight(hand)){
                passStraight = passStraight + 1;
            }
            if(evaluateFlush(hand)){
                passFlush = passFlush + 1;
            }
            if(evaluateFullHouse(hand)){
                passFullHouse = passFullHouse + 1;
            }
            if(evaluateStraightFlush(hand)){
                passStraightFlush = passStraightFlush + 1;
            }
            if(evaluateRoyalFlush(hand)){
                passRoyal = passRoyal + 1;
            }
            if(evaluateHighCard(hand)){
                passHighCard = passHighCard + 1;
            }
        }
        double[] stats = {
            passPair / (double)totalTrials,
            passThree / (double)totalTrials,
            passFour / (double)totalTrials,
            passStraight / (double)totalTrials,
            passFlush / (double)totalTrials,
            passFullHouse / (double)totalTrials,
            passStraightFlush / (double)totalTrials,
            passRoyal / (double)totalTrials,
            passHighCard / (double)totalTrials
        };
        String[] descs = {
            "Pairs",
            "Three of a Kind",
            "Four of a Kind",
            "Straight",
            "Flush",
            "Full House",
            "Straight Flush",
            "Royal Flush",
            "High Card"
        };
		outputToFile(stats, descs, "pokerData.csv");
        return(String.format("In this test of %d hands: Pairs: %d, Three of a kind: %d, Four of a kind: %d, Straights: %d, Flush: %d, Full House: %d, Straight flush: %d, Royal Flush: %d, and %d High cards", totalTrials, passPair, passThree, passFour, passStraight, passFlush, passFullHouse, passStraightFlush, passRoyal, passHighCard));
	}

}
