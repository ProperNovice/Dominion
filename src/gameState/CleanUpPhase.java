package gameState;

import enums.CardNameEnum;
import enums.GameStateEnum;
import enums.PileAmountOfCardsEnum;
import enums.PlayerEnum;
import enums.TextEnum;
import model.DiscardPile;
import model.Hand.PileRearrangeType;
import model.Pile;

public class CleanUpPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().removeAllCoinsSetVisibleFalse();

		super.controller.text().showText(TextEnum.CLEAN_UP_PHASE);
		super.controller.text().showText(TextEnum.CLEAN_UP);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		executeCleanUp();
		changeCurrentPlayer();

		super.controller.flow().addGameStateResolvingFirst(GameStateEnum.SET_UP_AND_SHOW_NEW_ROUND_INDICATORS);
		super.controller.flow().addGameStateResolvingFirst(GameStateEnum.DRAW_STARTING_HAND_OPPONENT_PLAYER);
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void executeCleanUp() {

		DiscardPile discardPile = super.controller.players().getCurrentPlayer().getDiscardPile();

		discardPile.getArrayList().addAll(super.controller.players().getCurrentPlayer().getPlayArea().getArrayList());
		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().clear();

		for (Pile pile : super.controller.players().getCurrentPlayer().getHand().getPiles()) {

			discardPile.getArrayList().addAll(pile.getArrayList());

			pile.getArrayList().clear();
			pile.updateNumberImageView();

		}

		super.controller.players().getCurrentPlayer().getHand().handlePiles(PileRearrangeType.RELOCATE);

		discardPile.relocateImageViews();
		discardPile.toBack();

	}

	private boolean gameEnded() {

		for (Pile pile : super.controller.supply().getPiles())
			if (pile.getArrayList().getFirst().getCardNameEnum() == CardNameEnum.PROVINCE)
				if (pile.getPileAmountOfCardsEnum() == PileAmountOfCardsEnum.FINITE)
					return false;

		if (super.controller.players().getCurrentPlayerEnum() != super.controller.players().getFirstPlayer())
			return false;

		return true;

	}

	private void changeCurrentPlayer() {

		super.controller.players().changePlayer();

		PlayerEnum currentPlayerEnum = super.controller.players().getCurrentPlayerEnum();
		super.controller.actionBuyTreasureIndicators().setCoordinatesPlayer(currentPlayerEnum);

	}

}
