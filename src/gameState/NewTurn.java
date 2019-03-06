package gameState;

import enums.GameStateEnum;

public class NewTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().showActionBuyOneEach();
		
		super.controller.flow().addGameStateResolvingFirst(GameStateEnum.NEW_PHASE);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
