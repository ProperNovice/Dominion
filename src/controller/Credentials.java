package controller;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets;
	public static NumbersPair CoordinatesTextPanel, CoordinatesSupply;
	public static double gapBetweenBorders, textHeight, number, cardGameWidth, cardIndicatorWidth, gapBetweenCards;

	public static class NumbersPair {

		public double x;
		public double y;

		public NumbersPair(double x, double y) {

			this.x = x;
			this.y = y;

		}

	}

	public static void calculateCredentials() {

		DimensionsFrame = new NumbersPair(1366, 788);
		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 20;

		CoordinatesTextPanel = new NumbersPair(0, 0);

		textHeight = 50;
		cardGameWidth = 100;
		number = cardGameWidth / 2;
		cardIndicatorWidth = 200;
		gapBetweenCards = 10;

		CoordinatesSupply = new NumbersPair(20, 20);

	}

}
