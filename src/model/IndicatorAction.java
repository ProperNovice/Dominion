package model;

public class IndicatorAction extends IndicatorActionBuyTreasure {

	public IndicatorAction() {

	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "action";
	}

}
