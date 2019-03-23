package gameState;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.PileAmountOfCardsEnum;
import model.Card;
import model.Hand.PileRearrangeType;
import model.Pile;
import model.SupplyKingdom;
import utils.ArrayList;
import utils.Logger;

public abstract class BuyPhaseAbstract extends GameStateAbstract {

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

	protected void buySupplyKingdomCardPressed(Card cardPressed, SupplyKingdom supplyKingdom) {

		removeCardHandlePile(cardPressed, supplyKingdom);
		addCardToPlayArea(cardPressed);
		handleBuyTreasureIndicator(cardPressed);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void removeCardHandlePile(Card cardPressed, SupplyKingdom supplyKingdom) {

		ArrayList<Pile> piles = supplyKingdom.getPiles();

		for (Pile pile : piles) {

			if (!pile.getArrayList().contains(cardPressed))
				continue;

			pile.getArrayList().remove(cardPressed);

			if (pile.getArrayList().isEmpty() && cardPressed.getCardNameEnum() == CardNameEnum.PROVINCE)
				pile.setPileAmountOfCardsInfinite();

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
