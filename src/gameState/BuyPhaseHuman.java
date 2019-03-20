package gameState;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.PileAmountOfCardsEnum;
import enums.TextEnum;
import model.Card;
import model.Pile;
import model.SupplyKingdom;
import utils.ArrayList;
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
		handleSupplyKingdomCardPressed(cardPressed, super.controller.supply());
	}

	@Override
	protected void executeCardPressedKingdom(Card cardPressed) {
		handleSupplyKingdomCardPressed(cardPressed, super.controller.kingdom());
	}

	private void handleSupplyKingdomCardPressed(Card cardPressed, SupplyKingdom supplyKingdom) {

		if (!canBuyCardPressed(cardPressed))
			return;

		removeCardHandlePile(cardPressed, supplyKingdom);
		addCardToPlayArea(cardPressed);
		handleBuyTreasureIndicator(cardPressed);

		super.controller.flow().proceedToNextGameStatePhase();

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

	private void removeCardHandlePile(Card cardPressed, SupplyKingdom supplyKingdom) {

		ArrayList<Pile> piles = supplyKingdom.getPiles();

		for (Pile pile : piles) {

			if (!pile.getArrayList().contains(cardPressed))
				continue;

			pile.getArrayList().remove(cardPressed);

			if (pile.getPileAmountOfCardsEnum() == PileAmountOfCardsEnum.FINITE)
				pile.updateNumberImageView();

			else {

				CardNameEnum cardNameEnum = cardPressed.getCardNameEnum();
				pile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum));
				pile.relocateImageViews();

			}

		}

	}

	private void addCardToPlayArea(Card cardPressed) {

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

	}

	private void handleBuyTreasureIndicator(Card cardPressed) {

		super.controller.actionBuyTreasureIndicators().removeOneBuy();

		int buyCost = cardPressed.getBuyCost();
		super.controller.actionBuyTreasureIndicators().removeCoins(buyCost);

	}

}
