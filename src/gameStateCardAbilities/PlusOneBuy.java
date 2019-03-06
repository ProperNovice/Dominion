package gameStateCardAbilities;

import gameState.GameState;

public class PlusOneBuy extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().addOneBuy();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
