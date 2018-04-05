package com.group42.Cards;

//import java.io.File;

public class AllyCard extends AdventureCard{
	
	
	//TODO: Fix AllyCards, issues with constructor because of different variations of cards
	private String desc;
	private int numBids;
	
	public AllyCard( int bpNum,String newName, String newDesc, String imgFile) {
		name = newName;
		number = bpNum;
		desc = newDesc;
		faceUp = imgFile;
	}
	
	public AllyCard(String newName, String newDesc, String imgFile) {
		name = newName;
		desc = newDesc;
		faceUp = imgFile;
	}
	
	public AllyCard(String newName, int bpNum, int bidNum, String newDesc, String imgFile) {
		name = newName;
		number = bpNum;
		numBids = bidNum;
		desc = newDesc;
		faceUp = imgFile;
	}
	
	public AllyCard(String newName, int bidNum) {
		name = newName;
		numBids = bidNum;
	}
	

	/* public AllyCard(String newName, int bpNum) {
		name = newName;
		number = bpNum;
	}*/ 
 
}
