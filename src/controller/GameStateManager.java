package controller;

import enums.GameStateEnum;
import gameState.GameStateAbstract;
import utils.Logger;

public class GameStateManager {

	private GameStateAbstract currentGameState = null;

	public GameStateManager() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		this.currentGameState = gameStateEnum.getGameState();

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum);

		this.currentGameState.handleGameStateChange();

	}

	public GameStateAbstract getCurrentGameState() {
		return this.currentGameState;
	}

}
