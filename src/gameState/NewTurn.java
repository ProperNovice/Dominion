package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class NewTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.NEW_TURN);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		super.controller.actionBuyTreasureIndicators().showNewRoundIndicators();
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND);

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
