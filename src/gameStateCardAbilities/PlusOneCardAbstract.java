package gameStateCardAbilities;

import gameState.GameStateAbstract;
import model.Card;
import model.Player;
import utils.ArrayList;
import utils.Lock;

public abstract class PlusOneCardAbstract extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		if (getPlayer().getDeck().getArrayList().isEmpty())
			if (!getPlayer().getDiscardPile().getArrayList().isEmpty())
				shuffleDiscardPileToDeck();

		if (!getPlayer().getDeck().getArrayList().isEmpty())
			drawCard();

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void drawCard() {

		Card card = getPlayer().getDeck().getArrayList().removeFirst();
		card.flipFaceUp();

		getPlayer().getHand().addCardAndAnimatePiles(card);

	}

	private void shuffleDiscardPileToDeck() {

		ArrayList<Card> discardPile = getPlayer().getDiscardPile().getArrayList().clone();

		getPlayer().getDiscardPile().getArrayList().clear();

		for (Card card : discardPile)
			card.flipFaceDown();

		discardPile.shuffle();

		getPlayer().getDeck().getArrayList().addAll(discardPile);

		getPlayer().getDeck().animateSynchronous();
		Lock.lock();

	}

	protected abstract Player getPlayer();

}
