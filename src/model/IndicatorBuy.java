package model;

public class IndicatorBuy extends IndicatorActionBuyTreasure {

	public IndicatorBuy() {

	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "buy";
	}

}
