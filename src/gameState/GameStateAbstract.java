package gameState;

import controller.CardIndicatorSingleton;
import controller.Controller;
import enums.CardNameEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Card;
import utils.Logger;

public abstract class GameStateAbstract {

	protected Controller controller = Controller.INSTANCE;

	public abstract void handleGameStateChange();

	public final void handleTextOptionPressed(TextEnum textEnum) {

		if (textEnum == null)
			return;

		Logger.log("text executing");
		Logger.logNewLine(textEnum);

		this.controller.text().concealText();
		executeTextOption(textEnum);

	}

	protected void executeTextOption(TextEnum textEnum) {

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		int textOptionToHandle = -1;

		switch (keyCode) {

		case Q:
			textOptionToHandle = 1;
			break;

		case W:
			textOptionToHandle = 2;
			break;

		case E:
			textOptionToHandle = 3;
			break;

		default:
			break;

		}

		TextEnum textEnumPressed = this.controller.text().getTextEnumOptionShowing(textOptionToHandle);

		if (textEnumPressed == null)
			return;

		Logger.log("key pressed -> " + keyCode);
		handleTextOptionPressed(textEnumPressed);

	}

	public final void executeCardPressedPrimary(Card cardPressed) {

		if (this.controller.players().getCurrentPlayer().getHand().containsCard(cardPressed))
			executeCardPressedHandPrimary(cardPressed);
		else if (this.controller.supply().containsCard(cardPressed))
			executeCardPressedSupply(cardPressed);
		else if (this.controller.kingdom().containsCard(cardPressed))
			executeCardPressedKingdom(cardPressed);

	}

	public final void executeCardPressedSecondary(Card cardPressed) {

		if (this.controller.players().getCurrentPlayer().getHand().containsCard(cardPressed))
			executeCardPressedHandSecondary(cardPressed);

	}

	protected void executeCardPressedHandPrimary(Card cardPressed) {

	}

	protected void executeCardPressedHandSecondary(Card cardPressed) {

	}

	protected void executeCardPressedSupply(Card cardPressed) {

	}

	protected void executeCardPressedKingdom(Card cardPressed) {

	}

	public void executeCardEntered(Card card, CardNameEnum cardNameEnum) {

		if (this.controller.players().getCurrentPlayer().getDeck().getArrayList().contains(card)
				|| this.controller.players().getOpponentPlayer().getDeck().getArrayList().contains(card))
			return;

		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, true);

	}

	public void executeCardExited(CardNameEnum cardNameEnum) {
		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, false);
	}

}
