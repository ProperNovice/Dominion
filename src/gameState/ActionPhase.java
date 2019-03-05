package gameState;

import enums.CardTypeEnum;
import enums.TextEnum;
import model.Card;
import model.Pile;

public class ActionPhase extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.ACTION_PHASE);
		super.controller.text().showText(TextEnum.PROCEED_TO_BUY_PHASE);

	}

	@Override
	protected void handleCardPressedHand(Card cardPressed, Pile pileHandPressed) {

		if (!cardPressed.isCardType(CardTypeEnum.ACTION))
			return;

		super.controller.players().getCurrentPlayer().getPlayArea().getArrayList().addLast(cardPressed);
		super.controller.players().getCurrentPlayer().getPlayArea().relocateImageViews();
		super.controller.players().getCurrentPlayer().getPlayArea().toBack();
		
	}

}
