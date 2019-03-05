package model;

import controller.Credentials;
import utils.ImageView;
import utils.ImageViewAble;

public abstract class IndicatorActionBuy implements ImageViewAble {

	protected String pathIndicator = null;

	public IndicatorActionBuy() {
		createPathIndicator();
		createImageView();
	}

	protected abstract void createPathIndicator();

	private void createImageView() {

		String path = this.pathIndicator + ".png";
		ImageView imageView = new ImageView(path);
		imageView.setWidth(Credentials.actionBuyIndicatorsWidth);
		imageView.setVisible(false);

		map.put(this, imageView);

	}

}
