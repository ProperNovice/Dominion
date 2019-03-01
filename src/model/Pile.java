package model;

import controller.Credentials;
import enums.CardNameEnum;
import utils.ArrayListImageViewAbles;
import utils.NumberImageView;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView();
	private CardNameEnum cardNameEnum = null;

	public Pile() {

	}

	@Override
	public void createCoordinates() {

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

	public void setCardNameEnumContaining(CardNameEnum cardNameEnum) {
		this.cardNameEnum = cardNameEnum;
	}

}
