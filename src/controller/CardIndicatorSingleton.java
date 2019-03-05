package controller;

import enums.CardNameEnum;
import utils.HashMap;
import utils.ImageView;
import utils.Logger;

public enum CardIndicatorSingleton {

	INSTANCE;

	private HashMap<CardNameEnum, ImageView> list = new HashMap<CardNameEnum, ImageView>();

	public void indicatorSetVisible(CardNameEnum cardNameEnum, boolean value) {

		checkIfExistsAndCreateOtherwise(cardNameEnum);
		this.list.get(cardNameEnum).setVisible(value);

	}

	private void checkIfExistsAndCreateOtherwise(CardNameEnum cardNameEnum) {

		if (this.list.containsKey(cardNameEnum))
			return;

		ImageView imageView = new ImageView("cards/" + cardNameEnum.getString() + ".jpg");

		this.list.put(cardNameEnum, imageView);
		imageView.relocate(Credentials.CoordinatesCardIndicator);

		Logger.log("created new indicator");
		Logger.log(cardNameEnum);
		Logger.newLine();

	}

}
