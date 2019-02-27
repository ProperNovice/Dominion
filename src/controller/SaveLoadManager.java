package controller;

import utils.ArrayList;
import utils.SaveLoadAble;

public class SaveLoadManager {

	private ArrayList<SaveLoadAble> list = new ArrayList<>();

	public SaveLoadManager() {
		createList();
	}

	private void createList() {

	}

	public void saveState() {

		for (SaveLoadAble saveLoadAble : this.list)
			saveLoadAble.saveState();

	}

	public void loadState() {

		for (SaveLoadAble saveLoadAble : this.list)
			saveLoadAble.loadState();

	}

}
