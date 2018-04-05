package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import org.apache.log4j.Logger;

//import Event.*;
import com.group42.model.Player;
import com.group42.Cards.*;

public class ChivalrousDeed implements EventBehavior{
	
	static Logger log = Logger.getLogger(ChivalrousDeed.class);
	
	public void applyBehavior(Player drawnPlayer, ArrayList<Player> players, Board board) {
		
		log.info("EventBehavior: Chilvarous Deed");
		
		int numPlayers = players.size();
		ArrayList<Player> lowestPlayers = new ArrayList<Player>();
		lowestPlayers.add(players.get(0));
		
		for (int i=1; i<numPlayers; i++) {
			if (players.get(i).getRankNum() < lowestPlayers.get(0).getRankNum()) {
				lowestPlayers.clear();
				lowestPlayers.add(players.get(i));
			}else if(players.get(i).getRankNum() == lowestPlayers.get(0).getRankNum()) {
				if (players.get(i).getNumOfShields() < lowestPlayers.get(0).getNumOfShields()) {
					lowestPlayers.clear();
					lowestPlayers.add(players.get(i));
				}else if(players.get(i).getNumOfShields() == lowestPlayers.get(0).getNumOfShields()) {
					lowestPlayers.add(players.get(i));
				}
			}
		}
		
		
		log.info("Players that will gain 3 shields: ");
		for(int i =0; i<lowestPlayers.size();i++) {
			log.info(lowestPlayers.get(i).getName() + " has received 3 shields");
		}
		
		
		
		
		
		// After lowest player has been set, increase their shields by 3		
		for (int j=0; j<players.size(); j++) {
		//	lowestPlayers.get(j).increaseShields(3);
			for (int k=0; k < lowestPlayers.size(); k++) {
				if (players.get(j).equals(lowestPlayers.get(k))) {
					players.get(j).increaseShields(3);
					break;
				}
			}
		}
		
	}


}
