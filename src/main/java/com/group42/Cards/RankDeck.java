package com.group42.Cards;
import java.util.ArrayList;
import java.util.Collections;

public class RankDeck extends Deck{
//	public ArrayList<RankCard> deckCards = new ArrayList<RankCard>();
//	protected int numCards;
	
	public RankDeck(ArrayList<RankCard> nCards) {
	//	deckCards = nCards;
		

	// Creating and Adding Rank com.group42.Cards
		// creating 4 Squire cards
		RankCard Squire1 = new RankCard(5, "Squire", "/cards/faceup/Rank/R_Squire.jpg");
		RankCard Squire2 = new RankCard(5, "Squire", "/cards/faceup/Rank/R_Squire.jpg");
		RankCard Squire3 = new RankCard(5, "Squire", "/cards/faceup/Rank/R_Squire.jpg");
		RankCard Squire4 = new RankCard(5, "Squire", "/cards/faceup/Rank/R_Squire.jpg");
		
		// adding 4 Squire cards to the rank deck
		deckCards.add(Squire1); 
		deckCards.add(Squire2);
		deckCards.add(Squire3); 
		deckCards.add(Squire4); 
		
		// creating 4 Knight com.group42.Cards
		RankCard Knight1 = new RankCard(10, "Knight", "/cards/faceup/Rank/R_Knight.jpg");
		RankCard Knight2 = new RankCard(10, "Knight", "/cards/faceup/Rank/R_Knight.jpg");
		RankCard Knight3 = new RankCard(10, "Knight", "/cards/faceup/Rank/R_Knight.jpg");
		RankCard Knight4 = new RankCard(10, "Knight", "/cards/faceup/Rank/R_Knight.jpg");
					
		// adding 4 Knight cards to the rank deck
		deckCards.add(Knight1); 
		deckCards.add(Knight2);
		deckCards.add(Knight3); 
		deckCards.add(Knight4); 
					
		// creating 4 Champion Knight com.group42.Cards
		RankCard ChampKnight1 = new RankCard(20, "Champion Knight", "/cards/faceup/Rank/R_Champion Knight.jpg");
		RankCard ChampKnight2 = new RankCard(20, "Champion Knight", "/cards/faceup/Rank/R_Champion Knight.jpg");
		RankCard ChampKnight3 = new RankCard(20, "Champion Knight", "/cards/faceup/Rank/R_Champion Knight.jpg");
		RankCard ChampKnight4 = new RankCard(20, "Champion Knight", "/cards/faceup/Rank/R_Champion Knight.jpg");
		// adding 4 Champion Knights to the rank deck
		deckCards.add(ChampKnight1);
		deckCards.add(ChampKnight2);
		deckCards.add(ChampKnight3);
		deckCards.add(ChampKnight4);
		
	//	numCards = deckCards.size();

	}
	
	public int getNumCards() {
		return numCards;
	}
	
	public Card popCard() {
		return deckCards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deckCards);
	}
}
