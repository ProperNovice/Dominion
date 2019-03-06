package model;

import utils.Image;

public class IndicatorTreasure extends IndicatorActionBuyTreasure {

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "numbers/black/0";
	}

	public void setTreasure(int treasure) {
		map.get(this).setImage(new Image("numbers/black/" + treasure + ".png"));
	}

}
