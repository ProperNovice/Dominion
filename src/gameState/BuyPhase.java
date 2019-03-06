package gameState;

import enums.TextEnum;

public class BuyPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.BUY_PHASE);
		super.controller.text().showText(TextEnum.END_TURN);

	}

}
