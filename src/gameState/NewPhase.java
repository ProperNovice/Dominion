package gameState;

import enums.CardTypeEnum;
import enums.GameStateEnum;
import model.Card;
import model.Pile;

public class NewPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().concealText();
		GameStateEnum gameStateEnum = null;

		if (actionPhase())
			gameStateEnum = GameStateEnum.ACTION_PHASE;

		else if (buyPhase()) {
			super.controller.actionBuyTreasureIndicators().removeAllActions();
			gameStateEnum = GameStateEnum.BUY_PHASE;
		} else
			gameStateEnum = GameStateEnum.CLEAN_UP_PHASE;

		super.controller.flow().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private boolean actionPhase() {

		if (super.controller.actionBuyTreasureIndicators().getRemainingActions() == 0)
			return false;

		for (Pile pile : super.controller.players().getCurrentPlayer().getHand().getPiles()) {

			Card card = pile.getArrayList().getFirst();

			if (card.isCardType(CardTypeEnum.ACTION))
				return true;

		}

		return false;

	}

	private boolean buyPhase() {

		if (super.controller.actionBuyTreasureIndicators().getRemainingBuys() == 0)
			return false;
		else
			return true;

	}

}
