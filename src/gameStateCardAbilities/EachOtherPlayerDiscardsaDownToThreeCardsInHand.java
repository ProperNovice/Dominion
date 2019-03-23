package gameStateCardAbilities;

import enums.CardNameEnum;
import gameState.GameState;
import model.Card;
import model.Pile;
import utils.ArrayList;
import utils.Logger;

public class EachOtherPlayerDiscardsaDownToThreeCardsInHand extends GameState {

	private ArrayList<CardNameEnum> discardOrder = new ArrayList<CardNameEnum>();

	public EachOtherPlayerDiscardsaDownToThreeCardsInHand() {

		this.discardOrder.addLast(CardNameEnum.CURSE);
		this.discardOrder.addLast(CardNameEnum.ESTATE);
		this.discardOrder.addLast(CardNameEnum.DUCHY);
		this.discardOrder.addLast(CardNameEnum.PROVINCE);
		this.discardOrder.addLast(CardNameEnum.COPPER);
		this.discardOrder.addLast(CardNameEnum.SILVER);
		this.discardOrder.addLast(CardNameEnum.GOLD);

	}

	@Override
	public void handleGameStateChange() {

		while (super.controller.players().getOpponentPlayer().getHand().getHandSize() > 3)
			removeCardFromHand();
		
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void removeCardFromHand() {

		for (CardNameEnum cardNameEnum : this.discardOrder) {

			for (Pile pile : super.controller.players().getOpponentPlayer().getHand().getPiles()) {

				if (pile.getArrayList().getFirst().getCardNameEnum() != cardNameEnum)
					continue;

				Card cardToRemove = pile.getArrayList().getFirst();

				super.controller.players().getOpponentPlayer().getHand().removeCardAndRelocatePiles(cardToRemove);

				super.controller.players().getOpponentPlayer().getDiscardPile().getArrayList().addFirst(cardToRemove);
				super.controller.players().getOpponentPlayer().getDiscardPile().relocateImageViews();
				
				Logger.log("discard -> " + cardToRemove.getCardNameEnum());

				return;

			}

		}

	}

}
