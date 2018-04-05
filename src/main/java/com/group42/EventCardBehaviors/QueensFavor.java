package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.group42.Cards.Board;
import com.group42.model.Player;


public class QueensFavor implements EventBehavior {

	static Logger log = Logger.getLogger(QueensFavor.class);
	
	public void applyBehavior(Player drawnPlayer, ArrayList<Player> players, Board board) {
		
		log.info("EventBehavior: Queens Favor");
		// TODO Auto-generated method stub
		int numPlayers = players.size();
		ArrayList<Player> lowestPlayers = new ArrayList<Player>();
		lowestPlayers.add(players.get(0));
		
		for (int i=1; i<numPlayers; i++) {
			if (players.get(i).getRankNum() < lowestPlayers.get(0).getRankNum()) {
				lowestPlayers.clear();
				lowestPlayers.add(players.get(i));
			}else if(players.get(i).getRankNum() == lowestPlayers.get(0).getRankNum()) {
					lowestPlayers.add(players.get(i));
				}
		}
		
		// After lowest player has been set, let them draw 2 cards
		
		for (int i=0; i<players.size(); i++) {
			for(int j=0; j<lowestPlayers.size(); j++) {
				if (players.get(i).equals(lowestPlayers.get(j))){
					log.info("Applying Queens Favor to: " + players.get(i).getName());
					players.get(i).addHand(board.getAdventureDeck().popCard());
					players.get(i).addHand(board.getAdventureDeck().popCard());
				}
			}
		}
			
		
		
		
	}

}
