package gameState;

import controller.Credentials;
import enums.CardNameEnum;
import model.Card;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.Instances;
import utils.NumbersPair;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		relocateCards();

//		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.END_TURN);
//		super.controller.flowManager().addGameStateResolvingFirst(GameStateEnum.CREATE_SUPPLY);
//
//		super.controller.flowManager().proceedToNextGameStatePhase();

	}

	public void relocateCards() {
		new Cards();
	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		public Cards() {

			for (CardNameEnum cardNameEnum : CardNameEnum.values())
				super.arrayList.addLast(Instances.getControllerInstance().cardManager().getCardPool(cardNameEnum));

			relocateImageViews();

		}

		@Override
		public void createCoordinates() {

			NumbersPair numbersPair = new NumbersPair(10, 10);

			super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(numbersPair)
					.dimensionsNumbersPair(Credentials.DimensionsCard)
					.gapNumbersPair(Credentials.DimensionsGapBetweenCards).create();

		}

	}

}
