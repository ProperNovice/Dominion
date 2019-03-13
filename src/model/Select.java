package model;

import controller.Credentials;
import utils.ImageView;
import utils.ImageViewAble;

public class Select implements ImageViewAble {

	public Select() {

		String path = "select.png";

		ImageView imageView = new ImageView(path);
		imageView.setWidth(Credentials.DimensionsSelect.x);
		imageView.setVisible(false);

		map.put(this, imageView);

	}

}
