package gameState;

import enums.GameStateEnum;

public class EndTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.START_NEW_TURN);

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
