package com.group42.Cards;

import java.util.ArrayList;
import java.util.Collections;
/*
 * Story Deck class
 * Rank Deck Class 
 * Adventure deck class 
 * 
 * sheilds 
 * 
 */

public class Deck {

	protected  ArrayList<Card> deckCards = new ArrayList<Card>();
	protected int numCards = 0;
	
	
	
	public Deck() {
		// goes in con ArrayList<Card> nCards
		//deckCards = nCards;
		numCards = deckCards.size();
		
	}
	
	public Card removeCardAt(int index) {
		return deckCards.remove(index);
		
	}
	
	public Card removeCard(Card toRemove) {
		return deckCards.remove(deckCards.indexOf(toRemove));
	}
	
	public int getNumCards() {
		return deckCards.size();
	}
	public Card getCard(int x) {
		
		return deckCards.get(x);
	}
	public Card popCard() {
		return deckCards.remove(0);
	}
	public void add(Card x) {
		deckCards.add(x);
	}
	public void shuffleDeck() {
		Collections.shuffle(deckCards);
	}
	

}
