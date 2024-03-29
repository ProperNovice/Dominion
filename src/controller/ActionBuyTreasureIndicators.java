package controller;

import enums.ObjectPoolEnum;
import enums.PlayerEnum;
import model.IndicatorAction;
import model.IndicatorActionBuyTreasure;
import model.IndicatorBuy;
import model.IndicatorTreasure;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.DirectionEnum;
import utils.ObjectPoolSingleton;

public class ActionBuyTreasureIndicators extends ArrayListImageViewAbles<IndicatorActionBuyTreasure> {

	private ArrayList<IndicatorAction> listAction = new ArrayList<>();
	private ArrayList<IndicatorBuy> listBuy = new ArrayList<>();
	private ArrayList<IndicatorTreasure> listTreasure = new ArrayList<>();
	private int actions = 0, buys = 0, treasure = 0;
	private Coordinates coordinatesHuman = null, coordinatesAI = null;

	public ActionBuyTreasureIndicators() {

		this.coordinatesHuman = new CoordinatesBuilder()
				.dimensionsNumbersPair(Credentials.DimensionsActionBuyIndicators)
				.coordinatesNumbersPair(Credentials.CoordinatesActionBuyIndicatorsHuman).objectsPerRow(3).create();

		this.coordinatesAI = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsActionBuyIndicators)
				.coordinatesNumbersPair(Credentials.CoordinatesActionBuyIndicatorsAI)
				.directionEnumHorizontal(DirectionEnum.LEFT).objectsPerRow(3).create();

	}

	public void setUpAndShowNewRoundIndicators() {

		this.actions = 1;
		this.buys = 1;
		this.treasure = 0;

		showActionBuyTreasure();

	}

	@Override
	protected void createCoordinates() {
		super.coordinates = new CoordinatesBuilder().create();
	}

	private void showActionBuyTreasure() {

		for (IndicatorActionBuyTreasure indicatorActionBuyTreasure : super.arrayList)
			indicatorActionBuyTreasure.getImageView().setVisible(false);

		for (IndicatorAction indicatorAction : this.listAction)
			ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_ACTION, indicatorAction);
		for (IndicatorBuy indicatorBuy : this.listBuy)
			ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_BUY, indicatorBuy);
		for (IndicatorTreasure indicatorTreasure : this.listTreasure)
			ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_TREASURE, indicatorTreasure);

		this.listTreasure.clear();
		this.listAction.clear();
		this.listBuy.clear();
		super.arrayList.clear();

		for (int counter = 1; counter <= this.actions; counter++)
			this.listAction.addLast(
					(IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));

		for (int counter = 1; counter <= this.buys; counter++)
			this.listBuy.addLast((IndicatorBuy) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_BUY));

		int treasureTemp = 0;

		while (treasureTemp < this.treasure) {

			this.listTreasure.addLast(
					(IndicatorTreasure) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_TREASURE));

			treasureTemp += 20;

		}

		treasureTemp = this.treasure;

		for (IndicatorTreasure indicatorTreasure : this.listTreasure) {

			indicatorTreasure.setTreasure(Math.min(20, treasureTemp));
			treasureTemp -= 20;

		}

		for (IndicatorTreasure indicatorTreasure : this.listTreasure)
			super.arrayList.addLast(indicatorTreasure);
		for (IndicatorAction indicatorAction : this.listAction)
			super.arrayList.addLast(indicatorAction);
		for (IndicatorBuy indicatorBuy : this.listBuy)
			super.arrayList.addLast(indicatorBuy);

		super.relocateImageViews();

		for (IndicatorActionBuyTreasure indicatorActionBuyTreasure : super.arrayList)
			indicatorActionBuyTreasure.getImageView().setVisible(true);

	}

	public void removeOneAction() {

		this.actions--;
		showActionBuyTreasure();

	}

	public void removeOneBuy() {

		this.buys--;
		showActionBuyTreasure();

	}

	public void removeCoins(int coins) {

		this.treasure -= coins;
		showActionBuyTreasure();

	}

	public int getRemainingActions() {
		return this.actions;
	}

	public int getRemainingBuys() {
		return this.buys;
	}

	public int getTreasure() {
		return this.treasure;
	}

	public void testSetActionBuy(int actions, int buys, int treasure) {

		this.actions = actions;
		this.buys = buys;
		this.treasure = treasure;

		showActionBuyTreasure();

	}

	public void addOneAction() {

		this.actions++;
		showActionBuyTreasure();

	}

	public void addOneBuy() {

		this.buys++;
		showActionBuyTreasure();

	}

	public void addOneCoin() {

		this.treasure++;
		showActionBuyTreasure();

	}

	public void addCoins(int coins) {

		this.treasure += coins;
		showActionBuyTreasure();

	}

	public void removeAllActions() {

		this.actions = 0;
		showActionBuyTreasure();

	}

	public void removeAllBuys() {

		this.buys = 0;
		showActionBuyTreasure();

	}

	public void removeAllCoinsSetVisibleFalse() {

		this.treasure = 0;

		for (IndicatorTreasure indicatorTreasure : this.listTreasure) {

			indicatorTreasure.getImageView().setVisible(false);
			ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_TREASURE, indicatorTreasure);

		}

	}

	public void setCoordinatesPlayer(PlayerEnum playerEnum) {

		if (playerEnum == PlayerEnum.HUMAN)
			super.coordinates = this.coordinatesHuman;
		else if (playerEnum == PlayerEnum.AI)
			super.coordinates = this.coordinatesAI;

	}

}
