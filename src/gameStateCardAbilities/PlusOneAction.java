package gameStateCardAbilities;

import gameState.GameState;

public class PlusOneAction extends GameState {

	@Override
	public void handleGameStateChange() {
		
		super.controller.actionBuyTreasureIndicators().addOneAction();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
