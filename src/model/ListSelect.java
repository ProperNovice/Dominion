package model;

import controller.Credentials;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.DirectionEnum;

public class ListSelect extends ArrayListImageViewAbles<Select> {

	public ListSelect() {

	}

	@Override
	protected void createCoordinates() {
		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsSelect)
				.directionEnumVertical(DirectionEnum.UP).objectsPerRow(2).create();
	}

}
