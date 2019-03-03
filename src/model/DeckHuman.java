package model;

import controller.Credentials;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class DeckHuman extends Deck {
	
	public DeckHuman() {

		
	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(Credentials.CoordinatesDeckHuman)
				.rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();

	}

}
