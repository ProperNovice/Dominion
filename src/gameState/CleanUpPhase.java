package gameState;

import enums.GameStateEnum;
import enums.TextEnum;
import model.DiscardPile;
import model.Hand.PileRearrangeType;
import model.Pile;

public class CleanUpPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.actionBuyTreasureIndicators().removeAllCoinsSetVisibleFalse();

		super.controller.text().showText(TextEnum.CLEAN_UP_PHASE);
		super.controller.text().showText(TextEnum.CONTINUE);

	}

	@Override
	protected void executeTextOptionPressed(TextEnum textEnum) {

		if (textEnum == TextEnum.CONTINUE) {

			executeCleanUp();
			super.controller.text().showText(TextEnum.CLEAN_UP_PHASE);
			super.controller.text().showText(TextEnum.END_TURN);

		} else if (textEnum == TextEnum.END_TURN) {

			super.controller.flow().addGameStateResolvingFirst(GameStateEnum.END_TURN);
			super.controller.flow().proceedToNextGameStatePhase();

		}

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

}
