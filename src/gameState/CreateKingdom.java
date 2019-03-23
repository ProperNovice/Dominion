package gameState;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.PileAmountOfCardsEnum;
import model.Card;
import model.Pile;
import utils.ArrayList;

public class CreateKingdom extends GameStateAbstract {

	private ArrayList<Pile> piles = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		ArrayList<CardNameEnum> cardNameEnumList = new ArrayList<>();

		cardNameEnumList.addLast(CardNameEnum.SMITHY);
		cardNameEnumList.addLast(CardNameEnum.CHAPEL);
		cardNameEnumList.addLast(CardNameEnum.CELLAR);
		cardNameEnumList.addLast(CardNameEnum.VILLAGE);
		cardNameEnumList.addLast(CardNameEnum.WORKSHOP);
		cardNameEnumList.addLast(CardNameEnum.REMODEL);
		cardNameEnumList.addLast(CardNameEnum.MILITIA);
		cardNameEnumList.addLast(CardNameEnum.GARDENS);
		cardNameEnumList.addLast(CardNameEnum.MARKET);
		cardNameEnumList.addLast(CardNameEnum.WITCH);

		cardNameEnumList.shuffle();

		for (CardNameEnum cardNameEnum : cardNameEnumList)
			addPile(cardNameEnum);

		rearrangePiles();

		super.controller.kingdom().setPileListAndRelocate(this.piles);
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void addPile(CardNameEnum cardNameEnum) {

		PileAmountOfCardsEnum pileAmountOfCardsEnum = PileAmountOfCardsEnum.FINITE;
		int amount = 10;

		Pile pile = new Pile(pileAmountOfCardsEnum);
		this.piles.addLast(pile);

		for (int counter = 1; counter <= amount; counter++) {

			Card card = CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum);

			pile.getArrayList().addLast(card);

			if (card.isCardType(CardTypeEnum.VICTORY))
				amount = 8;

		}

		pile.updateNumberImageView();

	}

	private void rearrangePiles() {

		ArrayList<Pile> pilesTemp = this.piles.clone();
		this.piles.clear();

		int buyCost = 0;

		while (!pilesTemp.isEmpty()) {

			for (Pile pile : pilesTemp.clone()) {

				if (pile.getArrayList().getFirst().getBuyCost() != buyCost)
					continue;

				pilesTemp.remove(pile);
				this.piles.addLast(pile);

			}

			buyCost++;

		}

	}

}
