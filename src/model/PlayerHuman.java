package model;

import controller.Credentials;

public class PlayerHuman extends Player {

	public PlayerHuman() {

	}

	@Override
	protected void setCoordinates() {

		super.deck.relocateList(Credentials.CoordinatesDeckHuman);
		super.discardPile.relocateList(Credentials.CoordinatesDiscardPileHuman);
		super.handCoordinates = Credentials.CoordinatesHandHuman;

	}

}
