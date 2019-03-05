package gameState;

import enums.GameStateEnum;

public class StartNewTurn extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuy().showActionBuyOneEach();
		
		super.controller.flow().addGameStateResolvingFirst(GameStateEnum.START_NEW_PHASE);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
