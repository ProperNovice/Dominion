package utils;

import gui.PanelGame;

public class Instances {

	private static PanelGame panelGameInstance = null;

	public static void setPanelGameInstance(PanelGame panelGame) {
		panelGameInstance = panelGame;
	}

	public static PanelGame getPanelGameInstance() {
		return panelGameInstance;
	}

}
