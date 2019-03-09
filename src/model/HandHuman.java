package model;

import controller.Credentials;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class HandHuman extends Hand {

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCard)
				.coordinatesNumbersPair(Credentials.CoordinatesHandHuman)
				.gapNumbersPair(Credentials.DimensionsGapBetweenCards).rearrangeTypeEnum(RearrangeTypeEnum.PIVOT)
				.list(this).create();

	}

}
