package controller;

import enums.ObjectPoolEnum;
import model.IndicatorAction;
import model.IndicatorActionBuy;
import model.IndicatorBuy;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.ObjectPoolSingleton;
import utils.RearrangeTypeEnum;

public class ActionBuy extends ArrayListImageViewAbles<IndicatorActionBuy> {

	private ArrayList<IndicatorAction> listAction = new ArrayList<IndicatorAction>();
	private ArrayList<IndicatorBuy> listBuy = new ArrayList<IndicatorBuy>();

	public ActionBuy() {

	}

	public void showActionBuyOneEach() {

		this.listAction
				.addLast((IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));
		this.listBuy.addLast((IndicatorBuy) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_BUY));

		showActionBuy();

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsActionBuyIndicators)
				.coordinatesNumbersPair(Credentials.CoordinatesActionBuyIndicators).objectsPerRow(3)
				.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).create();

	}

	private void showActionBuy() {

		super.arrayList.clear();

		for (IndicatorActionBuy indicatorActionBuy : this.listAction)
			super.arrayList.addLast(indicatorActionBuy);
		for (IndicatorActionBuy indicatorActionBuy : this.listBuy)
			super.arrayList.addLast(indicatorActionBuy);

		super.relocateImageViews();

		for (IndicatorActionBuy indicatorActionBuy : super.arrayList)
			indicatorActionBuy.getImageView().setVisible(true);

	}

	public void removeActionAndRearrange() {

		IndicatorAction indicatorAction = this.listAction.removeFirst();
		indicatorAction.getImageView().setVisible(false);

		ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_ACTION, indicatorAction);

		showActionBuy();

	}

	public void removeBuyAndRearrange() {

		IndicatorBuy indicatorBuy = this.listBuy.removeFirst();
		indicatorBuy.getImageView().setVisible(false);

		ObjectPoolSingleton.INSTANCE.releaseObject(ObjectPoolEnum.INDICATOR_BUY, indicatorBuy);

		showActionBuy();

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

		for (IndicatorActionBuy indicatorActionBuy : super.arrayList)
			indicatorActionBuy.getImageView().setVisible(false);

		super.arrayList.clear();

		for (int counter = 1; counter <= action; counter++)
			this.listAction.addLast(new IndicatorAction());

		for (int counter = 1; counter <= buy; counter++)
			this.listBuy.addLast(new IndicatorBuy());

		showActionBuy();

	}
	
	public void addOneAction() {
		
		this.listAction
		.addLast((IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));
		
		showActionBuy();
		
	}

}
