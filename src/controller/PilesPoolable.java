package controller;

import enums.ObjectPoolEnum;
import enums.PileAmountOfCardsEnum;
import model.Pile;
import utils.ObjectPoolAble;
import utils.ObjectPoolSingleton;

public class PilesPoolable implements ObjectPoolAble {

	public PilesPoolable() {
		ObjectPoolSingleton.INSTANCE.createObjectPool(ObjectPoolEnum.PILE, this);
	}

	@Override
	public Object getObject() {
		return new Pile(PileAmountOfCardsEnum.FINITE);
	}

}
