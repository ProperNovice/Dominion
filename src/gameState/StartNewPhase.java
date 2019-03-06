package gameState;

import enums.CardTypeEnum;
import enums.GameStateEnum;
import model.Card;
import model.Pile;

public class StartNewPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		GameStateEnum gameStateEnum = null;

		if (actionPhase())
			gameStateEnum = GameStateEnum.ACTION_PHASE;
		else if (buyPhase())
			gameStateEnum = GameStateEnum.BUY_PHASE;

		super.controller.flow().addGameStateResolvingFirst(gameStateEnum);
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private boolean actionPhase() {

		if (super.controller.actionBuy().getRemainingActions() == 0)
			return false;

		for (Pile pile : super.controller.players().getCurrentPlayer().getHand().getPiles()) {

			Card card = pile.getArrayList().getFirst();

			if (card.isCardType(CardTypeEnum.ACTION))
				return true;

		}

		return false;

	}

	private boolean buyPhase() {

		if (super.controller.actionBuy().getRemainingBuys() == 0)
			return false;
		else
			return true;

	}

}