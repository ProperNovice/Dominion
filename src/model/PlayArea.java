package model;

import controller.Credentials;
import controller.SizeAble;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class PlayArea extends ArrayListImageViewAbles<Card> implements SizeAble {

	public PlayArea() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCard)
				.coordinatesNumbersPair(Credentials.CoordinatesPlayArea).rearrangeTypeEnum(RearrangeTypeEnum.PIVOT)
				.gapX(-0.6 * Credentials.DimensionsCard.x).list(this).create();

	}

	@Override
	public int getSize() {
		return this.arrayList.size();
	}

}
