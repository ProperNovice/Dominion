package gameState;

import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import model.Card;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.Instances;
import utils.NumbersPair;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		relocateCards();
//		runTests();

	}

	public void runTests() {

		createDeckHuman();

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.END_TURN);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void relocateCards() {
		new Cards();
	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		public Cards() {

			for (CardNameEnum cardNameEnum : CardNameEnum.values())
				super.arrayList.addLast(Instances.getControllerInstance().cardManager().getNewCard(cardNameEnum));

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

	public void createDeckHuman() {

		for (int counter = 1; counter <= 7; counter++)
			super.controller.deckHuman().getArrayList()
					.addLast(super.controller.cardManager().getNewCard(CardNameEnum.COPPER));

		for (int counter = 1; counter <= 3; counter++)
			super.controller.deckHuman().getArrayList()
					.addLast(super.controller.cardManager().getNewCard(CardNameEnum.ESTATE));

//		for (Card card : super.controller.deckHuman().getArrayList())
//			card.flipFaceDown();

		super.controller.deckHuman().getArrayList().shuffle();
		super.controller.deckHuman().toFront();

		super.controller.deckHuman().relocateImageViews();

	}

}
