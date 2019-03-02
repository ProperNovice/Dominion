package controller;

import enums.GameStateEnum;
import utils.ArrayList;
import utils.Instances;

public class Flow {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public Flow() {

	}

	public void proceedToNextGameStatePhase() {

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		this.controller.gameState().setGameState(gameStateEnum);

	}

	public void addGameStateResolvingFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

	public void addGameStateResolvingFirst(GameStateEnum... gameStateEnum) {

		ArrayList<GameStateEnum> gameStateEnumTempList = new ArrayList<>(gameStateEnum);
		gameStateEnumTempList.reverse();

		for (GameStateEnum gameStateTemp : gameStateEnumTempList)
			this.gameStateResolving.addFirst(gameStateTemp);

	}

	public void addGameStateResolvingLast(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addLast(gameStateEnum);
	}

}
