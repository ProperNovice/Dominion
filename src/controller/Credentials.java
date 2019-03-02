package controller;

import utils.NumbersPair;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets, DimensionsCard, DimensionsGapBetweenCards;
	public static NumbersPair CoordinatesTextPanel, CoordinatesSupply;
	public static double gapBetweenBorders, textHeight, numberImageView, cardIndicatorWidth;

	public static void calculateCredentials() {

		DimensionsFrame = new NumbersPair(1366, 788);
		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 20;

		CoordinatesTextPanel = new NumbersPair(0, 0);

		textHeight = 50;
		cardIndicatorWidth = 200;
		DimensionsGapBetweenCards = new NumbersPair(5, 5);

		CoordinatesSupply = new NumbersPair(gapBetweenBorders, gapBetweenBorders);
		DimensionsCard = new NumbersPair(100, 162);
		numberImageView = DimensionsCard.x * 0.35;

	}

}
