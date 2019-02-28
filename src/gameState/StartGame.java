package gameState;

import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import model.Card;
import utils.ArrayListImageViewAbles;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		relocateCards();

		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.END_TURN);
		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CREATE_SUPPLY);

		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void relocateCards() {

		Cards cards = new Cards();

		for (CardNameEnum cardNameEnum : CardNameEnum.values())
			cards.getArrayList().addLast(super.controller.cardManager().getCardPool(cardNameEnum));

		cards.relocateImageViews();

	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		@Override
		protected void setValues() {

			super.x = Credentials.gapBetweenBorders;
			super.y = Credentials.gapBetweenBorders;
			super.imageViewsPerRow = 12;
			super.gapX = 5;
			super.gapY = 5;

		}

	}

}
