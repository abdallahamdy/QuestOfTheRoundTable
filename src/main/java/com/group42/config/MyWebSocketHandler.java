package com.group42.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.group42.Cards.Board;
import com.group42.Cards.Card;
import com.group42.model.Player;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> webSocketSessions = new CopyOnWriteArrayList<WebSocketSession>();
    ArrayList<Player> playerArrayList = new ArrayList<Player>();
    WebSocketSession hostSession;
    List<WebSocketSession> clientSessions = new CopyOnWriteArrayList<WebSocketSession>();

    public Board decks = new Board();
    int maxCards=12;



    public static final String METHOD_KEY = "method";
    public static final String NOFAI_KEY = "numberOfAI";
    public static final String NOFPLAYERS_KEY = "numberOfPlayers";
    public static final String PLAYERNAME_KEY = "playername";

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        System.out.println("in after connection established11111");
        JsonObject response = new JsonObject();

        if(playerArrayList.size() < 1){
            System.out.println("in after connection established isempty");
            response.addProperty("method","showCreateGame");

        } else if (playerArrayList.size() < 4){
            System.out.println("in after connection established < 4 > 1");
            response.addProperty("method", "showJoinGame");

        }
        System.out.println("playerArrayLITS size = " + playerArrayList.size());
        if(playerArrayList.size() == 4){
            System.out.println("playerArrayLITS if statement size = " + playerArrayList.size());
            response.addProperty("method", "showRoomFull");
        }
        System.out.println("qqqresponse = " + response.toString());
        webSocketSession.sendMessage(new TextMessage(response.toString()));

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

        JsonObject response = new JsonObject();


//        for(Player currentPlayer : playerArrayList){
//            if(currentPlayer.getSession() == webSocketSession){
//                if(currentPlayer.isHost() && !(playerArrayList.isEmpty())){
//
//                }
//                playerArrayList.remove(currentPlayer);
//            }
//        }


//        if(!(playerArrayList.isEmpty())){
//            for(Player currentPlayer : playerArrayList){
//                if(currentPlayer.getSession() == webSocketSession){
//                    if(currentPlayer.isHost()){
//
//                    }
//                    playerArrayList.remove(currentPlayer);
//                }
//            }
//        }


//        System.out.println("Player ArrayList size is " + playerArrayList.size());
//        for(Player currentPlayer : playerArrayList){
//            System.out.println("in for loop current player is:  " + currentPlayer.getName());
//            if(currentPlayer.getSession() == webSocketSession){
//
//                Player playerLeaving = currentPlayer;
//
//                playerArrayList.remove(currentPlayer);
//
//                if(playerLeaving.isHost() == true && playerArrayList.isEmpty() == false){
//
//                    playerArrayList.get(0).setHost(true);
//                    response.addProperty("method", "hostLeft");
//                    response.addProperty("oldHost", playerLeaving.getName());
//                    response.addProperty("newHost", playerArrayList.get(0).getName());
//
//                } else {
//
//                    response.addProperty("method", "someoneLeft");
//                    response.addProperty("playername", playerLeaving.getName());
//
//                }
//            }
//        }

        for(Player p : playerArrayList){
            if(p.getSession() == webSocketSession){
                p.getSession().sendMessage(new TextMessage(response.toString()));
                playerArrayList.remove(p);
            }
        }

    }

    @Override
    public void handleTextMessage(WebSocketSession webSocketSession, TextMessage webTextMessage) throws Exception {

        Map<String, String> value = new Gson().fromJson(webTextMessage.getPayload(), Map.class);

        String methodName = value.get(METHOD_KEY);
        System.out.println("method NAme: " + methodName);


        if(methodName.equals("createPlayer")){
//            createPlayer(value.get(PLAYERNAME_KEY), webSocketSession);
            createPlayer(value, webSocketSession);
        } else if(methodName.equals("startGame")){
            startGame();
        }

//        switch(methodName){
//            case "createPlayer":
//                createPlayer(value.get(PLAYERNAME_KEY), webSocketSession);
////                for(Player playerSession : playerArrayList){
//////                    playerSession.sendMessage(new TextMessage(response));
////                }
//                break;
//            case "dealCards":
//                dealCards();
//                break;
//            default: System.out.println("do nothing");
//        }

    }


    public void createPlayer(Map value, WebSocketSession webSession) throws Exception {
        System.out.println("in create player");

//        int nOfPlayers = Integer.parseInt(value.get(NOFPLAYERS_KEY).toString());
//        int nOFAI = Integer.parseInt(value.get(NOFAI_KEY).toString());



        Player player = new Player(value.get(PLAYERNAME_KEY).toString());

        if(playerArrayList.isEmpty()){
            player.setSession(webSession);
            player.setHost(true);
            playerArrayList.add(player);
        } else {
            player.setSession(webSession);
            player.setHost(false);
            playerArrayList.add(player);
        }

        JsonObject response = new JsonObject();

        response.addProperty("method", "showWhoJoined");
        response.addProperty("playername",player.getName());
        response.addProperty("ishost:", player.isHost().toString());

        for(Player currentPlayer : playerArrayList){
            currentPlayer.getSession().sendMessage(new TextMessage(response.toString()));
        }

        if(playerArrayList.size() == 4){
            for(Player currentPlayer : playerArrayList){
                if(currentPlayer.isHost()){
                    System.out.println("before sending activate start game");
                    JsonObject hostresponse = new JsonObject();
                    hostresponse.addProperty("method", "activateStartGame");
                    currentPlayer.getSession().sendMessage(new TextMessage(hostresponse.toString()));
                }
            }
        }

        System.out.println("Player " + player.getName() + "has connected!");
    }


    public void startGame() throws Exception{
    	
    	//first deal cards
    	dealCards();
    	
    	//then we need to start game and turns 
        



    }
    
    public void dealCards() throws Exception{
    	JsonObject response = new JsonObject();

        //for loop and create a new json object for each card, end of each iteration push to array
        //after for loop is done send body with jsonarray of cards into response
        System.out.println("Start Game function");
        for (int i = 0; i < playerArrayList.size(); i++) {

            JsonArray cards = new JsonArray();

            for (int j = 0; j < maxCards; j++) {
                Card currentCard = decks.getAdventureDeck().popCard();
                playerArrayList.get(i).addHand(currentCard);

                JsonObject card = new JsonObject();
                card.addProperty("name", currentCard.getName());
                card.addProperty("imgLocation", currentCard.getFaceUp());
                cards.add(card);

            }

            response.addProperty("method", "showCards");
            response.add("cards", cards);
            playerArrayList.get(i).getSession().sendMessage(new TextMessage(response.toString()));

        }

        for (int i = 0; i < playerArrayList.size(); i++) {
            System.out.println(playerArrayList.get(i) + " number of cards is: " + playerArrayList.get(i).getHandSize());
//            playerArrayList.get(i).getSession().sendMessage(new TextMessage(response.toString()));
        }
    }



}
