package gameState;

import enums.GameStateEnum;

public abstract class DrawStartingHandAbstract extends GameState {

	@Override
	public void handleGameStateChange() {

		int amount = 5;

		for (int counter = 1; counter <= amount; counter++)
			super.controller.flow().addGameStateResolvingFirst(getDrawCardEnum());

		super.controller.flow().proceedToNextGameStatePhase();

	}

	protected abstract GameStateEnum getDrawCardEnum();

}
