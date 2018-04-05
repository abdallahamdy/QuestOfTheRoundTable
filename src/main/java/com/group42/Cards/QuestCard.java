package com.group42.Cards;
import java.io.File;
import java.util.ArrayList;

public class QuestCard extends StoryCard{

	private int numStages;
	private String questName;
	private String specialFoe;
	
	public QuestCard(int newNum, String newName, String specFoe, String imgFile) {
		numStages = newNum;
		questName = newName;
		faceUp = imgFile;
		specialFoe = specFoe;
	}
	

	
	
	public int getNumStages() {
		return numStages;
	}
	
	//TODO: setup getter for special foe
	public String getSpecFoe() {
		return specialFoe;
	}
	
	public String getLocation() {
		return faceUp;
	}
	
	public String getName() {
		return questName;
	}
	
	public String toString() {
		return "Quest Card : " + questName + " FIX THIS";
	}
}
