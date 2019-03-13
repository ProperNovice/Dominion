package controller;

import model.SupplyKingdom;
import utils.CoordinatesBuilder;

public class Kingdom extends SupplyKingdom {

	public Kingdom() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCardHuman)
				.coordinatesNumbersPair(Credentials.CoordinatesKingdom)
				.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(5).create();

	}

}
