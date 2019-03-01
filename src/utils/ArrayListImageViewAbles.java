package utils;

import utils.Animation.AnimationSynch;

public abstract class ArrayListImageViewAbles<T> {

	protected double x = 0, y = 0, gapX = 0, gapY = 0;
	protected int imageViewsPerRow = -1, maxCapacity = -1;
	protected RearrangeType rearrangeType = RearrangeType.LINEAR;
	protected DirectionEnum directionHorizontal = DirectionEnum.RIGHT, directionVertical = DirectionEnum.DOWN;
	protected ArrayList<T> arrayList = null;

	public ArrayListImageViewAbles() {

		setValues();
		createList();

	}

	private void createList() {
		this.arrayList = new ArrayList<>(this.maxCapacity);
	}

	protected void toFront() {

		ImageViewAble imageViewAble = null;

		for (int counter = this.arrayList.size() - 1; counter >= 0; counter--) {

			imageViewAble = (ImageViewAble) this.arrayList.get(counter);
			imageViewAble.getImageView().toFront();

		}

	}

	protected abstract void setValues();

	public void animateAsynchronous() {
		handleAnimateRelocate(ImageViewAction.ANIMATE, AnimationSynch.ASYNCHRONOUS);
	}

	public void animateSynchronous() {
		handleAnimateRelocate(ImageViewAction.ANIMATE, AnimationSynch.SYNCHRONOUS);
	}

	public void relocateImageViews() {
		handleAnimateRelocate(ImageViewAction.RELOCATE, null);
	}

	public void relocateArrayList(double x, double y) {
		this.x = x;
		this.y = y;
	}

	private enum ImageViewAction {
		ANIMATE, RELOCATE
	}

	private void handleAnimateRelocate(ImageViewAction imageViewAction, AnimationSynch animationSynch) {

		double coordinateX = 0, coordinateY = 0;

		switch (this.rearrangeType) {

		case LINEAR:
			coordinateX = this.x;
			coordinateY = this.y;
			break;

		case PIVOT:

			int rows = (int) (Math.ceil((double) this.arrayList.size() / this.imageViewsPerRow));
			int columns = (int) Math.min(this.arrayList.size(), this.imageViewsPerRow);

			double width = ((ImageViewAble) this.arrayList.getFirst()).getImageView().getWidth();
			double height = ((ImageViewAble) this.arrayList.getFirst()).getImageView().getHeight();

			double totalX = width + (columns - 1) * (width + this.gapX);
			double totalY = height + (rows - 1) * (height + this.gapY);

			switch (this.directionHorizontal) {

			case RIGHT:
				coordinateX = this.x - totalX / 2;
				break;

			case LEFT:
				coordinateX = this.x + totalX / 2;
				break;

			default:
				Logger.log("ArrayListImageView direction horizontal error:");
				Logger.log(this.getClass());
				ShutDown.execute();
				break;

			}

			switch (this.directionVertical) {

			case DOWN:
				coordinateY = this.y - totalY / 2;
				break;

			case UP:
				coordinateY = this.y + totalY / 2;
				break;

			default:
				Logger.log("ArrayListImageView direction vertical error:");
				Logger.log(this.getClass());
				ShutDown.execute();
				break;

			}

			break;

		case STATIC:
			coordinateX = this.x;
			coordinateY = this.y;
			break;

		}

		executeAnimateRelocate(imageViewAction, animationSynch, coordinateX, coordinateY);
		toFront();

	}

	private void executeAnimateRelocate(ImageViewAction imageViewAction, AnimationSynch animationSynch,
			double coordinateX, double coordinateY) {

		double coordinateTempX = coordinateX, coordinateTempY = coordinateY;

		int positionInRow = 1;
		ImageView imageView = null;

		for (T t : this.arrayList) {

			imageView = ((ImageViewAble) t).getImageView();

			switch (imageViewAction) {

			case ANIMATE:
				Animation.INSTANCE.animate(imageView, coordinateTempX, coordinateTempY, animationSynch);
				break;

			case RELOCATE:
				imageView.relocate(coordinateTempX, coordinateTempY);
				break;

			}

			if (this.rearrangeType == RearrangeType.STATIC)
				continue;

			if (this.imageViewsPerRow == -1 || positionInRow < this.imageViewsPerRow) {

				switch (this.directionHorizontal) {

				case RIGHT:
					coordinateTempX += this.gapX + imageView.getWidth();
					break;

				case LEFT:
					coordinateTempX -= this.gapX + imageView.getWidth();
					break;

				default:
					break;

				}

				positionInRow++;

			} else {

				coordinateTempX = coordinateX;

				switch (this.directionVertical) {

				case DOWN:
					coordinateTempY += this.gapY + imageView.getHeight();
					break;

				case UP:
					coordinateTempY -= this.gapY + imageView.getHeight();
					break;

				default:
					break;

				}

				positionInRow = 1;

			}

		}

	}

	public ArrayList<T> getArrayList() {
		return this.arrayList;
	}

	protected enum RearrangeType {
		LINEAR, PIVOT, STATIC
	}

	protected enum DirectionEnum {
		LEFT, RIGHT, UP, DOWN
	}

}
