package model;

public class IndicatorAction extends IndicatorActionBuy {

	public IndicatorAction() {

	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "action";
	}

}
