package model;

import controller.Credentials;

public class PlayerAI extends Player {

	public PlayerAI() {

	}

	@Override
	protected void setCoordinates() {

		super.deck = new DeckAI();
		super.hand = new HandAI();

		super.deck.relocateList(Credentials.CoordinatesDeckAI);
		super.discardPile.relocateList(Credentials.CoordinatesDiscardPileAI);

	}

}
