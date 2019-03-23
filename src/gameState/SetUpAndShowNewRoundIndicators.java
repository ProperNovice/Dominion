package gameState;

public class SetUpAndShowNewRoundIndicators extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().setUpAndShowNewRoundIndicators();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
