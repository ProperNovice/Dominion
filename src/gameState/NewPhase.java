package gameState;

import enums.CardTypeEnum;
import enums.GameStateEnum;
import enums.PlayerEnum;
import model.Card;
import model.Pile;

public class NewPhase extends GameState {

	private GameStateEnum gameStateEnum = null;
	private PlayerEnum currentPlayerEnum = null;

	@Override
	public void handleGameStateChange() {

		super.controller.text().concealText();
		this.gameStateEnum = null;
		this.currentPlayerEnum = super.controller.players().getCurrentPlayerEnum();

		if (actionPhase()) {

			if (this.currentPlayerEnum == PlayerEnum.HUMAN)
				this.gameStateEnum = GameStateEnum.ACTION_PHASE_HUMAN;
			else if (this.currentPlayerEnum == PlayerEnum.AI)
				this.gameStateEnum = GameStateEnum.ACTION_PHASE_AI;

		} else if (buyPhase()) {

			super.controller.actionBuyTreasureIndicators().removeAllActions();

			if (this.currentPlayerEnum == PlayerEnum.HUMAN)
				this.gameStateEnum = GameStateEnum.BUY_PHASE_HUMAN;
			else if (this.currentPlayerEnum == PlayerEnum.AI)
				this.gameStateEnum = GameStateEnum.BUY_PHASE_AI;

		} else
			this.gameStateEnum = GameStateEnum.CLEAN_UP_PHASE;

		super.controller.flow().addGameStateResolvingFirst(this.gameStateEnum);
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
		return super.controller.actionBuyTreasureIndicators().getRemainingBuys() != 0;
	}

}
