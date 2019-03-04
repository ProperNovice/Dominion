package model;

import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class DiscardPile extends ArrayListImageViewAbles<Card> {

	public DiscardPile() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();

	}

}
