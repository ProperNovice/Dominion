package model;

import controller.Credentials;
import enums.CardNameEnum;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumberImageView;
import utils.NumberImageView.NumberImageViewColorEnum;
import utils.RearrangeTypeEnum;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView(NumberImageViewColorEnum.BLACK);
	private CardNameEnum cardNameEnum = null;

	public Pile(CardNameEnum cardNameEnum) {
		this.cardNameEnum = cardNameEnum;
	}

	@Override
	public void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();

	}

	@Override
	public void relocateArrayList(double x, double y) {

		super.relocateArrayList(x, y);
		this.numberImageView.getImageView().relocate(x + Credentials.DimensionsCard.x - Credentials.number, y);

	}

	@Override
	protected void toFront() {

		super.toFront();
		this.numberImageView.getImageView().toFront();

	}

	public void updateNumberImageView() {
		this.numberImageView.setNumber(super.arrayList.size());
	}

}
