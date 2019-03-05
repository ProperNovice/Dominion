package model;

public class IndicatorBuy extends IndicatorActionBuy {

	public IndicatorBuy() {
	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "buy";
	}

}
