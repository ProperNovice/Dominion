package model;

import controller.Credentials;
import utils.ArrayListImageViewAbles;
import utils.NumberImageView;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView(10);

	public Pile() {

		this.numberImageView.getImageView().setVisible(false);

	}

	@Override
	protected void setValues() {

		super.gapX = Credentials.gapBetweenCards;
		super.gapY = Credentials.gapBetweenCards;
		super.rearrangeType = RearrangeType.STATIC;

	}

	public void relocate(double x, double y) {

		super.relocateArrayList(x, y);
		this.numberImageView.getImageView().relocate(x + Credentials.cardGameWidth - Credentials.number, y);

	}

	@Override
	public void toFront() {
		super.toFront();
		this.numberImageView.getImageView().toFront();
	}

}
