package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import com.group42.Cards.Board;
import com.group42.model.Player;
import org.apache.log4j.Logger;


public class Pox implements EventBehavior {

	
	static Logger log = Logger.getLogger(Pox.class);
	public void applyBehavior(Player drawnPlayer, ArrayList<Player> Players, Board board) {
		// TODO Auto-generated method stub
		
		log.info("EventBehavior: Pox");
		
		for (int i=0; i <Players.size(); i++) {
			if (!(Players.get(i).equals(drawnPlayer))){
				if (Players.get(i).getNumOfShields() >= 1) {
					log.info("Pox is being applied to: " + Players.get(i).getName());
					Players.get(i).increaseShields(-1);
				}
			}
		}
	}

}
