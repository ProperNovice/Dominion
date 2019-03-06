package gameState;

import model.Card;

public class DrawStartingHand extends GameState {

	@Override
	public void handleGameStateChange() {

		int amount = -1;

//		amount = super.controller.players().getCurrentPlayer().getDeck().getArrayList().size();
		amount = 5;

		for (int counter = 1; counter <= amount; counter++) {

			Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
			card.flipFaceUp();

			super.controller.players().getCurrentPlayer().getHand().addCardAndAnimatePiles(card);

		}

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
