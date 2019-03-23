package model;

import controller.Credentials;
import enums.PlayerEnum;

public class PlayerHuman extends Player {

	public PlayerHuman() {

	}

	@Override
	protected void setCredentials() {

		super.deck = new DeckHuman();
		super.hand = new HandHuman();

		super.deck.relocateList(Credentials.CoordinatesDeckHuman);
		super.discardPile.relocateList(Credentials.CoordinatesDiscardPileHuman);
		super.victoryPointsIndicator = new VictoryPointsIndicator(PlayerEnum.HUMAN, Credentials.CoordinatesScoreHuman);

	}

}
