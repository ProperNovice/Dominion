package model;

import controller.CardManager;
import controller.Credentials;
import enums.CardNameEnum;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.Instances;
import utils.RearrangeTypeEnum;

public class DeckHuman extends ArrayListImageViewAbles<Card> {

	public DeckHuman() {
		
		createStartingDeck();

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(Credentials.CoordinatesDeckHuman)
				.rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();

	}

	private void createStartingDeck() {

		CardManager cardManager = Instances.getControllerInstance().cardManager();

		for (int counter = 1; counter <= 7; counter++)
			super.arrayList.addLast(cardManager.getNewCard(CardNameEnum.COPPER));

		for (int counter = 1; counter <= 3; counter++)
			super.arrayList.addLast(cardManager.getNewCard(CardNameEnum.ESTATE));

		for (Card card : super.arrayList)
			card.flipFaceDown();

		super.arrayList.shuffle();
		super.toFront();

		super.relocateImageViews();

	}

}
