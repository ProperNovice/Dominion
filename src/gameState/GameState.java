package gameState;

import controller.CardIndicatorSingleton;
import controller.Controller;
import enums.CardNameEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Card;
import model.Pile;
import utils.Instances;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

		switch (keyCode) {

		case Q:
			handleKeyPressedQ();
			break;

		case W:
			handleKeyPressedW();
			break;

		case E:
			handleKeyPressedE();
			break;

		default:
			break;

		}

	}

	protected void handleKeyPressedQ() {

	}

	protected void handleKeyPressedW() {

	}

	protected void handleKeyPressedE() {

	}

	public final void handleCardPressed(Card cardPressed) {

		Pile pileHandPressed = this.controller.players().getCurrentPlayer().getHand()
				.getPileContainingCard(cardPressed);

		if (pileHandPressed != null)
			handleCardPressedHand(cardPressed, pileHandPressed);

	}

	protected void handleCardPressedHand(Card cardPressed, Pile pileHandPressed) {

	}

	public void handleCardEntered(Card card, CardNameEnum cardNameEnum) {

		if (this.controller.players().getCurrentPlayer().getDeck().getArrayList().contains(card))
			return;

//		else if (this.controller.players().getOpponent().getDeck().getArrayList().contains(card))
//			return;

		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, true);

	}

	public void handleCardExited(CardNameEnum cardNameEnum) {
		CardIndicatorSingleton.INSTANCE.indicatorSetVisible(cardNameEnum, false);
	}

}
