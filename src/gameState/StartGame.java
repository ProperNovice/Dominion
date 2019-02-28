package gameState;

import controller.Credentials;
import enums.CardNameEnum;
import model.Card;
import utils.ArrayListImageViewAbles;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		testRelocateCards();

	}

	public void testRelocateCards() {

		Cards cards = new Cards();

		for (CardNameEnum cardNameEnum : CardNameEnum.values())
			cards.getArrayList().addLast(super.controller.cardManager().getCard(cardNameEnum));

		cards.relocate();

	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		@Override
		protected void setValues() {

			super.x = Credentials.gapBetweenBorders;
			super.y = Credentials.gapBetweenBorders;
			super.imageViewsPerRow = 14;
			super.gapX = 5;
			super.gapY = 5;

		}

	}

}
