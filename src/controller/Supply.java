package controller;

import model.Pile;
import utils.ArrayList;
import utils.Coordinates;

public class Supply {

	private ArrayList<Pile> list = new ArrayList<>();
	private Coordinates coordinates = null;

	public Supply() {

	}

	public void setPileListAndRelocate(ArrayList<Pile> list) {

		this.list = list;

	}

}
