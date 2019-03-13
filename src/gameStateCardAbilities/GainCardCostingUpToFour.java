package gameStateCardAbilities;

import enums.TextEnum;
import gameState.GameState;
import model.Card;
import model.Pile;

public class GainCardCostingUpToFour extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.CHOOSE_A_CARD_COSTING_UP_TO_FOUR);

	}

	@Override
	protected void executeCardPressedKingdom(Card cardPressed) {

		int buyCost = cardPressed.getBuyCost();

		if (buyCost > 4)
			return;

		Pile kingdomPile = null;

		for (Pile pile : super.controller.kingdom().getPiles())
			if (pile.getArrayList().contains(cardPressed))
				kingdomPile = pile;

		kingdomPile.getArrayList().remove(cardPressed);
		kingdomPile.updateNumberImageView();

		super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getDiscardPile().relocateImageViews();
		super.controller.players().getCurrentPlayer().getDiscardPile().toBack();

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
