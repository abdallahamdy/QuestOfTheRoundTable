package com.group42.Cards;
import java.util.ArrayList;
import java.util.Collections;
import com.group42.EventCardBehaviors.*;

public class StoryDeck_S1 extends StoryDeck{
	protected ArrayList<StoryCard> deckCards = new ArrayList<StoryCard>();
	//protected int numCards;
	
	
	public StoryDeck_S1() {
		//nCards = nCards;
		
				/*
				 *  Story com.group42.Cards
				 *  boardStoryDeck
				 */
				
				// Quests
				
				//Rigged Order for Scenario 1
		
				QuestCard BoarHunt = new QuestCard(2, "Boar Hunt", "Boar", "/cards/faceup/Quest/Q_Boar_Hunt.jpg");
				deckCards.add(BoarHunt);

//				ProsperityRealm prosperityEvent = new ProsperityRealm();
//				EventCard ProsperityRealm = new EventCard("Prosperity Throughout the Realm", "All players may immediately draw 2 Adventure com.group42.Cards."
//														, "/cards/faceup/Event/E_Prosperity_Throughout_the_Realm.jpg", prosperityEvent);
//				deckCards.add(ProsperityRealm);
//
//
//				ChivalrousDeed chivalrousEvent = new ChivalrousDeed();
//				EventCard ChilvarousDeed = new EventCard ("Chivalrous Deed", "Player's with both lowest rank and least amount of shields, receives 3 shields", "/cards/faceup/Event/E_Chivalrous_Deed.jpg", chivalrousEvent);
//				deckCards.add(ChilvarousDeed);
//
	
				/*
				
				TournamentCard Camelot  = new TournamentCard(3, "Camelot", "/cards/faceup/Tournament/To_Camelot.jpg");
				deckCards.add(Camelot);
				
				Plague event3 = new Plague();
				EventCard Plague = new EventCard ("Plague", "Drawer loses 2 shields if possible", "/cards/faceup/Event/E_Plague.jpg", event3);
				deckCards.add(Plague);
				
				Pox poxEvent = new Pox();
				EventCard Pox = new EventCard ("Pox", "All players except the player drawing this card lose 1 shield.", "/cards/faceup/Event/E_Pox.jpg", poxEvent);
				deckCards.add(Pox);
				
				
				QueensFavor queenFavEvent = new QueensFavor();
				EventCard QueensFav = new EventCard("Queen's Favor", "The lowest ranked player(s) immediately receives 2 Adventure com.group42.Cards", "/cards/faceup/Event/E_Queen's_Favor.jpg",queenFavEvent);
				deckCards.add(QueensFav);
				
				EventCard QueensFav2 = new EventCard("Queen's Favor", "The lowest ranked player(s) immediately receives 2 Adventure com.group42.Cards", "/cards/faceup/Event/E_Queen's_Favor.jpg",queenFavEvent);
				deckCards.add(QueensFav2);
				
		
				QuestCard JourneyEnchantedForest = new QuestCard(3, "Journey through the Enchanted Forest", "Evil Knight", "/cards/faceup/Quest/Q_Journey_through_the_Enchanted_Forest.jpg");
				deckCards.add(JourneyEnchantedForest);

				QuestCard VanquishKingAenemies = new QuestCard(3, "Vanquish King Arthur's Enemies", "", "/cards/faceup/Quest/Q_Vanquish_King_Arthur's_Enemies.jpg");
				deckCards.add(VanquishKingAenemies);
				
				QuestCard VanquishKingAenemies2 = new QuestCard(3, "Vanquish King Arthur's Enemies", "", "/cards/faceup/Quest/Q_Vanquish_King Arthur's_Enemies.jpg");
				deckCards.add(VanquishKingAenemies2);

				// Not sure how to handle the Special Foe: All Saxons FIX
				QuestCard RepelSaxons = new QuestCard(2, "Repel the Saxon Raiders", "All Saxons", "/cards/faceup/Quest/Q_Repel_the_Saxon_Raiders.jpg");
				deckCards.add(RepelSaxons);
				

				
				QuestCard SearchForQuestingBeast = new QuestCard (4, "Search for the Questing Beast", "", "/cards/faceup/Quest/Q_Search_for_the_Quest_Beast.jpg");
				deckCards.add(SearchForQuestingBeast);

				// Same issue with the multiple Special Foes FIX
				QuestCard DefendQueenHonor = new QuestCard (4, "Defend the Queen's Honor", "All", "/cards/faceup/Quest/Q_Defend_the_Queen's_Honor.jpg");
				deckCards.add(DefendQueenHonor);
				
				
				QuestCard SlayDragon = new QuestCard(3, "Slay the Dragon", "Dragon", "/cards/faceup/Quest/Q_Slay_the_Dragon.jpg");
				deckCards.add(SlayDragon);


				
				QuestCard RescueFairMaiden = new QuestCard(3, "Rescue the Fair Maiden","Black Knight", "/cards/faceup/Quest/Q_Rescue_the_Fair_Maiden.jpg");
				deckCards.add(RescueFairMaiden);

				// Same issue with the multiple Special foes FIX 
				QuestCard SearchForHolyGrail = new QuestCard(5, "Search for the Holy Grail", "All", "/cards/faceup/Quest/Q_Search_for_the_Holy_Grail.jpg");
				deckCards.add(SearchForHolyGrail);
		
				QuestCard TestGreenKnight  = new QuestCard(4, "Test of the Greek Knight","Green Knight", "/cards/faceup/Quest/Q_Test_of_the_Green_Knight.jpg");
				deckCards.add(TestGreenKnight);


				
				// Tournaments
				//TODO: Tournaments
//				TournamentCard Camelot  = new TournamentCard(3, "Camelot", "/cards/faceup/Tournament/To Camelot.jpg");
//				deckCards.add(Camelot);

				
				TournamentCard Orkney   = new TournamentCard(2, "Orkney", "/cards/faceup/Tournament/To_Orkney.jpg");
				deckCards.add(Orkney);

				
				TournamentCard Tintagel = new TournamentCard(1, "Tintagel", "/cards/faceup/Tournament/To_Orkney.jpg");
				deckCards.add(Tintagel);

				
				TournamentCard York 	= new TournamentCard(0, "York", "/cards/faceup/Tournament/To_Orkney.jpg");
				deckCards.add(York);

				
				// Events
				//TODO: Events
				
	/*			

				

				

				EventCard KingsRecog = new EventCard("King's Recognition", "The next player(s) to complete a Quest will receive 2 extra shields", "/cards/faceup/Event/E King's Recognition.jpg");
				deckCards.add(KingsRecog);

				EventCard KingsRecog2 = new EventCard("King's Recognition", "The next player(s) to complete a Quest will receive 2 extra shields", "/cards/faceup/Event/E King's Recognition.jpg");
				deckCards.add(KingsRecog2);
				
				
			
				EventCard CourtCallCamelot = new EventCard("Court Called to Camelot", "All Allies in play must be discarded", "/cards/faceup/Event/E Court Called to Camelot.jpg");
				deckCards.add(CourtCallCamelot);

				EventCard CourtCallCamelot2 = new EventCard("Court Called to Camelot", "All Allies in play must be discarded", "/cards/faceup/Event/E Court Called to Camelot.jpg");
				deckCards.add(CourtCallCamelot2);
				
				EventCard KingsCall = new EventCard("King's Call to Arms", "The highest ranked player(s) must place 1 weapon in the discard pile. If unable to do so, 2 Foe com.group42.Cards must be discarded"
													, "/cards/faceup/Event/E King's Call to Arms.jpg");
				deckCards.add(KingsCall);

				*/
				
		
	}
	
	public StoryCard getCard(int x) {
		return deckCards.get(x);
	}
	
	public StoryCard popCard() {
		return deckCards.remove(0);
	}
	
	public int getNumCards() {
		return deckCards.size();
	}
	
}


