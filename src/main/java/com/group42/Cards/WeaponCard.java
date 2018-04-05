package com.group42.Cards;

import java.io.File;

public class WeaponCard extends AdventureCard{
	
	public WeaponCard(int newNum, String newName, String imgFile) {
		number = newNum;
		name = newName;
		faceUp = imgFile;
	}
	
	public String toString() {
		return "Weapon Card : " + name + " " + number;
	}
	
	public int getNumber() {
		return number;
	}
}
