package gameState;

import controller.CardIndicatorSingleton;
import controller.Controller;
import enums.CardAbilityEnum;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.PhaseEnum;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
import model.Card;
import utils.ArrayList;
import utils.HashMap;
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

	public final void handleCardPressed(Card card, CardNameEnum cardNameEnum, ArrayList<CardTypeEnum> cardTypeEnum,
			HashMap<PhaseEnum, ArrayList<CardAbilityEnum>> abilities, int buyCost) {

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
