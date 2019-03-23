package gameStateCardAbilities;

import gameState.GameStateAbstract;

public class PlusOneCoin extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {
		
		super.controller.actionBuyTreasureIndicators().addOneCoin();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
