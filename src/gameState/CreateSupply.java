package gameState;

import enums.CardNameEnum;
import utils.ArrayList;

public class CreateSupply extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<CardNameEnum> list = new ArrayList<>();

		list.addLast(CardNameEnum.PROVINCE);
		list.addLast(CardNameEnum.GOLD);
		list.addLast(CardNameEnum.DUCHY);
		list.addLast(CardNameEnum.SILVER);
		list.addLast(CardNameEnum.ESTATE);
		list.addLast(CardNameEnum.COPPER);

	}

}
