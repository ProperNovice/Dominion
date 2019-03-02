package gameState;

import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import model.Card;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.Instances;
import utils.NumbersPair;
import utils.RearrangeTypeEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		relocateCards();

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
				super.arrayList.addLast(Instances.getControllerInstance().cardManager().getCardPool(cardNameEnum));

			relocateImageViews();

		}

		@Override
		public void createCoordinates() {

//			NumbersPair numbersPair = new NumbersPair(10, 10);
			NumbersPair numbersPair = new NumbersPair(400, 300);

			super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(numbersPair)
					.dimensionsNumbersPair(Credentials.DimensionsCard)
					.gapNumbersPair(Credentials.DimensionsGapBetweenCards).rearrangeTypeEnum(RearrangeTypeEnum.PIVOT)
					.objectsPerRow(3).create();

		}

	}

}
