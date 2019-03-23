package gameStateCardAbilities;

import gameState.GameStateAbstract;

public class PlusOneAction extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {
		
		super.controller.actionBuyTreasureIndicators().addOneAction();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
