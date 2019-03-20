package gameState;

import enums.CardTypeEnum;
import enums.TextEnum;
import model.Card;

public class ActionPhaseHuman extends ActionPhaseAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.ACTION_PHASE);
		super.controller.text().showText(TextEnum.PROCEED_TO_NEXT_PHASE);

	}

	@Override
	public void executeTextOption(TextEnum textEnum) {
		proceedToBuyPhase();
	}

	private void proceedToBuyPhase() {

		super.controller.actionBuyTreasureIndicators().removeAllActions();
		super.controller.flow().proceedToNextGameStatePhase();

	}

	@Override
	protected void executeCardPressedHandPrimary(Card cardPressed) {

		if (!cardPressed.isCardType(CardTypeEnum.ACTION))
			return;

		super.resolveActionCard(cardPressed);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
