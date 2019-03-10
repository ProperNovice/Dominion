package gameState;

import enums.CardTypeEnum;
import enums.TextEnum;
import model.Card;
import model.Pile;
import utils.ArrayList;
import utils.Logger;

public class BuyPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().concealText();

		super.controller.text().showText(TextEnum.BUY_PHASE);

		if (super.controller.players().getCurrentPlayer().getHand().containsAtLeastOneTreasureCard())
			super.controller.text().showText(TextEnum.PLAY_HAND_TREASURES);

		super.controller.text().showText(TextEnum.PROCEED_TO_NEXT_PHASE);

	}

	@Override
	public void executeTextOptionPressed(TextEnum textEnum) {

		if (textEnum == TextEnum.PLAY_HAND_TREASURES)
			playHandTreasures();

	}

	@Override
	protected void executeCardPressedHand(Card cardPressed) {

		if (!cardPressed.isCardType(CardTypeEnum.TREASURE))
			return;

		super.controller.players().getCurrentPlayer().getHand().removeCardAndAnimatePiles(cardPressed);

		super.controller.actionBuyTreasureIndicators().addCoins(cardPressed.getTreasure());

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		Logger.logNewLine("coins played -> " + cardPressed.getTreasure());

		handleGameStateChange();

	}

	private void playHandTreasures() {

		ArrayList<Pile> handPiles = super.controller.players().getCurrentPlayer().getHand().getPiles();
		ArrayList<Card> treasures = new ArrayList<Card>();

		for (Pile pile : handPiles)
			if (pile.getArrayList().getFirst().isCardType(CardTypeEnum.TREASURE))
				treasures.addAll(pile.getArrayList());

		int coinsPlayed = 0;

		for (Card card : treasures) {
			super.controller.players().getCurrentPlayer().getHand().removeCardAndRelocatePiles(card);
			coinsPlayed += card.getTreasure();
		}

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addAll(treasures);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		super.controller.actionBuyTreasureIndicators().addCoins(coinsPlayed);

		Logger.logNewLine("coins played -> " + coinsPlayed);

		handleGameStateChange();

	}

}
