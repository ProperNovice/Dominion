package model;

import controller.Credentials;
import enums.CardNameEnum;
import enums.PileAmountOfCardsEnum;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumberImageView;
import utils.NumberImageView.NumberImageViewColorEnum;
import utils.NumbersPair;
import utils.RearrangeTypeEnum;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView(NumberImageViewColorEnum.BLACK);
	private CardNameEnum cardNameEnum = null;
	private PileAmountOfCardsEnum amountOfCardsEnum = null;

	public Pile(CardNameEnum cardNameEnum, PileAmountOfCardsEnum amountOfCardsEnum) {

		this.cardNameEnum = cardNameEnum;
		this.amountOfCardsEnum = amountOfCardsEnum;

	}

	@Override
	public void createCoordinates() {
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

	public CardNameEnum getCardNameEnum() {
		return this.cardNameEnum;
	}

}
