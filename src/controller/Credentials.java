package controller;

import utils.NumbersPair;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets, DimensionsCard, DimensionsGapBetweenCards;
	public static NumbersPair CoordinatesTextPanel, CoordinatesSupply, CoordinatesDeckHuman,
			CoordinatesDiscardPileHuman, CoordinatesHandHuman, CoordinatesCardDrawHuman;
	public static double gapBetweenBorders, textHeight, numberImageView, cardIndicatorWidth;

	public static void calculateCredentials() {

		double x, y;

//		DimensionsFrame = new NumbersPair(1366, 788);
		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 20;

		CoordinatesTextPanel = new NumbersPair(0, 0);

		textHeight = 50;
		cardIndicatorWidth = 200;
		DimensionsGapBetweenCards = new NumbersPair(5, 5);

		CoordinatesSupply = new NumbersPair(gapBetweenBorders, gapBetweenBorders);
		DimensionsCard = new NumbersPair(100, 162);
		numberImageView = DimensionsCard.x * 0.35;

		DimensionsFrame = new NumbersPair(
				14 * DimensionsCard.x + 13 * DimensionsGapBetweenCards.x + 2 * gapBetweenBorders,
				5 * DimensionsCard.y + 4 * DimensionsGapBetweenCards.y + 2 * gapBetweenBorders);

		x = CoordinatesSupply.x + 2 * (DimensionsCard.x + DimensionsGapBetweenCards.x)
				+ 2 * DimensionsGapBetweenCards.x;
		y = CoordinatesSupply.y + 3 * (DimensionsCard.y + DimensionsGapBetweenCards.y);
		CoordinatesDiscardPileHuman = new NumbersPair(x, y);

		x = CoordinatesDiscardPileHuman.x + DimensionsCard.x + DimensionsGapBetweenCards.x;
		y = CoordinatesDiscardPileHuman.y;
		CoordinatesDeckHuman = new NumbersPair(x, y);

		x = DimensionsFrame.x / 2;
		y = DimensionsFrame.y - gapBetweenBorders - DimensionsCard.y / 2;
		CoordinatesHandHuman = new NumbersPair(x, y);

		x = CoordinatesDeckHuman.x + 2 * (DimensionsCard.x + DimensionsGapBetweenCards.x);
		y = CoordinatesDeckHuman.y;
		CoordinatesCardDrawHuman = new NumbersPair(x, y);

	}

}
