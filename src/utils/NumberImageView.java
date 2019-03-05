package utils;

import controller.Credentials;
import enums.ObjectPoolEnum;
import utils.EventHandler.EventHandlerAble;

public class NumberImageView implements ImageViewAble {

	private ObjectPoolSingleton objectPoolSingleton = ObjectPoolSingleton.INSTANCE;
	private HashMapKeySingleton hashMapKeySingleton = HashMapKeySingleton.INSTANCE;
	private EventHandlerAble eventHandlerAble = null;
	private NumberImageViewColorEnum numberImageViewColorEnum = null;

	public NumberImageView(NumberImageViewColorEnum numberImageViewColorEnum) {

		this.numberImageViewColorEnum = numberImageViewColorEnum;
		createList();

	}

	public NumberImageView(int number, NumberImageViewColorEnum numberImageViewColorEnum) {

		this.numberImageViewColorEnum = numberImageViewColorEnum;
		createList();
		setNumber(number);

	}

	public NumberImageView(NumberImageViewColorEnum numberImageViewColorEnum, EventHandlerAble eventHandlerAble) {

		this.numberImageViewColorEnum = numberImageViewColorEnum;
		createList();
		this.eventHandlerAble = eventHandlerAble;

	}

	public NumberImageView(int number, NumberImageViewColorEnum numberImageViewColorEnum,
			EventHandlerAble eventHandlerAble) {

		this.numberImageViewColorEnum = numberImageViewColorEnum;
		createList();
		setNumber(number);
		this.eventHandlerAble = eventHandlerAble;

	}

	private void createList() {

		if (!this.hashMapKeySingleton.isEmpty())
			return;

		this.hashMapKeySingleton.createList(this.numberImageViewColorEnum.string() + "/");

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

	private void setImageView(int listIndex) {

		ObjectPoolAble objectPoolAble = this.hashMapKeySingleton.get(listIndex);
		Image image = (Image) this.objectPoolSingleton.pullObject(objectPoolAble);

		if (map.get(this) != null) {

			this.objectPoolSingleton.releaseObject(ObjectPoolEnum.NUMBER_IMAGEVIEW_ABLE, map.get(this).getImage());
			map.get(this).setImage(image);

		} else {

			if (this.eventHandlerAble == null)
				map.put(this, new ImageView(image));
			else
				map.put(this, new ImageView(image, this.eventHandlerAble));

			map.get(this).setWidth(Credentials.numberImageView);

		}

	}

	public enum NumberImageViewColorEnum {

		GRAY("gray"), BLACK("black");

		private String string = null;

		private NumberImageViewColorEnum(String string) {
			this.string = string;
		}

		public String string() {
			return this.string;
		}

	}

	private enum HashMapKeySingleton {

		INSTANCE;

		private ArrayList<NumberImageViewObjectPoolAble> list = new ArrayList<>();
		private String pathNumbers = "numbers/", pathPng = ".png";

		public void createList(String colorString) {

			for (int counter = 0; counter <= 20; counter++)
				this.list.addLast(new NumberImageViewObjectPoolAble(getPath(colorString + Integer.toString(counter))));

			this.list.addLast(new NumberImageViewObjectPoolAble(getPath(colorString + "infinity")));
			this.list.addLast(new NumberImageViewObjectPoolAble(getPath(colorString + "phi")));
			this.list.addLast(new NumberImageViewObjectPoolAble(getPath(colorString + "x")));

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
				createObjectPoolSingletonInstance();

			}

			@Override
			public Object getObject() {
				return new Image(this.path);
			}

			@Override
			public void createObjectPoolSingletonInstance() {
				ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.NUMBER_IMAGEVIEW_ABLE, this);
			}

		}

	}

}
