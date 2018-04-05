package com.group42.EventCardBehaviors;

import java.util.ArrayList;

import com.group42.Cards.Board;
import com.group42.model.Player;

public abstract interface EventBehavior {

	public void applyBehavior(Player drawnPlayer, ArrayList<Player> Players, Board board);
}
