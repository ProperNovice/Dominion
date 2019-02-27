package controller;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets;
	public static NumbersPair CoordinatesTextPanel, CoordinatesExperimental;
	public static double gapBetweenBorders, textHeight, number;

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

		CoordinatesTextPanel = new NumbersPair(50, 50);
		CoordinatesExperimental = new NumbersPair(600, 300);

		textHeight = 50;
		number = 100;

	}

}
