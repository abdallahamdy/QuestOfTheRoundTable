package com.group42.Cards;

import java.io.File;

public class RankCard extends Card {

	private int cardNumber;
	
	public RankCard(int rankNum, String rankName, String imgFile){
		cardNumber = rankNum;
		name = rankName;
		faceUp = imgFile;
	}
	
	public String getRank() {
		return name;
	}
	
	public int getRankNumber() {
		return cardNumber;
	}
	
	public String toString() {
		return "Ranked Card : " + getRankNumber() + " " + getRank();
	}
}
