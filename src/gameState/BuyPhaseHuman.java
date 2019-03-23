package gameState;

import enums.CardTypeEnum;
import enums.TextEnum;
import model.Card;
import utils.Logger;

public class BuyPhaseHuman extends BuyPhaseAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.text().concealText();

		super.controller.text().showText(TextEnum.BUY_PHASE);

		if (super.controller.players().getCurrentPlayer().getHand().containsAtLeastOneTreasureCard())
			super.controller.text().showText(TextEnum.PLAY_HAND_TREASURES);

		super.controller.text().showText(TextEnum.PROCEED_TO_NEXT_PHASE);

	}

	@Override
	public void executeTextOption(TextEnum textEnum) {

		if (textEnum == TextEnum.PLAY_HAND_TREASURES)
			super.playHandTreasures();

		else if (textEnum == TextEnum.PROCEED_TO_NEXT_PHASE) {

			super.controller.actionBuyTreasureIndicators().removeAllBuys();
			super.controller.flow().proceedToNextGameStatePhase();

		}

	}

	@Override
	protected void executeCardPressedHandPrimary(Card cardPressed) {

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

	@Override
	protected void executeCardPressedSupply(Card cardPressed) {

		if (!canBuyCardPressed(cardPressed))
			return;

		super.buySupplyKingdomCardPressed(cardPressed, super.controller.supply());

	}

	@Override
	protected void executeCardPressedKingdom(Card cardPressed) {

		if (!canBuyCardPressed(cardPressed))
			return;

		super.buySupplyKingdomCardPressed(cardPressed, super.controller.kingdom());

	}

	private boolean canBuyCardPressed(Card cardPressed) {

		int treasure = super.controller.actionBuyTreasureIndicators().getTreasure();
		int cardBuyCost = cardPressed.getBuyCost();

		Logger.log("treasure -> " + treasure);
		Logger.log("card buy cost -> " + cardBuyCost);

		if (cardBuyCost > treasure) {

			Logger.logNewLine("cannot buy it");
			return false;

		} else {

			Logger.logNewLine("buying it");
			return true;

		}

	}

}
