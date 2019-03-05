package gameState;

import model.Card;
import model.Hand;

public class DrawStartingHand extends GameState {

	@Override
	public void handleGameStateChange() {

		Hand hand = super.controller.players().getCurrentPlayer().getHand();

		int amount = -1;

//		amount = super.controller.players().getCurrentPlayer().getDeck().getArrayList().size();
		amount = 5;

		for (int counter = 1; counter <= amount; counter++) {

			Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
			card.flipFaceUp();

			hand.addCardAndAnimatePiles(card);

		}

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
