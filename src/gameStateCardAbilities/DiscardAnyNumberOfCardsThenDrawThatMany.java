package gameStateCardAbilities;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.GameStateAbstract;
import model.Card;
import utils.ArrayList;

public class DiscardAnyNumberOfCardsThenDrawThatMany extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.CHOOSE_CARDS_TO_DISCARD);
		super.controller.text().showText(TextEnum.CONTINUE);

	}

	@Override
	protected void executeCardPressedHandPrimary(Card cardPressed) {

		if (super.controller.players().getCurrentPlayer().getHand().canBeSelected(cardPressed))
			super.controller.players().getCurrentPlayer().getHand().selectPile(cardPressed);

	}

	@Override
	protected void executeCardPressedHandSecondary(Card cardPressed) {

		if (super.controller.players().getCurrentPlayer().getHand().canBeDiselected(cardPressed))
			super.controller.players().getCurrentPlayer().getHand().diselectPile(cardPressed);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		ArrayList<Card> cardsSelected = super.controller.players().getCurrentPlayer().getHand()
				.removeSelectedCardsDiselectPiles();

		super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList().addAll(cardsSelected);
		super.controller.players().getCurrentPlayer().getDiscardPile().relocateImageViews();
		super.controller.players().getCurrentPlayer().getDiscardPile().toBack();

		for (int counter = 1; counter <= cardsSelected.size(); counter++)
			super.controller.flow().addGameStateResolvingFirst(GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);

		super.controller.flow().proceedToNextGameStatePhase();

	}

}
