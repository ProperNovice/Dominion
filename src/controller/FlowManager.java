package controller;

import enums.GameStateEnum;
import utils.ArrayList;
import utils.Instances;

public class FlowManager {

	private Controller controller = Instances.getControllerInstance();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public FlowManager() {

	}

	public void proceedToNextGameStatePhase() {

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		this.controller.gameStateManager().setGameState(gameStateEnum);

	}

	public void addGameStateResolvingFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

}
