package gameState;

import controller.CardIndicatorSingleton;
import controller.Controller;
import enums.CardNameEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Card;
import utils.Instances;
import utils.Logger;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public final void handleTextOptionPressed(TextEnum textEnum) {

		if (textEnum == null)
			return;

		Logger.log("text executing");
		Logger.logNewLine(textEnum);

		this.controller.text().concealText();
		executeTextOptionPressed(textEnum);

	}

	protected void executeTextOptionPressed(TextEnum textEnum) {

	}

	public void executeKeyPressed(KeyCode keyCode) {

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

	public final void executeCardPressed(Card cardPressed) {

		if (this.controller.players().getCurrentPlayer().getHand().containsCard(cardPressed))
			executeCardPressedHand(cardPressed);

	}

	protected void executeCardPressedHand(Card cardPressed) {

	}

	public void executeCardEntered(Card card, CardNameEnum cardNameEnum) {

		if (this.controller.players().getCurrentPlayer().getDeck().getArrayList().contains(card))
			return;

//		else if (this.controller.players().getOpponent().getDeck().getArrayList().contains(card))
//			return;

		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, true);

	}

	public void executeCardExited(CardNameEnum cardNameEnum) {
		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, false);
	}

}
