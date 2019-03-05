package controller;

import enums.ObjectPoolEnum;
import model.IndicatorAction;
import model.IndicatorActionBuy;
import model.IndicatorBuy;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.ObjectPoolAble;
import utils.ObjectPoolSingleton;

public class ActionBuy extends ArrayListImageViewAbles<IndicatorActionBuy> {

	private ArrayList<IndicatorAction> listAction = new ArrayList<IndicatorAction>();
	private ArrayList<IndicatorBuy> listBuy = new ArrayList<IndicatorBuy>();

	public ActionBuy() {

	}

	public void showActionBuyOneEach() {

		this.listAction
				.addLast((IndicatorAction) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_ACTION));
		this.listBuy.addLast((IndicatorBuy) ObjectPoolSingleton.INSTANCE.pullObject(ObjectPoolEnum.INDICATOR_BUY));

		for (IndicatorActionBuy indicatorActionBuy : this.listAction)
			super.arrayList.addLast(indicatorActionBuy);
		for (IndicatorActionBuy indicatorActionBuy : this.listBuy)
			super.arrayList.addLast(indicatorActionBuy);

	}

	@Override
	protected void createCoordinates() {

		super.coordinates = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsActionBuyIndicators)
				.coordinatesNumbersPair(Credentials.CoordinatesActionBuyIndicators).create();

	}

}
