package gameState;

import enums.GameStateEnum;
import enums.TextEnum;

public class EndTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.END_TURN);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.NEW_TURN);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
