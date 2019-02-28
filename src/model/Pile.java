package model;

import controller.Credentials;
import utils.ArrayListImageViewAbles;
import utils.NumberImageView;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = null;

	public Pile() {

	}

	@Override
	protected void setValues() {

		this.numberImageView = new NumberImageView();

		super.gapX = Credentials.gapBetweenCards;
		super.gapY = Credentials.gapBetweenCards;
		super.rearrangeType = RearrangeType.STATIC;
		this.numberImageView.setNumber(15);

	}

}
