package com.group42.Cards;

import java.io.File;


public abstract class Card {

	protected String name;
	protected String faceUp;
	protected int number;
	protected boolean picked;
	
	public String getName() {
		return name;
	}
	
	public String getFaceUp() {
		return faceUp;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPick(boolean check) {
		picked = check;
	}
	
	public boolean getPick() {
		return picked;
	}
	
}
