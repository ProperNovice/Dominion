package controller;

import enums.PileAmountOfCardsEnum;
import model.Pile;
import utils.ObjectPoolAble;

public enum PilesPoolableSingleton {

	INSTANCE;

	public PilesPoolable pilesPoolable = new PilesPoolable();

	private PilesPoolableSingleton() {

	}

	public class PilesPoolable implements ObjectPoolAble {

		@Override
		public Object getObject() {
			return new Pile(PileAmountOfCardsEnum.INFINITE);
		}

	}

}
