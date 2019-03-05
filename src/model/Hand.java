package model;

import controller.Credentials;
import enums.CardTypeEnum;
import enums.ObjectPoolEnum;
import utils.ArrayList;
import utils.Coordinates;
import utils.Lock;
import utils.NumbersPair;
import utils.ObjectPoolSingleton;

public class Hand {

	private ArrayList<Pile> list = new ArrayList<>();
	private Coordinates coordinates = null;
	private ArrayList<CardTypeEnum> arrangeOrder = new ArrayList<>(CardTypeEnum.values());

	public Hand(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void addCardAndRelocatePiles(Card card) {

		Pile pile = null;

		for (Pile pileTemp : this.list)
			if (pileTemp.getArrayList().getFirst().getCardNameEnum() == card.getCardNameEnum())
				pile = pileTemp;

		if (pile == null) {
			pile = (Pile) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.PILE);
			this.list.addLast(pile);
		}

		pile.getArrayList().addFirst(card);

		rearrangePiles();
		animateSynchronous(card);

	}

	private void rearrangePiles() {

		ArrayList<Pile> listTemp = new ArrayList<>(this.list);
		this.list.clear();

		for (CardTypeEnum cardTypeEnum : this.arrangeOrder)
			for (Pile pile : listTemp.clone())
				if (pile.getArrayList().getFirst().isCardType(cardTypeEnum)) {

					listTemp.remove(pile);
					this.list.addLast(pile);

				}

	}

	private void animateSynchronous(Card card) {

		this.coordinates.calculateFirstObjectCoordinatesPivot(this.list.size());

		for (Pile pile : this.list) {

			NumbersPair numbersPair = this.coordinates.getCoordinateIndex(this.list.indexOf(pile));

			double x = numbersPair.x;
			double y = numbersPair.y - Credentials.DimensionsCard.y - Credentials.DimensionsGapBetweenCards.y;

			if (pile.getArrayList().contains(card))
				card.getImageView().relocate(x, y);

			pile.relocateList(numbersPair);
			pile.animateSynchronous();

		}

		Lock.lock();

		for (Pile pile : this.list)
			pile.updateNumberImageView();

	}

	public ArrayList<Pile> getPiles() {
		return this.list;
	}

	public Pile getPileContainingCard(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				return pile;

		return null;

	}

}
