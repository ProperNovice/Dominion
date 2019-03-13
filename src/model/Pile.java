package model;

import controller.Credentials;
import enums.ObjectPoolEnum;
import enums.PileAmountOfCardsEnum;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumberImageView;
import utils.NumberImageView.NumberImageViewColorEnum;
import utils.NumbersPair;
import utils.ObjectPoolSingleton;
import utils.RearrangeTypeEnum;

public class Pile extends ArrayListImageViewAbles<Card> {

	private NumberImageView numberImageView = new NumberImageView(1, NumberImageViewColorEnum.BLACK);
	private PileAmountOfCardsEnum amountOfCardsEnum = null;
	private ListSelect listSelect = new ListSelect();

	public Pile(PileAmountOfCardsEnum amountOfCardsEnum) {
		this.amountOfCardsEnum = amountOfCardsEnum;
		this.numberImageView.getImageView().setVisible(false);
	}

	@Override
	protected void createCoordinates() {
		super.coordinates = new CoordinatesBuilder().rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();
	}

	@Override
	public void relocateList(NumbersPair numbersPair) {

		super.relocateList(numbersPair);
		this.numberImageView.getImageView()
				.relocate(numbersPair.x + Credentials.DimensionsCard.x - Credentials.numberImageView, numbersPair.y);

		double x = numbersPair.x;
		double y = numbersPair.y + Credentials.DimensionsCard.y - Credentials.DimensionsSelect.y;

		this.listSelect.relocateList(x, y);

	}

	@Override
	public void toFront() {

		super.toFront();
		this.numberImageView.getImageView().toFront();
		this.listSelect.toFront();

	}

	public void updateNumberImageView() {

		if (this.amountOfCardsEnum == PileAmountOfCardsEnum.INFINITE)
			this.numberImageView.setInfinity();

		else if (super.arrayList.size() > 0)
			this.numberImageView.setNumber(super.arrayList.size());

		else
			this.numberImageView.getImageView().setVisible(false);

	}

	public PileAmountOfCardsEnum getPileAmountOfCardsEnum() {
		return this.amountOfCardsEnum;
	}

	public boolean canBeSelected() {

		int totalCards = this.getArrayList().size();
		int totalSelects = this.listSelect.getArrayList().size();

		return totalCards > totalSelects;

	}

	public void selectOne() {

		Select select = (Select) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.SELECT);
		select.getImageView().setVisible(true);

		this.listSelect.getArrayList().addLast(select);

		this.listSelect.relocateImageViews();

	}

	public void diselectOne() {

		Select select = this.listSelect.getArrayList().removeLast();
		select.getImageView().setVisible(false);

		ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.SELECT, select);

	}

	public void diselectAll() {

		while (this.listSelect.getSize() > 0)
			diselectOne();

	}

	public boolean isSelected() {
		return this.listSelect.getSize() > 0;
	}

	public int getSelectedAmount() {
		return this.listSelect.getSize();
	}

}
