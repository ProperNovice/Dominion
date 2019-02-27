package gameState;

import enums.CardNameEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		testCard();

	}

	public void testCard() {

		super.controller.cardManager().getCard(CardNameEnum.CURSE);

	}

}
