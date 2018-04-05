package com.group42.Cards;

import java.io.File;

public class TournamentCard extends StoryCard{
	
	//private String location;
	private int bonusNum;
	
	public TournamentCard(int newNum, String newLoc, String imgFile) {
		bonusNum = newNum;
		name = newLoc;
		faceUp = imgFile;
	}
	
	public String getLocation() {
		return faceUp;
	}
	public int getBonusNum() {
		return bonusNum;
	}
	public String toString() {
		return "Tournament Card : " + name + " - Bonus Shields: " + bonusNum;
	}
}
