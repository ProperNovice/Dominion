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
	public void executeTextOptionPressed(TextEnum textEnum) {
		proceedToBuyPhase();
	}

	@Override
	protected void executeKeyPressedQ() {
		super.handleTextOptionPressed(null);
	}

	private void proceedToBuyPhase() {
		super.controller.actionBuyTreasureIndicators().removeAllActions();
		super.controller.flow().proceedToNextGameStatePhase();
	}
	
	private int timesRun = 0;

	@Override
	protected void executeCardPressedHand(Card cardPressed) {

		if (!cardPressed.isCardType(CardTypeEnum.ACTION))
			return;

		super.controller.text().concealText();

		super.controller.actionBuyTreasureIndicators().removeOneAction();

		
		timesRun++;
		
//		if (timesRun <= 3)
//		for (int counter = 1; counter <= 8; counter++)
//			super.controller.actionBuyTreasureIndicators().addOneCoin();
//		else
//			for (int counter = 1; counter <= 5; counter++)
//				super.controller.actionBuyTreasureIndicators().

		
		
		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();

		super.controller.players().getCurrentPlayer().getHand().removeCardAndAnimatePiles(cardPressed);

		super.controller.flow().addGameStateResolvingFirst(cardPressed.getCardAbilityEnum(PhaseEnum.ACTION));
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
