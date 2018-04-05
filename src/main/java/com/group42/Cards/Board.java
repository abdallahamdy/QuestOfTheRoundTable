package com.group42.Cards;
import java.util.ArrayList;

//import AI.*;
//import Event.*;
//import Game.*;
public class Board {
	//protected ArrayList<Card> EntireDeck = new ArrayList<Card>();
	
	private Deck EntireDeck = new Deck();
	private StoryDeck sDeck = new StoryDeck();
	private AdventureDeck aDeck = new AdventureDeck();
	private RankDeck rDeck;
	
	
	private ArrayList<StoryCard> discardStory = new ArrayList<StoryCard>();
	private ArrayList<AdventureCard> discardAdventure= new ArrayList<AdventureCard>();
	
	/* Weapons 49
	 * Foes 50
	 * Test 4
	 * Allies 10
	 * Amours 8
	 */
	public Board() {
		//System.out.println("Database Deck void Constructor");
		//System.out.println("Database Total com.group42.Cards "+ EntireDeck.getNumCards());
		//System.out.println("Database Adventure Deck Total com.group42.Cards "+EntireDeck.getNumCards());

		//intalizeDeck();
	}

	public Board(StoryDeck newSDeck, RankDeck newRDeck, AdventureDeck newADeck) {
		sDeck = newSDeck;
		rDeck = newRDeck;
		aDeck = newADeck;
		
		//init_Decks(rDeck,sDeck, aDeck);

	}
	
	public  void intalizeDeck() {

	}
	

	public Deck getDeck() {
		return EntireDeck;
	}
	
	
	public RankDeck getRankDeck() {
		return rDeck;
	}
	
	public StoryDeck getStoryDeck() {
		return sDeck;
	}
	
	public AdventureDeck getAdventureDeck() {
		return aDeck;
	}
	
	public void discardStoryCard(StoryCard card) {
		discardStory.add(card);	
	}
	
	public void discardAdventureCard(AdventureCard card) {
		discardAdventure.add(card);
	}


	public static void main(String[] args) {
				
		
	}

}
