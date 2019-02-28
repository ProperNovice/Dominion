package utils;

import controller.Credentials;

public class NumberImageView implements ImageViewAble {

	private boolean imageViewCreated = false;
	private ObjectPoolSingleton objectPoolSingleton = ObjectPoolSingleton.INSTANCE;
	private HashMapKeySingleton hashMapKeySingleton = HashMapKeySingleton.INSTANCE;

	public NumberImageView() {
		createList();
	}

	public NumberImageView(int number) {
		createList();
		setNumber(number);
	}

	private void createList() {

		if (!hashMapKeySingleton.isEmpty())
			return;

		hashMapKeySingleton.createList();
	}

	public void setNumber(int value) {

		if (value > 20)
			ShutDown.execute("@" + this.getClass());

		setImageView(value);

	}

	public void setInfinity() {
		setImageView(21);
	}

	public void setPhi() {
		setImageView(22);
	}

	public void setX() {
		setImageView(23);
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

	private void setImageView(int listIndex) {

		ObjectPoolAble objectPoolAble = this.hashMapKeySingleton.get(listIndex);
		Image image = (Image) this.objectPoolSingleton.pullObject(objectPoolAble);

		if (this.imageViewCreated) {
			objectPoolSingleton.releaseObject(map.get(this).getImage(), objectPoolAble);
			map.get(this).setImage(image);
		} else
			createAndAddImageView(image);

	}

	private void createAndAddImageView(Image image) {

		this.imageViewCreated = true;
		map.put(this, new ImageView(image));
		map.get(this).setWidth(Credentials.number);

	}

	private enum HashMapKeySingleton {

		INSTANCE;

		private ArrayList<NumberImageViewObjectPoolAble> list = new ArrayList<>();
		private String pathNumbers = "numbers/", pathPng = ".png";

		public void createList() {

			for (int counter = 0; counter <= 20; counter++)
				this.list.addLast(new NumberImageViewObjectPoolAble(getPath(Integer.toString(counter))));

			this.list.addLast(new NumberImageViewObjectPoolAble(getPath("infinity")));
			this.list.addLast(new NumberImageViewObjectPoolAble(getPath("phi")));
			this.list.addLast(new NumberImageViewObjectPoolAble(getPath("x")));

		}

		public NumberImageViewObjectPoolAble get(int index) {
			return this.list.get(index);
		}

		private String getPath(String pathTemp) {
			return this.pathNumbers + pathTemp + this.pathPng;
		}

		public boolean isEmpty() {
			return this.list.isEmpty();
		}

		private class NumberImageViewObjectPoolAble implements ObjectPoolAble {

			private String path = null;

			public NumberImageViewObjectPoolAble(String path) {
				this.path = path;
			}

			@Override
			public Object getObject() {
				return new Image(this.path);
			}

		}

	}

}
