package gameState;

import enums.GameStateEnum;

public class DrawStartingHand extends GameState {

	@Override
	public void handleGameStateChange() {

		int amount = -1;

		amount = 5;
//		amount = super.controller.players().getCurrentPlayer().getDeck().getArrayList().size();

//		for (int counter = 1; counter <= amount; counter++) {
//
//			Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
//			card.flipFaceUp();
//
//			super.controller.players().getCurrentPlayer().getHand().addCardAndAnimatePiles(card);
//
//		}

		for (int counter = 1; counter <= amount; counter++)
			super.controller.flow().addGameStateResolvingFirst(GameStateEnum.PLUS_ONE_CARD);

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
