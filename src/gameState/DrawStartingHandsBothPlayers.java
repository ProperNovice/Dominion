package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class DrawStartingHandsBothPlayers extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.DRAW_STARTING_HANDS);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		super.controller.actionBuyTreasureIndicators().setUpAndShowNewRoundIndicators();

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND_CURRENT_PLAYER);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND_OPPONENT_PLAYER);

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
