package utils;

public interface ImageViewAble {

	public static HashMap<Object, ImageView> map = new HashMap<>();

	public default ImageView getImageView() {
		return ImageViewAble.map.get(this);
	}

	public void zCreateAndAddImageView();

}
