package model;

import controller.Credentials;
import enums.PileAmountOfCardsEnum;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumberImageView;
import utils.NumberImageView.NumberImageViewColorEnum;
import utils.NumbersPair;
import utils.RearrangeTypeEnum;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView(NumberImageViewColorEnum.BLACK);
	private PileAmountOfCardsEnum amountOfCardsEnum = null;

	public Pile(PileAmountOfCardsEnum amountOfCardsEnum) {

		this.amountOfCardsEnum = amountOfCardsEnum;

	}

	@Override
	protected void createCoordinates() {
		super.coordinates = new CoordinatesBuilder().rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();
	}

	@Override
	public void relocateArrayList(NumbersPair numbersPair) {

		super.relocateArrayList(numbersPair);
		this.numberImageView.getImageView()
				.relocate(numbersPair.x + Credentials.DimensionsCard.x - Credentials.numberImageView, numbersPair.y);

	}

	@Override
	public void toFront() {

		super.toFront();
		this.numberImageView.getImageView().toFront();

	}

	public void updateNumberImageView() {

		if (this.amountOfCardsEnum == PileAmountOfCardsEnum.INFINITE)
			this.numberImageView.setInfinity();
		else
			this.numberImageView.setNumber(super.arrayList.size());
	}

}
