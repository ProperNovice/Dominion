package model;

import controller.Credentials;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.ObjectPoolEnum;
import utils.ArrayList;
import utils.Coordinates;
import utils.ListSizeAble;
import utils.Lock;
import utils.Logger;
import utils.NumbersPair;
import utils.ObjectPoolSingleton;
import utils.ShutDown;

public abstract class Hand implements ListSizeAble {

	private ArrayList<Pile> list = new ArrayList<>();
	protected Coordinates coordinates = null;
	private ArrayList<CardTypeEnum> arrangeOrderCardTypeEnum = new ArrayList<>();
	private ArrayList<CardNameEnum> arrangeOrgerVictoryTreasureCurse = new ArrayList<>();
	private Card cardToadd = null;

	public Hand() {

		createCoordinates();
		createArrangeOrders();

	}

	protected abstract void createCoordinates();

	public void addCardAndAnimatePiles(Card card) {

		addCard(card);
		handlePiles(PileRearrangeType.ANIMATE);

	}

	private void addCard(Card card) {

		this.cardToadd = card;

		Pile pile = null;

		for (Pile pileTemp : this.list)
			if (!pileTemp.getArrayList().isEmpty())
				if (pileTemp.getArrayList().getFirst().getCardNameEnum() == card.getCardNameEnum())
					pile = pileTemp;

		if (pile == null) {

			pile = (Pile) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.PILE);
			this.list.addLast(pile);

		}

		pile.getArrayList().addFirst(this.cardToadd);

	}

	public void removeCardAndAnimatePiles(Card card) {

		removeCard(card);
		handlePiles(PileRearrangeType.ANIMATE);

	}

	public void removeCardAndRelocatePiles(Card card) {

		removeCard(card);
		handlePiles(PileRearrangeType.RELOCATE);

	}

	private void removeCard(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				pile.getArrayList().remove(card);

	}

	public void handlePiles(PileRearrangeType pileRearrangeType) {

		clearPiles();
		rearrangePiles();
		animatePiles(pileRearrangeType);

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

		ArrayList<Pile> listOriginal = this.list.clone();
		this.list.clear();

		for (CardNameEnum cardNameEnum : this.arrangeOrgerVictoryTreasureCurse)
			for (Pile pile : listOriginal.clone())
				if (pile.getArrayList().getFirst().getCardNameEnum() == cardNameEnum) {

					listOriginal.remove(pile);
					this.list.addLast(pile);

				}

		for (CardTypeEnum cardTypeEnum : this.arrangeOrderCardTypeEnum)
			for (Pile pile : listOriginal.clone())
				if (pile.getArrayList().getFirst().isCardType(cardTypeEnum)) {

					listOriginal.remove(pile);
					this.list.addLast(pile);

				}

	}

	private void animatePiles(PileRearrangeType pileRearrangeType) {

		for (Pile pile : this.list) {

			NumbersPair numbersPair = this.coordinates.getCoordinate(this.list.indexOf(pile));

			if (pile.getArrayList().contains(this.cardToadd)) {

				double x = numbersPair.x;
				double y = numbersPair.y - Credentials.DimensionsCard.y - Credentials.DimensionsGapBetweenCards.y;

				this.cardToadd.getImageView().relocate(x, y);

			}

			pile.relocateList(numbersPair);

			if (pileRearrangeType == PileRearrangeType.ANIMATE)
				pile.animateSynchronous();
			else if (pileRearrangeType == PileRearrangeType.RELOCATE)
				pile.relocateImageViews();

		}

		this.cardToadd = null;

		if (pileRearrangeType == PileRearrangeType.ANIMATE)
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

	private void createArrangeOrders() {

		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.CURSE);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.ESTATE);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.DUCHY);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.PROVINCE);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.GARDENS);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.COPPER);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.SILVER);
		this.arrangeOrgerVictoryTreasureCurse.addLast(CardNameEnum.GOLD);

		this.arrangeOrderCardTypeEnum.addLast(CardTypeEnum.REACTION);
		this.arrangeOrderCardTypeEnum.addLast(CardTypeEnum.ACTION);

	}

	@Override
	public int getSize() {
		return this.list.size();
	}

	public enum PileRearrangeType {
		ANIMATE, RELOCATE
	}

	public void testSetHandAndRelocate(ArrayList<Card> hand) {

		for (Card card : hand)
			addCard(card);

		handlePiles(PileRearrangeType.RELOCATE);

	}

	public boolean containsAtLeastOneTreasureCard() {

		for (Pile pile : this.list)
			if (pile.getArrayList().getFirst().isCardType(CardTypeEnum.TREASURE))
				return true;

		return false;

	}

	public boolean canBeSelected(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				return pile.canBeSelected();

		ShutDown.execute("canBeSelected " + this.getClass());
		return false;

	}

	public boolean canBeDiselected(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				if (pile.isSelected())
					return true;

		return false;

	}

	public void selectPile(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				pile.selectOne();

	}

	public void diselectPile(Card card) {

		for (Pile pile : this.list)
			if (pile.getArrayList().contains(card))
				pile.diselectOne();

	}

	public ArrayList<Card> removeSelectedCardsDiselectPiles() {

		ArrayList<Card> cards = new ArrayList<Card>();

		for (Pile pile : this.list) {

			if (!pile.isSelected())
				continue;

			int cardsAmount = pile.getSelectedAmount();
			pile.diselectAll();

			for (int counter = 1; counter <= cardsAmount; counter++)
				cards.addLast(pile.getArrayList().removeLast());

			pile.updateNumberImageView();

		}

		handlePiles(PileRearrangeType.RELOCATE);

		return cards;

	}

	public void print() {

		Logger.log("printing hand");

		for (Pile pile : this.list) {

			Logger.log("index " + this.list.indexOf(pile) + " - size " + pile.getArrayList().size() + " - "
					+ pile.getArrayList().getFirst().getCardNameEnum());

		}

		Logger.newLine();

	}

}
