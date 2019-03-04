package gameState;

import enums.GameStateEnum;

public class EndTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.flow().addGameStateResolvingFirst(GameStateEnum.DRAW_STARTING_HAND);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
