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

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.END_TURN);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void relocateCards() {

		for (Card card : super.controller.deckHuman().getArrayList())
			card.getImageView().setVisible(false);

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

}
