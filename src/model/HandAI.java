package model;

import controller.Credentials;
import utils.CoordinatesBuilder;
import utils.DirectionEnum;

public class HandAI extends Hand {

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCardAI)
				.coordinatesNumbersPair(Credentials.CoordinatesHandAI)
				.gapNumbersPair(Credentials.DimensionsGapBetweenCards).directionEnumHorizontal(DirectionEnum.LEFT)
				.objectsPerRow(4).list(this).create();

	}

}
