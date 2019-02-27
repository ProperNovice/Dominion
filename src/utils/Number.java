package utils;

import controller.Credentials;

public class Number implements ImageViewAble {

	private String pathNumbers = "numbers/", pathPng = ".png";
	private boolean imageViewCreated = false;

	public Number() {

	}

	public void setNumber(int value) {

		if (value > 20)
			ShutDown.execute("@" + this.getClass());

		setImageView(Integer.toString(value));

	}

	public void setInfinity() {
		setImageView("infinity");
	}

	public void setPhi() {
		setImageView("phi");
	}

	public void setX() {
		setImageView("x");
	}

	public void relocate(double x, double y) {
		map.get(this).relocate(x, y);
	}

	public void setVisible(boolean value) {
		map.get(this).setVisible(value);
	}

	public void setDimension(double value) {
		map.get(this).setWidth(value);
	}

	private String getPath(String pathTemp) {
		return this.pathNumbers + pathTemp + this.pathPng;
	}

	private void setImageView(String pathTemp) {

		if (this.imageViewCreated)
			map.get(this).setImage(new Image(getPath(pathTemp)));
		else
			createAndAddImageView(pathTemp);

	}

	private void createAndAddImageView(String pathTemp) {

		this.imageViewCreated = true;
		map.put(this, new ImageView(getPath(pathTemp)));
		map.get(this).setWidth(Credentials.number);

	}

	@Override
	public void zCreateAndAddImageView() {

	}

}
