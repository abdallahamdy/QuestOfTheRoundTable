package com.group42.Cards;

public abstract class AdventureCard extends Card {

	protected int number;
	
	public int getNum() {
		return number;
	}
	public String toString() {
		return "Adventure Card : " + name + " " + number;
	}
}
