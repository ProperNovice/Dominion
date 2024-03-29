package model;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import utils.ArrayListImageViewAbles;

public abstract class Deck extends ArrayListImageViewAbles<Card> {

	public Deck() {
		createStartingDeck();
	}

	protected void createStartingDeck() {

		for (int counter = 1; counter <= 7; counter++)
			super.arrayList.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));

		for (int counter = 1; counter <= 3; counter++)
			super.arrayList.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.ESTATE));

		for (Card card : super.arrayList)
			card.flipFaceDown();

		super.arrayList.shuffle();
		super.toFront();

	}

}
