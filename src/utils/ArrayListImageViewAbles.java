package utils;

import utils.Animation.AnimationSynch;

public abstract class ArrayListImageViewAbles<T> {

	protected ArrayList<T> arrayList = new ArrayList<>();
	protected Coordinates coordinates = null;

	public ArrayListImageViewAbles() {

		createCoordinates();

		if (this.coordinates != null)
			return;

		Logger.log("you didn't create coordinates");
		Logger.log(this.getClass());
		ShutDown.execute();

	}

	protected abstract void createCoordinates();

	public void toFront() {

		ImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (ImageViewAble) this.arrayList.get(counter);
			imageViewAble.getImageView().toFront();

		}

	}

	public void animateAsynchronous() {
		executeAction(ImageViewAction.ANIMATE, AnimationSynch.ASYNCHRONOUS);
	}

	public void animateSynchronous() {
		executeAction(ImageViewAction.ANIMATE, AnimationSynch.SYNCHRONOUS);
	}

	public void relocateImageViews() {
		executeAction(ImageViewAction.RELOCATE, null);
	}

	public void relocateList(double x, double y) {
		this.coordinates.relocateListAndClearCoordinates(x, y);
	}

	public void relocateList(NumbersPair numbersPair) {
		this.coordinates.relocateListAndClearCoordinates(numbersPair);
	}

	private enum ImageViewAction {
		ANIMATE, RELOCATE
	}

	private void executeAction(ImageViewAction imageViewAction, AnimationSynch animationSynch) {

		if (this.coordinates.getRearrangeTypeEnum() == RearrangeTypeEnum.PIVOT)
			this.coordinates.calculateFirstObjectCoordinatesPivot(this.arrayList.size());

		ImageView imageView = null;

		for (T t : this.arrayList) {

			int index = this.arrayList.indexOf(t);
			NumbersPair numbersPair = this.coordinates.getCoordinateIndex(index);

			imageView = ((ImageViewAble) t).getImageView();

			switch (imageViewAction) {

			case ANIMATE:
				Animation.INSTANCE.animate(imageView, numbersPair, animationSynch);
				break;

			case RELOCATE:
				imageView.relocate(numbersPair);
				break;

			}

		}

		toFront();

	}

	public ArrayList<T> getArrayList() {
		return this.arrayList;
	}

}
