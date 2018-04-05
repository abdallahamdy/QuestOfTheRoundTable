package com.group42.Cards;
import java.io.File;
import java.util.ArrayList;


import com.group42.EventCardBehaviors.EventBehavior;

public class EventCard extends StoryCard{
	
	private String desc;
	private EventBehavior EventProc;
	
	public EventCard(String eventName, String eventDesc, String imgFile, EventBehavior event) {
		name = eventName;
		desc = eventDesc;
		faceUp = imgFile;
		EventProc = event;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public String getLocation() {
		return faceUp;
	}
	
	public String toString() {
		return "Event Card : " + name + " " + desc;
	}
	
	//public void applyEvent(Player drawnPlayer, ArrayList<Player> players, Board board) {
	//	EventProc.applyBehavior(drawnPlayer, players, board);
	//}
	
	public EventBehavior getEvent() {
		return EventProc;
	}
	
}
