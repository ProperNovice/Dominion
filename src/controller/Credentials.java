package controller;

import utils.NumbersPair;

public class Credentials {

	public static NumbersPair DimensionsFrame, DimensionsInsets, DimensionsCardHuman, DimensionsCardAI,
			DimensionsGapBetweenCards, DimensionsActionBuyIndicators, DimensionsSelect;
	public static NumbersPair CoordinatesTextPanel, CoordinatesSupply, CoordinatesDeckHuman, CoordinatesDeckAI,
			CoordinatesKingdom, CoordinatesDiscardPileHuman, CoordinatesDiscardPileAI, CoordinatesHandHuman,
			CoordinatesHandAI, CoordinatesCardIndicator, CoordinatesActionBuyIndicatorsHuman,
			CoordinatesActionBuyIndicatorsAI, CoordinatesPlayArea, CoordinatesScoreHuman, CoordinatesScoreAI;
	public static double gapBetweenBorders, textHeight, numberImageView, cardIndicatorWidth;

	public static void calculateCredentials() {

		double x, y;

//		DimensionsFrame = new NumbersPair(1366, 788);
		DimensionsInsets = new NumbersPair(7, 29);
		gapBetweenBorders = 10;

		textHeight = 40;
		cardIndicatorWidth = 200;
		DimensionsGapBetweenCards = new NumbersPair(4, 6);

		CoordinatesSupply = new NumbersPair(gapBetweenBorders, gapBetweenBorders);
		DimensionsCardHuman = new NumbersPair(105, 166);

		DimensionsActionBuyIndicators = new NumbersPair(DimensionsCardHuman.x / 3, DimensionsCardHuman.x / 3);
		numberImageView = DimensionsCardHuman.x * 0.35;

		int totalCardsWidth = 13;
		DimensionsFrame = new NumbersPair(
				totalCardsWidth * DimensionsCardHuman.x + (totalCardsWidth - 1) * DimensionsGapBetweenCards.x
						+ 2 * gapBetweenBorders,
				5 * DimensionsCardHuman.y + 4 * DimensionsGapBetweenCards.y + 2 * gapBetweenBorders);

		x = CoordinatesSupply.x + 2 * (DimensionsCardHuman.x + DimensionsGapBetweenCards.x)
				+ 2 * DimensionsGapBetweenCards.x;
		y = CoordinatesSupply.y + 3 * (DimensionsCardHuman.y + DimensionsGapBetweenCards.y);
		CoordinatesDiscardPileHuman = new NumbersPair(x, y);

		x = CoordinatesDiscardPileHuman.x + DimensionsCardHuman.x + DimensionsGapBetweenCards.x;
		y = CoordinatesDiscardPileHuman.y;
		CoordinatesDeckHuman = new NumbersPair(x, y);

		x = DimensionsFrame.x / 2;
		y = DimensionsFrame.y - gapBetweenBorders - DimensionsCardHuman.y / 2;
		CoordinatesHandHuman = new NumbersPair(x, y);

		x = DimensionsFrame.x / 2 - (5 * DimensionsCardHuman.x + 4 * DimensionsGapBetweenCards.x) / 2;
		y = gapBetweenBorders;
		CoordinatesKingdom = new NumbersPair(x, y);

		x = DimensionsFrame.x - gapBetweenBorders - cardIndicatorWidth;
		y = gapBetweenBorders;
		CoordinatesCardIndicator = new NumbersPair(x, y);

		x = CoordinatesDeckHuman.x + DimensionsCardHuman.x + DimensionsGapBetweenCards.x;
		y = CoordinatesDeckHuman.y;
		CoordinatesActionBuyIndicatorsHuman = new NumbersPair(x, y);

		x = DimensionsFrame.x / 2;
		y = gapBetweenBorders + 2 * (DimensionsCardHuman.y + DimensionsGapBetweenCards.y) + DimensionsCardHuman.y / 2;
		CoordinatesPlayArea = new NumbersPair(x, y);

		x = DimensionsFrame.x / 2 - 100;
		y = DimensionsFrame.y - gapBetweenBorders - 3 * DimensionsCardHuman.y / 2 - DimensionsGapBetweenCards.y;
		CoordinatesTextPanel = new NumbersPair(x, y);

		x = DimensionsCardHuman.x / 2;
		DimensionsSelect = new NumbersPair(x, x);

//		x = 0.75;
		x = 1;
		DimensionsCardAI = new NumbersPair(DimensionsCardHuman.x * x, DimensionsCardHuman.y * x);

		x = DimensionsFrame.x - gapBetweenBorders - DimensionsCardAI.x;
		y = gapBetweenBorders + 2 * (DimensionsCardHuman.y + DimensionsGapBetweenCards.y);
		CoordinatesDiscardPileAI = new NumbersPair(x, y);

		x = CoordinatesDiscardPileAI.x - DimensionsCardAI.x - DimensionsGapBetweenCards.x;
		y = CoordinatesDiscardPileAI.y;
		CoordinatesDeckAI = new NumbersPair(x, y);

		x = CoordinatesDiscardPileAI.x;
		y = CoordinatesDiscardPileAI.y + DimensionsCardAI.y + DimensionsGapBetweenCards.y;
		CoordinatesHandAI = new NumbersPair(x, y);

		x = CoordinatesDeckAI.x - DimensionsActionBuyIndicators.x - DimensionsGapBetweenCards.x;
		y = CoordinatesDeckAI.y;
		CoordinatesActionBuyIndicatorsAI = new NumbersPair(x, y);

		x = gapBetweenBorders + 2 * (DimensionsCardHuman.x + DimensionsGapBetweenCards.x);
		y = gapBetweenBorders;
		CoordinatesScoreHuman = new NumbersPair(x, y);

		x = CoordinatesScoreHuman.x;
		y = CoordinatesScoreHuman.y + textHeight;
		CoordinatesScoreAI = new NumbersPair(x, y);

	}

}
