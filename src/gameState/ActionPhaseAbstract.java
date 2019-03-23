package gameState;

import enums.PhaseEnum;
import model.Card;

public abstract class ActionPhaseAbstract extends GameStateAbstract {

	protected void resolveActionCard(Card cardToResolve) {

		super.controller.text().concealText();

		super.controller.actionBuyTreasureIndicators().removeOneAction();

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardToResolve);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		super.controller.players().getCurrentPlayer().getHand().removeCardAndAnimatePiles(cardToResolve);

		super.controller.flow().addGameStateResolvingFirst(cardToResolve.getCardAbilityEnum(PhaseEnum.ACTION));

	}

}
