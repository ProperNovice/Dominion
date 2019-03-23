package gameStateCardAbilities;

import enums.CardNameEnum;
import gameState.GameState;
import model.Card;
import model.Pile;

public class EachOtherPlayerGainsCurse extends GameState {

	@Override
	public void handleGameStateChange() {

		CardNameEnum cardNameEnum = CardNameEnum.CURSE;
		Card card = null;

		if (super.controller.supply().containsCardNameEnum(cardNameEnum))
			card = super.controller.supply().getCard(cardNameEnum);

		if (card != null) {

			removeCardFromSupply(card);
			addCardToDiscardPileAndRelocate(card);

		}

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void removeCardFromSupply(Card card) {

		for (Pile pile : super.controller.supply().getPiles()) {

			if (!pile.getArrayList().contains(card))
				continue;

			pile.getArrayList().remove(card);
			pile.updateNumberImageView();

		}

	}

	private void addCardToDiscardPileAndRelocate(Card card) {

		super.controller.players().getOpponentPlayer().getDiscardPile().getArrayList().addFirst(card);
		super.controller.players().getOpponentPlayer().getDiscardPile().relocateImageViews();

	}

}
