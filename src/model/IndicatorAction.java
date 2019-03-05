package model;

public class IndicatorAction extends Indicator {

	public IndicatorAction() {
	}

	@Override
	protected void createPathIndicator() {
		super.pathIndicator = "action";
	}

}
