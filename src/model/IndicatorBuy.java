package model;

public class IndicatorBuy extends Indicator {

	public IndicatorBuy() {
	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "buy";
	}

}
