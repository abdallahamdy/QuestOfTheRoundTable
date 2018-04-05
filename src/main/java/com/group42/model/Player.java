package com.group42.model;

import com.group42.Cards.Card;
import com.group42.Cards.Deck;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;

public class Player {

    private String player_name;
    private WebSocketSession webSocketSession;
    private Boolean host;
    protected Deck Hand = new Deck();
    protected Deck playedHand = new Deck(); // played cards are displayed here, such as Allies
    protected int NumOfHCards = 0;
    protected int rankNum = 1; // 1 for Squire, 2 for Knight, 3 for Champion Knight, * 4 if knight of the round table
    protected int NumOfShields = 0;
    //	protected ArrayList<Player> allPlayers = new ArrayList<Player>();
    public ArrayList<Card> cardsPicked = new ArrayList<Card>();
    public ArrayList<ArrayList <Card>> cardsForStages = new ArrayList<ArrayList<Card>>();
    //Array of shield objects

    protected int numShields;

    public Player(String name) {
        this.player_name = name;
        NumOfHCards = Hand.getNumCards();
    }


    public Player() {

        NumOfHCards = Hand.getNumCards();
    }
    public Player(Deck _Hand){
        Hand = _Hand;
        NumOfHCards = Hand.getNumCards();
    }
    public Deck getHand() {
        return Hand;
    }

    public Deck getPlayedCards() {
        return playedHand;
    }

    public int getRankNum() {
        return rankNum;
    }


    public String getRank() {
        System.out.println("current ranknum is: " + rankNum);


        if (rankNum == 2) {
            return "Knight";
        } else if (rankNum == 3) {
            return "Champion Knight";
        } else if (rankNum == 4) {
            return "Knight of the Round Table";
        }

        return "Squire"; //means the player is still rankNum 1
    }
    public void checkRankUp(){
        // This is where rank ups will be checked
        // called in increase shields



        if(rankNum==1 && numShields >=5) {
            rankNum++;
            numShields = (numShields%5);
        }else if(rankNum ==2 && numShields >= 7) {
            rankNum++;
            numShields = (numShields%7);
        }else if(rankNum ==3 && numShields >= 10) {
            rankNum++;
            numShields = (numShields%10);
        }



    }

    public int getHandSize() {
        return Hand.getNumCards();
    }

    public int getNumOfHCards() {
        return NumOfHCards;
    }

    public int getPlayerBP() {

        //A Squire has 5 Battle Points, a Knight has 10 Battle Points and a Champion Knight has 20 Battle Points

        if (rankNum == 2) {
            return 10;
        }else if (rankNum == 3) {
            return 20;
        }
        return 5;
    }

    public void increaseShields(int x) {
        numShields+=x;
        checkRankUp();

    }

    public int getNumOfShields() {
        return numShields;
    }

    public void setHand(Deck _Hand) {
        System.out.println("Hand Set"); // Display the string.

        Hand = _Hand;
    }

    public void addHand(Card XCard) {
        Hand.add(XCard);
    }

//    public void setName(String nameToSet) {
//        player_name = nameToSet;
//    }
//
//    public String getName() {
//        return player_name;
//    }

    public ArrayList<String> PrintHand() {
        //String WholeHand;
        ArrayList<String> WholeHand = new ArrayList<String>();
        for(int i= 0;i<Hand.getNumCards(); i++ ) {
            WholeHand.add(Hand.getCard(i).toString());
        }
        return WholeHand;
    }

    public void addPickCard(Card card) {
        cardsPicked.add(card);
    }

    public void clearPickedCards() {
        cardsPicked.clear();
    }

    public ArrayList<Card> getPickedCards(){
        return cardsPicked;
    }

    public ArrayList<String> getCards() {
        //String WholeHand;
        ArrayList<String> WholeHand = new ArrayList<String>();
        for(int i= 0;i<Hand.getNumCards(); i++ ) {
            WholeHand.add(Hand.getCard(i).getName());
        }
        return WholeHand;
    }

    //***********************************************************************


//    public Player(String name){
//        this.player_name = name;
//        System.out.println("Created player " + this.player_name);
//    }

    public WebSocketSession getSession() {
        return webSocketSession;
    }

    public void setSession(WebSocketSession session){
        webSocketSession = session;
    }

    public Boolean isHost(){
        return host;
    }

    public void setHost(boolean x){
        host = x;
    }

    public String getName(){
        return player_name;
    }


}

