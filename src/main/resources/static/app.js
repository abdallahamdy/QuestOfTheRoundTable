var websocket;
var numberOfPlayers = 0;

function createWebSocket() {

	websocket = new WebSocket("ws://localhost:8080/game");
	$("#createGameDiv").hide();
	$("#joinGameDiv").hide();
	$("#startGameBtn").hide();
	$("#roomFullDiv").hide();
	$("#boardGameDiv").hide();
	// $("#createUserDiv").hide();

	// websocket.onopen = function(e){
	// console.log("in onopen: " + data);
	// websocket.send(data);
	// }

	websocket.onmessage = function(msg) {
		var parsedMsg = JSON.parse(msg.data);
		console.log("Parsed method is " + parsedMsg.method);
		if (parsedMsg.method == "showWhoJoined") {
			showWhoJoined(parsedMsg.playername);
		}
		if (parsedMsg.method == "activateStartGame") {
			activateStartGame();
		}
		if (parsedMsg.method == "someoneLeft") {
			someoneLeft(parsedMsg);
			numberOfPlayers--;
		}
		if (parsedMsg.method == "hostLeft") {
			hostLeft(parsedMsg);
			numberOfPlayers--;
		}
		if (parsedMsg.method == "showCards") {
			showCards(parsedMsg.cards);
		}
		if (parsedMsg.method == "showCreateGame") {
			showCreateGame();
		}
		if (parsedMsg.method == "showJoinGame") {
			showJoinGame();
		}
		if (parsedMsg.method == "showRoomFull") {
			showRoomFull();
		}
	}
	console.log("in create web socket js");
}

function showCreateGame() {
	$("#createGameDiv").show();
	$("#createGameBtn").hide();
}

function showJoinGame() {
	console.log("show JOIN GAME");
	$("#joinGameDiv").show();
	$("#joinGameBtn").hide();
}

function showRoomFull() {
	$("#roomFullDiv").show();
	$("#roomFullDiv").append("<p>CANT JOIN! ROOM FULL</p>");

}

function gameCreation() {

	var playername = $("#playerNameInput").val();
	var numberOfPlayers = $("#numberOfPlayers").val();
	var numberOfAI = $("#numberOfAI").val();

	$("#createGameDiv").empty();
	var data = JSON.stringify({
		'method' : 'gameSettings',
		'playername' : playername,
		'numberOfPlayers' : numberOfPlayers,
		'numberOfAI' : numberOfAI
	});

	websocket.send(data);

}

function joinGame() {
	console.log("inside JOIN GAME");

	var playername = $("#playerNameInput2").val();
	$("#joinGameDiv").empty();
	$("#lobbyDiv").show();

	var data = JSON.stringify({
		'method' : 'createPlayer',
		'playername' : playername
	});

	websocket.send(data);

}

function showCards(cards) {

	$("#mainmenu").empty();
	$("#boardGameDiv").show();
	// $("#responseField").append("<tr><td>" + name + "</td></tr>");
	console.log(cards);
	for (i = 0; i < cards.length; i++) {
		console.log("card is: " + cards[i].name + "location is: " + cards[i].imgLocation);
		$("#cardsDiv").append("<img height='100' width='75' src='" + cards[i].imgLocation + "'>");
	}
	// $("#cards").append("<tr><td> in ShowCards </td></tr>");
}

function startGame() {
	console.log("in start game js");
	var data = JSON.stringify({
		"method" : "startGame"
	})

	websocket.send(data);

}

function showWhoJoined(message) {
	$("#responseField").append(
			"<tr><td>" + message + " just joined the game!" + "</td></tr>");
}

function activateStartGame() {
	console.log("in activate start game");
	$("#startGameBtn").show();
}

function someoneLeft(msg) {
	$("#responseField").append(
			"<tr><td>" + msg.playername + " just left the game.</td></tr>");
}

function hostLeft(msg) {
	$("#responseField").append(
			"<tr><td> the host: " + msg.oldHost
					+ " just left the game.</td></tr>");
	$("#responseField").append(
			"<tr><td>" + msg.newHost + " is the new game owner.</td></tr>");
}

// this is for hiding create game button
$(document).ready(function() {
	$("#playerNameInput").keyup(function(e) {
		if ($(this).val() != '') {
			$("#createGameBtn").show();

		} else {
			$("#createGameBtn").hide();

		}
	});
});

$(document).ready(function() {
	$("#playerNameInput2").keyup(function(e) {
		if ($(this).val() != '') {
			$("#joinGameBtn").show();

		} else {
			$("#joinGameBtn").hide();

		}
	});
});
