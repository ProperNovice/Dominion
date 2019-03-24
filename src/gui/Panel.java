package gui;

import enums.GameStateEnum;
import javafx.scene.image.ImageView;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.Instances;
import utils.Parent;
import utils.ShutDown;

public class Panel extends Parent implements EventHandlerAble {

	private ImageView background = new ImageView("/images/misc/background.png");
	private PanelGame panelGame = null;

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(new EventHandler(this));

		this.getChildren().add(this.background);

		createNewPanelGame();

	}

	public void removeCurrentPanelGame() {

		this.panelGame.setVisible(false);
		this.getChildren().remove(this.panelGame);

	}

	public void createNewPanelGame() {

		this.panelGame = new PanelGame(this);
		this.getChildren().add(this.panelGame);

	}

	public void startGame() {

		Executor.runLater(() -> Instances.getControllerInstance().gameState().setGameState(GameStateEnum.START_GAME));

	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		ShutDown.execute();
	}

}
