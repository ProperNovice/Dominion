package controller;

import model.Pile;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;

public class Supply {

	private ArrayList<Pile> list = new ArrayList<>();
	private Coordinates coordinates = null;

	public Supply() {

		this.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCard)
				.coordinatesNumbersPair(Credentials.CoordinatesSupply)
				.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(2).create();

	}

	public void setPileListAndRelocate(ArrayList<Pile> list) {

		this.list = list;

		for (Pile pile : this.list) {

			pile.relocateList(this.coordinates.getCoordinateIndex(this.list.indexOf(pile)));
			pile.relocateImageViews();

		}

	}

}
