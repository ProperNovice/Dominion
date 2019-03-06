package controller;

import enums.ObjectPoolEnum;
import model.IndicatorAction;
import model.IndicatorActionBuyTreasure;
import model.IndicatorBuy;
import model.IndicatorTreasure;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.ObjectPoolSingleton;

public class ActionBuyTreasureIndicators extends ArrayListImageViewAbles<IndicatorActionBuyTreasure> {

	private IndicatorTreasure indicatorTreasure = new IndicatorTreasure();
	private ArrayList<IndicatorAction> listAction = new ArrayList<IndicatorAction>();
	private ArrayList<IndicatorBuy> listBuy = new ArrayList<IndicatorBuy>();
	private int treasure = 0;

	public ActionBuyTreasureIndicators() {

	}

	public void showActionBuyOneEach() {

		this.listAction
				.addLast((IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));
		this.listBuy.addLast((IndicatorBuy) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_BUY));

		this.treasure = 0;

		showActionBuyTreasure();

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsActionBuyIndicators)
				.coordinatesNumbersPair(Credentials.CoordinatesActionBuyIndicators).objectsPerRow(3).create();

	}

	private void showActionBuyTreasure() {

		super.arrayList.clear();

		this.indicatorTreasure.setTreasure(this.treasure);

		super.arrayList.addLast(this.indicatorTreasure);
		for (IndicatorActionBuyTreasure indicatorActionBuy : this.listAction)
			super.arrayList.addLast(indicatorActionBuy);
		for (IndicatorActionBuyTreasure indicatorActionBuy : this.listBuy)
			super.arrayList.addLast(indicatorActionBuy);

		super.relocateImageViews();

		for (IndicatorActionBuyTreasure indicatorActionBuy : super.arrayList)
			indicatorActionBuy.getImageView().setVisible(true);

	}

	public void removeOneActionAndRearrange() {

		IndicatorAction indicatorAction = this.listAction.removeFirst();
		indicatorAction.getImageView().setVisible(false);

		ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_ACTION, indicatorAction);

		showActionBuyTreasure();

	}

	public void removeOneBuyAndRearrange() {

		IndicatorBuy indicatorBuy = this.listBuy.removeFirst();
		indicatorBuy.getImageView().setVisible(false);

		ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_BUY, indicatorBuy);

		showActionBuyTreasure();

	}

	public int getRemainingActions() {
		return this.listAction.size();
	}

	public int getRemainingBuys() {
		return this.listBuy.size();
	}

	public void testSetActionBuy(int action, int buy) {

		this.listAction.clear();
		this.listBuy.clear();

		for (IndicatorActionBuyTreasure indicatorActionBuy : super.arrayList)
			indicatorActionBuy.getImageView().setVisible(false);

		super.arrayList.clear();

		for (int counter = 1; counter <= action; counter++)
			this.listAction.addLast(new IndicatorAction());

		for (int counter = 1; counter <= buy; counter++)
			this.listBuy.addLast(new IndicatorBuy());

		showActionBuyTreasure();

	}

	public void addOneAction() {

		this.listAction
				.addLast((IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));

		showActionBuyTreasure();

	}

	public void addOneBuy() {

		this.listBuy.addLast((IndicatorBuy) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_BUY));

		showActionBuyTreasure();

	}

	public void addOneCoin() {

		this.treasure++;
		showActionBuyTreasure();

	}

	public void removeAllActionsAndRearrange() {

		int listSize = this.listAction.size();

		for (int counter = 1; counter <= listSize; counter++)
			removeOneActionAndRearrange();

	}

}
