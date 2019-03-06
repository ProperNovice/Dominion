package gameStateCardAbilities;

import gameState.GameState;
import model.Card;
import utils.ArrayList;
import utils.Lock;

public class PlusOneCard extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.controller.players().getCurrentPlayer().getDeck().getArrayList().isEmpty())
			shuffleDiscardPileToDeck();

		Card card = super.controller.players().getCurrentPlayer().getDeck().getArrayList().removeFirst();
		card.flipFaceUp();

		super.controller.players().getCurrentPlayer().getHand().addCardAndAnimatePiles(card);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void shuffleDiscardPileToDeck() {

		ArrayList<Card> discardPile = super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList()
				.clone();

		super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList().clear();

		for (Card card : discardPile)
			card.flipFaceDown();

		discardPile.shuffle();

		super.controller.players().getCurrentPlayer().getDeck().getArrayList().addAll(discardPile);

		super.controller.players().getCurrentPlayer().getDeck().animateSynchronous();
		Lock.lock();

	}

}
