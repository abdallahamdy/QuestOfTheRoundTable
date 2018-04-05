package com.group42.Cards;

import java.io.File;

import javax.imageio.ImageIO;

public class AmourCard extends AdventureCard{

	private int numBid;
	private String desc;
	
	public AmourCard(int newNum, String newDesc) {
		number = newNum;
		numBid = 1;
		desc = newDesc;
		faceUp = "/static/cards/faceup/Amour/Amour.jpg";
	}
	
	public int getNumBid() {
		return numBid;
	}
	public String toString() {
		return "Amour Card : " + name + " " + number+ " "+desc;
	}
	
}
