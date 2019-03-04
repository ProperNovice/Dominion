package gameState;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import enums.PileAmountOfCardsEnum;
import model.Pile;
import utils.ArrayList;

public class CreateSupply extends GameState {

	private ArrayList<Pile> piles = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		addPile(CardNameEnum.PROVINCE, 8);
		addPile(CardNameEnum.GOLD, 1);
		addPile(CardNameEnum.DUCHY, 8);
		addPile(CardNameEnum.SILVER, 1);
		addPile(CardNameEnum.ESTATE, 8);
		addPile(CardNameEnum.COPPER, 1);
		addPile(CardNameEnum.CURSE, 10);

		super.controller.supply().setPileListAndRelocate(this.piles);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void addPile(CardNameEnum cardNameEnum, int amount) {

		PileAmountOfCardsEnum pileAmountOfCardsEnum = null;

		if (amount == 1)
			pileAmountOfCardsEnum = PileAmountOfCardsEnum.INFINITE;
		else
			pileAmountOfCardsEnum = PileAmountOfCardsEnum.FINITE;

		Pile pile = new Pile(pileAmountOfCardsEnum);
		this.piles.addLast(pile);

		for (int counter = 1; counter <= amount; counter++)
			pile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum));

		pile.updateNumberImageView();

	}

}
