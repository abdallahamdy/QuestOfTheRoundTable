package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import com.group42.Cards.Board;
import com.group42.model.Player;
import org.apache.log4j.Logger;


public class Plague implements EventBehavior{

	static Logger log = Logger.getLogger(Plague.class);
	
	public void applyBehavior(Player drawnPlayer, ArrayList<Player> players, Board board) {
		
		log.info("EventBehavior: Plague");
		
		if (drawnPlayer.getNumOfShields() >= 2) {
			log.info("Pleague has been applied to: " + drawnPlayer.getName());
			drawnPlayer.increaseShields(-2);
			return;
		}else if(drawnPlayer.getNumOfShields() == 1) {
			log.info("Pleague has been applied to: " + drawnPlayer.getName());
			drawnPlayer.increaseShields(-1);
		}
	}
}