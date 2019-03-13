package model;

import controller.Credentials;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class DeckAI extends Deck {

	public DeckAI() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCardAI)
				.coordinatesNumbersPair(Credentials.CoordinatesDeckAI).rearrangeTypeEnum(RearrangeTypeEnum.STATIC)
				.create();

	}

	@Override
	protected void createStartingDeck() {

		super.createStartingDeck();

		for (Card card : super.arrayList)
			card.getImageView().setWidth(Credentials.DimensionsCardAI.x);

	}

}
