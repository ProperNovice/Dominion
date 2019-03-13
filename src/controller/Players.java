package controller;

import enums.PlayerEnum;
import model.Player;
import model.PlayerAI;
import model.PlayerHuman;
import utils.HashMap;

public class Players {

	private HashMap<PlayerEnum, Player> players = new HashMap<>();
	private PlayerEnum currentPlayerEnum = PlayerEnum.AI;

	public Players() {
		createHashMap();
	}

	private void createHashMap() {

		this.players.put(PlayerEnum.HUMAN, new PlayerHuman());
		this.players.put(PlayerEnum.AI, new PlayerAI());

	}

	public Player getCurrentPlayer() {
		return this.players.get(this.currentPlayerEnum);
	}

	public PlayerEnum getCurrentPlayerEnum() {
		return this.currentPlayerEnum;
	}

	public Player getOpponent() {

		PlayerEnum playerEnum = null;

		switch (this.currentPlayerEnum) {

		case HUMAN:
			playerEnum = PlayerEnum.AI;
			break;

		case AI:
			playerEnum = PlayerEnum.HUMAN;
			break;

		}

		return this.players.get(playerEnum);

	}

	public void setCurrentPlayerEnum(PlayerEnum playerEnum) {
		this.currentPlayerEnum = playerEnum;
	}

}
