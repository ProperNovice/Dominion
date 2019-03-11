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
		else if (textEnum == TextEnum.PROCEED_TO_NEXT_PHASE) {

			super.controller.actionBuyTreasureIndicators().removeAllBuys();
			super.controller.flow().proceedToNextGameStatePhase();

		}

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

		super.controller.flow().print();
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

			if (pile.getPileAmountOfCardsEnum() == PileAmountOfCardsEnum.FINITE) {

				pile.getArrayList().remove(cardPressed);
				pile.updateNumberImageView();

			} else {

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
