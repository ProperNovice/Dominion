package controller;

import utils.ArrayList;
import utils.SaveLoadAble;

public class SaveLoadManager {

	private ArrayList<SaveLoadAble> list = new ArrayList<>();

	public SaveLoadManager() {

	}

	public void setList(ArrayList<SaveLoadAble> list) {
		this.list = list;
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
