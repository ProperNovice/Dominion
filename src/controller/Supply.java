package controller;

import model.SupplyKingdom;
import utils.CoordinatesBuilder;

public class Supply extends SupplyKingdom {

	public Supply() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCardHuman)
				.coordinatesNumbersPair(Credentials.CoordinatesSupply)
				.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(2).create();

	}

}
