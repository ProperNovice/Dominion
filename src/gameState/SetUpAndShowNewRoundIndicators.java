package gameState;

public class SetUpAndShowNewRoundIndicators extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().setUpAndShowNewRoundIndicators();
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
