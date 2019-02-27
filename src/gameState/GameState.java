package gameState;

import controller.Controller;
import enums.TextEnum;
import javafx.scene.input.KeyCode;
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

}
