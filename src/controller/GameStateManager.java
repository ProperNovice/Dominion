package controller;

import enums.GameStateEnum;
import gameState.GameState;
import utils.Logger;

public class GameStateManager {

	private GameState currentGameState = null;

	public GameStateManager() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		this.currentGameState = gameStateEnum.getGameState();

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum);

		this.currentGameState.handleGameStateChange();

	}

	public GameState getCurrentGameState() {
		return this.currentGameState;
	}

}
