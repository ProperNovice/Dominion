package model;

import enums.ObjectPoolEnum;
import utils.ArrayList;
import utils.Coordinates;
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

		if (pile == null)
			pile = (Pile) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.PILE);

		pile.getArrayList().addFirst(card);
		pile.toFront();
		pile.updateNumberImageView();

		relocatePiles();

		return;

	}

	private void relocatePiles() {

		for (Pile pile : this.list) {

			pile.relocateList(this.coordinates.getCoordinateIndex(this.list.indexOf(pile)));
			pile.relocateImageViews();

		}

	}

}
