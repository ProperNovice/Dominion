package controller;

import enums.PlayerEnum;
import model.Player;
import model.PlayerAI;
import model.PlayerHuman;
import utils.HashMap;

public class Players {

	private HashMap<PlayerEnum, Player> players = new HashMap<>();
	private PlayerEnum currentPlayerEnum = PlayerEnum.HUMAN;

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

	public Player getOpponent() {

		switch (this.currentPlayerEnum) {

		case HUMAN:
			return this.players.get(PlayerEnum.AI);

		case AI:
			return this.players.get(PlayerEnum.HUMAN);

		}

		return null;

	}

}
