package com.group42.Cards;

import java.io.File;

public class FoeCard extends AdventureCard{

	//private int lowNum;
	private int numberHigh;
	private String desc;
	
	public FoeCard(int lowNum, String newName, String imgFile) {
		name = newName;
		number = lowNum;
		numberHigh = 0;
		desc = "";
		faceUp = imgFile;
	}
	
	public FoeCard(int lowNum, int highNum, String newName, String imgFile) {
		name = newName;
		number = lowNum;
		numberHigh = highNum;
		desc = "";
		faceUp = imgFile;

	}
	
	public FoeCard(int lowNum, String newName, String newDesc, String imgFile) {
		name = newName;
		number = lowNum;
		desc = newDesc;
		faceUp = imgFile;
	}
	
	
	
	public int getNumber() {
		return number;
	}
	
	public int getHighNum() {
		if (numberHigh <= 0) {
			return number;
		}
		return numberHigh;
	}
	public String toString() {
		
		if (desc.isEmpty()) {
			if (numberHigh < number) {
				return "Foe Card : " + name + " low " + number;
			} else if (numberHigh >= 0) {
				return "Foe Card : " + name + " low " + number + " high " + numberHigh;
			}
		}
		return "Foe Card : " + name + " low " + number + "Description: " + desc;
	}
}
