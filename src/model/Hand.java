package model;

import enums.ObjectPoolEnum;
import utils.ArrayList;
import utils.Coordinates;
import utils.Lock;
import utils.ObjectPoolSingleton;

public class Hand {

	private ArrayList<Pile> list = new ArrayList<>();
	private Coordinates coordinates = null;

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
		pile.toFront();

		relocatePilesAndImageViews();

	}

	private void relocatePilesAndImageViews() {

		this.coordinates.calculateFirstObjectCoordinatesPivot(this.list.size());

		for (Pile pile : this.list) {

			pile.relocateList(this.coordinates.getCoordinateIndex(this.list.indexOf(pile)));
			pile.animateSynchronous();

		}

		Lock.lock();

		for (Pile pile : this.list)
			pile.updateNumberImageView();

	}

}
