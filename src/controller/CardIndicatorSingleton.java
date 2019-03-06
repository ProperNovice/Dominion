package controller;

import enums.CardNameEnum;
import utils.HashMap;
import utils.ImageView;

public enum CardIndicatorSingleton {

	INSTANCE;

	private HashMap<CardNameEnum, ImageView> list = new HashMap<CardNameEnum, ImageView>();

	public void indicatorSetVisible(CardNameEnum cardNameEnum, boolean value) {

		for (CardNameEnum cardNameEnumTemp : this.list)
			if (cardNameEnum == cardNameEnumTemp)
				this.list.get(cardNameEnumTemp).setVisible(value);
			else
				this.list.get(cardNameEnumTemp).setVisible(false);

	}

	public void createIndicator(CardNameEnum cardNameEnum) {

		if (this.list.containsKey(cardNameEnum))
			return;

		ImageView imageView = new ImageView("cards/" + cardNameEnum.getString() + ".jpg");
		imageView.setVisible(false);

		this.list.put(cardNameEnum, imageView);
		imageView.relocate(Credentials.CoordinatesCardIndicator);

	}

}
