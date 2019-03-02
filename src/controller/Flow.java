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

	public void addGameStateResolvingLast(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addLast(gameStateEnum);
	}

}
