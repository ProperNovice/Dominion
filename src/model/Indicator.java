package model;

import controller.Credentials;
import utils.ImageView;
import utils.ImageViewAble;

public abstract class Indicator implements ImageViewAble {

	protected String pathIndicator = null;

	public Indicator() {
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
