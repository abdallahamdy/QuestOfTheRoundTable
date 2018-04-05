package com.group42.Cards;

import java.io.File;

public class TestCard extends AdventureCard {

	private String desc;
	
	
	public TestCard(String newName, String imgFile) {
		name = newName;
		faceUp = imgFile;
	}
	
	public TestCard(String newName, String newDesc, String imgFile) {
		name = newName;
		desc = newDesc;
		faceUp = imgFile;
	}
	
	public String getDesc() {
		return desc;
	}
	public String toString() {
		return "Test Card : " + name + " " + desc; 
		
		
	}
}
