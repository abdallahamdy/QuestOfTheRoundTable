package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import org.apache.log4j.Logger;

//import Event.*;
import com.group42.model.Player;
import com.group42.Cards.*;

public class ProsperityRealm implements EventBehavior{
	
	static Logger log = Logger.getLogger(ProsperityRealm.class);
	
	public void applyBehavior(Player drawnPlayer, ArrayList<Player> players,  Board board) {
		
		log.info("EventBehavior: Prosperity Throughout the Realm");
		
		int numPlayers = players.size();
		for (int i=0; i < numPlayers; i++) {
			//TODO: check for errors in popCard, such as if the deck size is zero, it should take the decks discard pile and shuffle it
		
			log.info("Applying prosperity to player: " + players.get(i).getName());

			players.get(i).addHand(board.getAdventureDeck().popCard());
			players.get(i).addHand(board.getAdventureDeck().popCard());
		}
	}

	
}
