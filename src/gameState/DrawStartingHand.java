package gameState;

import controller.Credentials;
import model.Card;
import model.Hand;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.Lock;

public class DrawStartingHand extends GameState {

	@Override
	public void handleGameStateChange() {

		Hand hand = super.controller.players().getCurrentPlayer().getHand();

		int deckSize = super.controller.players().getCurrentPlayer().getDeck().getArrayList().size();

		for (int counter = 1; counter <= deckSize; counter++) {

			Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
			card.flipFaceUp();

			Animation.INSTANCE.animate(card.getImageView(), Credentials.CoordinatesCardDrawHuman,
					AnimationSynch.SYNCHRONOUS);
			Lock.lock();

			hand.addCardAndRelocatePiles(card);

		}

	}

}
