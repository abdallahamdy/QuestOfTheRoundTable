package com.group42.Cards;

public class Shields {

	private int numShields;
	public Shields() {
		numShields=0;
	}
	
	
	public int getNumShields() {
		return numShields;
	}
	
	
	
	public int increaseShields(int x) { // adds x shields, then returns the total number of shields
		return numShields+x;
	}
}
