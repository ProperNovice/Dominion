package gameState;

import controller.CardManagerSingleton;
import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import model.Card;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumbersPair;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		presentCards();
		setDeck();

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.END_TURN);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void setDeck() {

		ArrayList<Card> deck = new ArrayList<>();

		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CELLAR));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CHAPEL));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.DUCHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CHAPEL));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CHAPEL));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CELLAR));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CELLAR));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.ESTATE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GARDENS));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CURSE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));

		super.controller.players().getCurrentPlayer().getDeck().testSetDeck(deck);
		super.controller.players().getCurrentPlayer().getDeck().relocateImageViews();

	}

	public void presentCards() {

		new Cards();

	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		public Cards() {

			for (CardNameEnum cardNameEnum : CardNameEnum.values())
				super.arrayList.addLast(CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum));

			relocateImageViews();

		}

		@Override
		public void createCoordinates() {

			NumbersPair numbersPair = new NumbersPair(Credentials.gapBetweenBorders, Credentials.gapBetweenBorders);

			super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(numbersPair)
					.dimensionsNumbersPair(Credentials.DimensionsCard)
					.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(14).create();

		}

	}

}
