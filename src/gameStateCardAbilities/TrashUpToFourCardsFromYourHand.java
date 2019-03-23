package gameStateCardAbilities;

import enums.TextEnum;
import gameState.GameStateAbstract;
import model.Card;
import utils.ArrayList;

public class TrashUpToFourCardsFromYourHand extends GameStateAbstract {

	private int cardsSelected = 0;

	@Override
	public void handleGameStateChange() {

		this.cardsSelected = 0;

		handleSelected();

	}

	@Override
	protected void executeCardPressedHandPrimary(Card cardPressed) {

		if (!super.controller.players().getCurrentPlayer().getHand().canBeSelected(cardPressed))
			return;

		super.controller.players().getCurrentPlayer().getHand().selectPile(cardPressed);
		this.cardsSelected++;

		handleSelected();

	}

	@Override
	protected void executeCardPressedHandSecondary(Card cardPressed) {

		if (!super.controller.players().getCurrentPlayer().getHand().canBeDiselected(cardPressed))
			return;

		super.controller.players().getCurrentPlayer().getHand().diselectPile(cardPressed);
		this.cardsSelected--;

		handleSelected();

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		ArrayList<Card> cardsSelected = super.controller.players().getCurrentPlayer().getHand()
				.removeSelectedCardsDiselectPiles();

		for (Card card : cardsSelected)
			card.getImageView().setVisible(false);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void handleSelected() {

		super.controller.text().concealText();

		super.controller.text().showText(TextEnum.CHOOSE_CARDS_TO_TRASH);

		if (this.cardsSelected <= 4)
			super.controller.text().showText(TextEnum.CONTINUE);

	}

}
