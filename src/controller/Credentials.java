package controller;

import utils.NumbersPair;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets, DimensionsCard, DimensionsGapBetweenCards,
			DimensionsActionBuyIndicators;
	public static NumbersPair CoordinatesTextPanel, CoordinatesSupply, CoordinatesDeckHuman, CoordinatesKingdom,
			CoordinatesDiscardPileHuman, CoordinatesHandHuman, CoordinatesCardIndicator, CoordinatesActionBuyIndicators;
	public static double gapBetweenBorders, textHeight, numberImageView, cardIndicatorWidth, actionBuyIndicatorsWidth;

	public static void calculateCredentials() {

		double x, y;

//		DimensionsFrame = new NumbersPair(1366, 788);
		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 10;

		CoordinatesTextPanel = new NumbersPair(0, 0);

		textHeight = 50;
		cardIndicatorWidth = 200;
		actionBuyIndicatorsWidth = 50;
		DimensionsGapBetweenCards = new NumbersPair(2, 2);
		DimensionsActionBuyIndicators = new NumbersPair(50, 50);

		CoordinatesSupply = new NumbersPair(gapBetweenBorders, gapBetweenBorders);
		DimensionsCard = new NumbersPair(100, 160);
		numberImageView = DimensionsCard.x * 0.35;

		int totalCardsWidth = 14;
		DimensionsFrame = new NumbersPair(
				totalCardsWidth * DimensionsCard.x + (totalCardsWidth - 1) * DimensionsGapBetweenCards.x
						+ 2 * gapBetweenBorders,
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

		x = DimensionsFrame.x / 2 - (5 * DimensionsCard.x + 4 * DimensionsGapBetweenCards.x) / 2;
		y = gapBetweenBorders;
		CoordinatesKingdom = new NumbersPair(x, y);

		x = DimensionsFrame.x - gapBetweenBorders - cardIndicatorWidth;
		y = gapBetweenBorders;
		CoordinatesCardIndicator = new NumbersPair(x, y);

		x = CoordinatesDeckHuman.x + DimensionsCard.x + DimensionsGapBetweenCards.x;
		y = CoordinatesDeckHuman.y + DimensionsCard.y - DimensionsActionBuyIndicators.y;
		CoordinatesActionBuyIndicators = new NumbersPair(x, y);

	}

}
