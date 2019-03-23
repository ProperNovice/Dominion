package model;

import controller.Credentials;
import enums.PlayerEnum;

public class PlayerAI extends Player {

	public PlayerAI() {

	}

	@Override
	protected void setCredentials() {

		super.deck = new DeckAI();
		super.hand = new HandAI();

		super.deck.relocateList(Credentials.CoordinatesDeckAI);
		super.discardPile.relocateList(Credentials.CoordinatesDiscardPileAI);
		super.victoryPointsIndicator = new VictoryPointsIndicator(PlayerEnum.AI, Credentials.CoordinatesScoreAI);

	}

}
