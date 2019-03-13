package controller;

import enums.ObjectPoolEnum;
import enums.PileAmountOfCardsEnum;
import model.IndicatorAction;
import model.IndicatorBuy;
import model.IndicatorTreasure;
import model.Pile;
import model.Select;
import utils.ObjectPoolAble;
import utils.ObjectPoolSingleton;

public enum ObjectsPool {

	INSTANCE;

	public void create() {

		new SelectPoolable().createObjectPoolSingletonInstance();
		new PilesPoolable().createObjectPoolSingletonInstance();
		new IndicatorActionPoolable().createObjectPoolSingletonInstance();
		new IndicatorBuyPoolable().createObjectPoolSingletonInstance();
		new IndicatorTreasurePoolable().createObjectPoolSingletonInstance();

	}

	public class SelectPoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new Select();
		}

		@Override
		public void createObjectPoolSingletonInstance() {
			ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.SELECT, this);
		}

	}

	public class PilesPoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new Pile(PileAmountOfCardsEnum.FINITE);
		}

		@Override
		public void createObjectPoolSingletonInstance() {
			ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.PILE, this);
		}

	}

	public class IndicatorActionPoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new IndicatorAction();
		}

		@Override
		public void createObjectPoolSingletonInstance() {
			ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.INDICATOR_ACTION, this);
		}

	}

	public class IndicatorBuyPoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new IndicatorBuy();
		}

		@Override
		public void createObjectPoolSingletonInstance() {
			ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.INDICATOR_BUY, this);
		}

	}

	public class IndicatorTreasurePoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new IndicatorTreasure();
		}

		@Override
		public void createObjectPoolSingletonInstance() {
			ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.INDICATOR_TREASURE, this);
		}

	}

}
