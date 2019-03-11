package gameState;

public class CleanUpPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().removeAllCoinsSetVisibleFalse();

	}

}
