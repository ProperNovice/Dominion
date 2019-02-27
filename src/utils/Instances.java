package utils;

import gui.PanelGame;
import controller.Controller;

public class Instances {

	private static PanelGame panelGameInstance = null;
	private static Controller controllerInstance = null;

	public static void setPanelGameInstance(PanelGame panelGame) {
		panelGameInstance = panelGame;
	}

	public static void setControllerInstance(Controller controller) {
		controllerInstance = controller;
	}

	public static PanelGame getPanelGameInstance() {
		return panelGameInstance;
	}

	public static Controller getControllerInstance() {
		return controllerInstance;
	}

}
