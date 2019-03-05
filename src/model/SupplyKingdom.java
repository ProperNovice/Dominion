package model;

import utils.ArrayList;
import utils.Coordinates;

public abstract class SupplyKingdom {

	private ArrayList<Pile> list = new ArrayList<>();
	protected Coordinates coordinates = null;

	public SupplyKingdom() {

		createCoordinates();

	}

	protected abstract void createCoordinates();

	public void setPileListAndRelocate(ArrayList<Pile> list) {

		this.list = list;

		for (Pile pile : this.list) {

			pile.relocateList(this.coordinates.getCoordinateIndex(this.list.indexOf(pile)));
			pile.relocateImageViews();

		}

	}

}
