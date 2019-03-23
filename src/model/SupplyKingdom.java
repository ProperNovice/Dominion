package model;

import enums.CardNameEnum;
import utils.ArrayList;
import utils.Coordinates;

public abstract class SupplyKingdom {

	private ArrayList<Pile> list = new ArrayList<>();
	protected Coordinates coordinates = null;

	public SupplyKingdom() {

		createCoordinates();

	}

	protected abstract void createCoordinates();

	public void setPileListAndRelocate(ArrayList<Pile> list) {

		this.list = list;

		for (Pile pile : this.list) {

			pile.relocateList(this.coordinates.getCoordinate(this.list.indexOf(pile)));
			pile.relocateImageViews();

		}

	}

	public boolean containsCard(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				return true;

		return false;

	}

	public boolean containsCardNameEnum(CardNameEnum cardNameEnum) {

		for (Pile pile : this.list)
			if (pile.getArrayList().getFirst().getCardNameEnum() == cardNameEnum)
				return true;

		return false;

	}

	public Card getCard(CardNameEnum cardNameEnum) {

		Card card = null;

		for (Pile pile : this.list)
			if (pile.getArrayList().getFirst().getCardNameEnum() == cardNameEnum)
				card = pile.getArrayList().getFirst();

		return card;

	}

	public ArrayList<Pile> getPiles() {
		return this.list;
	}

}
