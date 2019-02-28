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

	}

}
