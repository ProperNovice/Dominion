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

	public void addCardAndAnimatePiles(Card card) {

		Pile pile = null;

		for (Pile pileTemp : this.list)
			if (pileTemp.getArrayList().getFirst().getCardNameEnum() == card.getCardNameEnum())
				pile = pileTemp;

		if (pile == null) {
			pile = (Pile) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.PILE);
			this.list.addLast(pile);
		}

		pile.getArrayList().addFirst(card);

		handlePiles(card);

	}

	public void removeCardAndAnimatePiles(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				pile.getArrayList().remove(card);

		handlePiles(card);

	}

	private void handlePiles(Card card) {

		clearPiles();
		rearrangePiles();
		animatePiles(card);

	}

	private void clearPiles() {

		for (Pile pile : this.list.clone()) {

			if (!pile.getArrayList().isEmpty())
				continue;

			this.list.remove(pile);
			pile.updateNumberImageView();
			ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.PILE, pile);

		}

	}

	private void rearrangePiles() {

		ArrayList<Pile> listTemp = this.list.clone();
		this.list.clear();

		for (CardTypeEnum cardTypeEnum : this.arrangeOrder)
			for (Pile pile : listTemp.clone())
				if (pile.getArrayList().getFirst().isCardType(cardTypeEnum)) {

					listTemp.remove(pile);
					this.list.addLast(pile);

				}

	}

	private void animatePiles(Card card) {

		this.coordinates.calculateFirstObjectCoordinatesPivot(this.list.size());

		for (Pile pile : this.list) {

			NumbersPair numbersPair = this.coordinates.getCoordinateIndex(this.list.indexOf(pile));

			if (pile.getArrayList().contains(card)) {

				double x = numbersPair.x;
				double y = numbersPair.y - Credentials.DimensionsCard.y - Credentials.DimensionsGapBetweenCards.y;

				card.getImageView().relocate(x, y);

			}

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

	public boolean containsCard(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				return true;

		return false;

	}

}
