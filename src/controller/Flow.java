package controller;

import enums.GameStateEnum;
import utils.ArrayList;
import utils.Instances;
import utils.Logger;

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

	public void addGameStateResolvingFirst(ArrayList<GameStateEnum> gameStateEnumList) {

		gameStateEnumList.reverse();

		for (GameStateEnum gameStateTemp : gameStateEnumList)
			this.gameStateResolving.addFirst(gameStateTemp);

	}

	public void addGameStateResolvingLast(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addLast(gameStateEnum);
	}

	public void print() {

		Logger.log("flow");
		this.gameStateResolving.printList();
	}

}
