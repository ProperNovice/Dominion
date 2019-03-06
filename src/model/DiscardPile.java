package model;

import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.RearrangeTypeEnum;

public class DiscardPile extends ArrayListImageViewAbles<Card> {

	public DiscardPile() {

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().rearrangeTypeEnum(RearrangeTypeEnum.STATIC).create();

	}

	public void testSetDeck(ArrayList<Card> deck) {

		for (Card card : super.arrayList)
			card.getImageView().setVisible(false);

		super.arrayList.clear();
		super.arrayList.addAll(deck);

		super.toFront();

	}

}
