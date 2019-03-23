package gameStateCardAbilities;

import controller.CardManagerSingleton;
import enums.CardNameEnum;
import enums.PileAmountOfCardsEnum;
import enums.TextEnum;
import gameState.GameStateAbstract;
import model.Card;
import model.Pile;
import model.SupplyKingdom;

public class TrashCardFromYourHandGainCardCostingUpToTwoMoreThanIt extends GameStateAbstract {

	private TextEnum textEnumShowing = null;
	private int cardMaximumBuyCost = 0;

	@Override
	public void handleGameStateChange() {

		this.cardMaximumBuyCost = 0;
		this.textEnumShowing = TextEnum.CHOOSE_A_CARD_TO_TRASH;
		showText();

	}

	@Override
	protected void executeCardPressedHandPrimary(Card cardPressed) {

		if (this.textEnumShowing != TextEnum.CHOOSE_A_CARD_TO_TRASH)
			return;

		super.controller.players().getCurrentPlayer().getHand().removeCardAndRelocatePiles(cardPressed);
		cardPressed.getImageView().setVisible(false);

		this.cardMaximumBuyCost = cardPressed.getBuyCost() + 2;

		this.textEnumShowing = TextEnum.CHOOSE_A_CARD_COSTING_UP_TO_TWO_MORE;
		showText();

	}

	@Override
	protected void executeCardPressedKingdom(Card cardPressed) {
		handleCardPressedSupplyKingdom(cardPressed, super.controller.kingdom());
	}

	@Override
	protected void executeCardPressedSupply(Card cardPressed) {
		handleCardPressedSupplyKingdom(cardPressed, super.controller.supply());
	}

	private void handleCardPressedSupplyKingdom(Card cardPressed, SupplyKingdom supplyKingdom) {

		if (this.textEnumShowing != TextEnum.CHOOSE_A_CARD_COSTING_UP_TO_TWO_MORE)
			return;

		if (cardPressed.getBuyCost() > this.cardMaximumBuyCost)
			return;

		for (Pile pile : supplyKingdom.getPiles()) {

			if (!pile.getArrayList().contains(cardPressed))
				continue;

			pile.getArrayList().remove(cardPressed);
			pile.updateNumberImageView();

			if (pile.getPileAmountOfCardsEnum() == PileAmountOfCardsEnum.FINITE)
				break;

			CardNameEnum cardNameEnum = cardPressed.getCardNameEnum();
			Card card = CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum);
			pile.getArrayList().addLast(card);

			pile.relocateImageViews();

			break;

		}

		super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getDiscardPile().relocateImageViews();
		super.controller.players().getCurrentPlayer().getDiscardPile().toBack();

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void showText() {

		super.controller.text().concealText();
		super.controller.text().showText(this.textEnumShowing);

	}

}
