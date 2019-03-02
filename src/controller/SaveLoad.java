package controller;

import utils.ArrayList;
import utils.SaveLoadAble;

public class SaveLoad {

	private ArrayList<SaveLoadAble> list = new ArrayList<>();

	public SaveLoad() {

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
