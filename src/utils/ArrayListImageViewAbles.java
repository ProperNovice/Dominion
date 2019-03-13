package utils;

import utils.Animation.AnimationSynch;

public abstract class ArrayListImageViewAbles<T> implements ListSizeAble {

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

	public void toBack() {

		ImageViewAble imageViewAble = null;

		for (T t : this.arrayList) {

			imageViewAble = (ImageViewAble) t;
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
		this.coordinates.relocateList(x, y);
	}

	public void relocateList(NumbersPair numbersPair) {
		this.coordinates.relocateList(numbersPair);
	}

	private enum ImageViewAction {
		ANIMATE, RELOCATE
	}

	private void executeAction(ImageViewAction imageViewAction, AnimationSynch animationSynch) {

		ImageView imageView = null;

		for (T t : this.arrayList) {

			int index = this.arrayList.indexOf(t);
			NumbersPair numbersPair = this.coordinates.getCoordinate(index);

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

	@Override
	public int getSize() {
		return this.arrayList.size();
	}

}
