package gameState;

import enums.CardTypeEnum;
import enums.PhaseEnum;
import enums.TextEnum;
import model.Card;

public class ActionPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.ACTION_PHASE);
		super.controller.text().showText(TextEnum.PROCEED_TO_BUY_PHASE);

	}

	@Override
	protected void handleCardPressedHand(Card cardPressed) {

		if (!cardPressed.isCardType(CardTypeEnum.ACTION))
			return;

		super.controller.text().concealText();

		super.controller.actionBuy().removeActionAndRearrange();

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		super.controller.players().getCurrentPlayer().getHand().removeCardAndAnimatePiles(cardPressed);

		super.controller.flow().addGameStateResolvingFirst(cardPressed.getCardAbilityEnum(PhaseEnum.ACTION));
		super.controller.flow().proceedToNextGameStatePhase();

	}

}