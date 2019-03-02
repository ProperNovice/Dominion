package utils;

public class Coordinates {

	private double x, y, width, height, gapX, gapY;
	private int objectsPerRow;
	private double firstObjectX, firstObjectY;
	private RearrangeTypeEnum rearrangeTypeEnum;
	private DirectionEnum directionEnumHorizontal, directionEnumVertical;
	private ArrayList<NumbersPair> coordinates = new ArrayList<>();
	private int arrayListSize = -1;

	public Coordinates(double x, double y, double width, double height, double gapX, double gapY, int objectsPerRow,
			RearrangeTypeEnum rearrangeTypeEnum, DirectionEnum directionEnumHorizontal,
			DirectionEnum directionEnumVertical) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gapX = gapX;
		this.gapY = gapY;
		this.objectsPerRow = objectsPerRow;
		this.rearrangeTypeEnum = rearrangeTypeEnum;
		this.directionEnumHorizontal = directionEnumHorizontal;
		this.directionEnumVertical = directionEnumVertical;

		calculateFirstObjectCoordinates();

	}

	public NumbersPair getCoordinateIndex(int index) {

		if (this.coordinates.size() >= index + 1)
			return this.coordinates.get(index);

		createCoordinates(index);

		return this.coordinates.get(index);

	}

	private void createCoordinates(int index) {

		for (int counter = 0; counter <= index; counter++) {

			if (this.coordinates.size() >= index + 1)
				continue;

			addCoordinateToList(index);

		}

	}

	public void relocateArrayListAndClearCoordinates(double x, double y) {

		this.x = x;
		this.y = y;

		this.coordinates.clear();
		calculateFirstObjectCoordinates();

	}

	public void relocateArrayListAndClearCoordinates(NumbersPair numbersPair) {
		relocateArrayListAndClearCoordinates(numbersPair.x, numbersPair.y);
	}

	public void calculateFirstObjectCoordinatesPivot(int arrayListSize) {

		this.arrayListSize = arrayListSize;
		calculateFirstObjectCoordinates();

	}

	private void calculateFirstObjectCoordinates() {

		switch (this.rearrangeTypeEnum) {

		case LINEAR:
			this.firstObjectX = this.x;
			this.firstObjectY = this.y;
			break;

		case PIVOT:

			int rows, columns;

			if (this.objectsPerRow == -1) {

				rows = 1;
				columns = this.arrayListSize;

			} else {

				rows = (int) (Math.ceil((double) this.arrayListSize / this.objectsPerRow));
				columns = (int) Math.min(this.arrayListSize, this.objectsPerRow);

			}

			double width = this.width;
			double height = this.height;

			double totalX = width + (columns - 1) * (width + this.gapX);
			double totalY = height + (rows - 1) * (height + this.gapY);

			switch (this.directionEnumHorizontal) {

			case RIGHT:
				this.firstObjectX = this.x - totalX / 2;
				break;

			case LEFT:
				this.firstObjectX = this.x + totalX / 2;
				break;

			default:
				logErrorShutDown(this.directionEnumHorizontal);
				break;

			}

			switch (this.directionEnumVertical) {

			case DOWN:
				this.firstObjectY = this.y - totalY / 2;
				break;

			case UP:
				this.firstObjectY = this.y + totalY / 2;
				break;

			default:
				logErrorShutDown(this.directionEnumVertical);
				break;

			}

			break;

		case STATIC:
			this.firstObjectX = this.x;
			this.firstObjectY = this.y;
			break;

		}

	}

	private void addCoordinateToList(int index) {

		double coordinateX = 0, coordinateY = 0;

		int row, column;

		if (this.objectsPerRow == -1) {

			row = 0;
			column = index;

		} else {

			row = index / this.objectsPerRow;
			column = index - row * this.objectsPerRow;

		}

		double x = column * (this.width + this.gapX);
		double y = row * (this.height + this.gapY);

		switch (this.directionEnumHorizontal) {

		case RIGHT:
			coordinateX = this.firstObjectX + x;
			break;

		case LEFT:
			coordinateX = this.firstObjectX - x;
			break;

		default:
			logErrorShutDown(this.directionEnumHorizontal);
			break;

		}

		switch (this.directionEnumVertical) {

		case DOWN:
			coordinateY = this.firstObjectY + y;
			break;

		case UP:
			coordinateY = this.firstObjectY - y;
			break;

		default:
			logErrorShutDown(this.directionEnumVertical);
			break;

		}

		this.coordinates.addLast(new NumbersPair(coordinateX, coordinateY));

	}

	private void logErrorShutDown(DirectionEnum directionEnum) {

		Logger.log("ArrayListImageView direction error:");
		Logger.log(directionEnum);
		ShutDown.execute();

	}

	public RearrangeTypeEnum getRearrangeTypeEnum() {
		return this.rearrangeTypeEnum;
	}

}
