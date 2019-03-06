package gameState;

import controller.CardIndicatorSingleton;
import controller.Controller;
import enums.CardNameEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Card;
import utils.Instances;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public abstract void handleGameStateChange();

	public final void handleTextOptionPressed(TextEnum textEnum) {

		this.controller.text().concealText();
		executeTextOptionPressed(textEnum);

	}

	public void executeTextOptionPressed(TextEnum textEnum) {

	}

	public void executeKeyPressed(KeyCode keyCode) {

		switch (keyCode) {

		case Q:
			executeKeyPressedQ();
			break;

		case W:
			executeKeyPressedW();
			break;

		case E:
			executeKeyPressedE();
			break;

		default:
			break;

		}

	}

	protected void executeKeyPressedQ() {

	}

	protected void executeKeyPressedW() {

	}

	protected void executeKeyPressedE() {

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
