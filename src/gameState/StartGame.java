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
//		setDeck();

		flow();

	}

	public void flow() {

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_KINGDOM);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.END_TURN);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void setDeck() {

		ArrayList<Card> deck = new ArrayList<>();

		ArrayList<CardNameEnum> cardNameEnumList = new ArrayList<CardNameEnum>(CardNameEnum.values());
		while (cardNameEnumList.size() > 8)
			cardNameEnumList.removeRandom();

		for (int counter = 1; counter <= 15; counter++)
			deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(cardNameEnumList.getRandom()));

		deck.shuffle();

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
