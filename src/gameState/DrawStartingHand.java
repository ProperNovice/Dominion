package gameState;

import model.Card;
import model.Hand;

public class DrawStartingHand extends GameState {

	@Override
	public void handleGameStateChange() {

		Hand hand = super.controller.players().getCurrentPlayer().getHand();

//		int deckSize = super.controller.players().getCurrentPlayer().getDeck().getArrayList().size();

		for (int counter = 1; counter <= 5; counter++) {

			Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
			card.flipFaceUp();

			hand.addCardAndRelocatePiles(card);

		}

//		super.controller.flow().proceedToNextGameStatePhase();

	}

}
