package gameState;

import enums.CardTypeEnum;
import model.Card;
import model.Hand.PileRearrangeType;
import model.Pile;
import utils.ArrayList;
import utils.Logger;

public abstract class BuyPhaseAbstract extends GameState {

	protected void playHandTreasures() {

		ArrayList<Pile> handPiles = super.controller.players().getCurrentPlayer().getHand().getPiles();
		ArrayList<Card> treasures = new ArrayList<Card>();

		int coinsPlayed = 0;

		for (Pile pile : handPiles)
			if (pile.getArrayList().getFirst().isCardType(CardTypeEnum.TREASURE)) {

				for (Card card : pile.getArrayList().clone()) {

					coinsPlayed += card.getTreasure();
					pile.getArrayList().remove(card);
					treasures.addLast(card);

				}

			}

		super.controller.players().getCurrentPlayer().getHand().handlePiles(PileRearrangeType.RELOCATE);

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addAll(treasures);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		super.controller.actionBuyTreasureIndicators().addCoins(coinsPlayed);

		Logger.logNewLine("coins played -> " + coinsPlayed);

		handleGameStateChange();

	}

}
