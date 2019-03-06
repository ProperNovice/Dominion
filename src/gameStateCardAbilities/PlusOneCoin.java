package gameStateCardAbilities;

import gameState.GameState;

public class PlusOneCoin extends GameState {

	@Override
	public void handleGameStateChange() {
		
		super.controller.actionBuyTreasureIndicators().addOneCoin();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
