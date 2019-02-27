package gui;

import utils.Instances;
import utils.Parent;
import utils.PlatformFX;
import controller.Controller;

public class PanelGame extends Parent {

	private Panel panel = null;

	public PanelGame(Panel panel) {

		this.panel = panel;
		Instances.setPanelGameInstance(this);
		new Controller();

	}

	public void restartGame() {

		PlatformFX.runLater(() -> {

			this.panel.removeCurrentPanelGame();
			this.panel.createNewPanelGame();
			this.panel.startGame();

		});

	}

}
