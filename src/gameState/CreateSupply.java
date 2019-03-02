package gameState;

import enums.CardNameEnum;
import model.Pile;
import utils.ArrayList;

public class CreateSupply extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<CardNameEnum> cardNames = new ArrayList<>();
		ArrayList<Pile> piles = new ArrayList<>();

		cardNames.addLast(CardNameEnum.PROVINCE);
		cardNames.addLast(CardNameEnum.GOLD);
		cardNames.addLast(CardNameEnum.DUCHY);
		cardNames.addLast(CardNameEnum.SILVER);
		cardNames.addLast(CardNameEnum.ESTATE);
		cardNames.addLast(CardNameEnum.COPPER);

		Pile pile = new Pile(CardNameEnum.GOLD);

		for (int counter = 1; counter <= 12; counter++)
			pile.getArrayList().addFirst(super.controller.cardManager().getCardPool(CardNameEnum.GOLD));
		
		pile.updateNumberImageView();

		pile.relocateArrayList(100, 100);
		pile.relocateImageViews();

	}

}
