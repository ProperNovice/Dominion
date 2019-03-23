package gameStateCardAbilities;

import gameState.GameStateAbstract;

public class PlusOneBuy extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().addOneBuy();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
