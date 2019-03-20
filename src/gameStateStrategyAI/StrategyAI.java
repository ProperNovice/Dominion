package gameStateStrategyAI;

import enums.CardNameEnum;
import enums.TextEnum;
import gameState.BuyPhaseAbstract;
import model.Card;
import utils.HashMap;
import utils.Logger;

public abstract class StrategyAI extends BuyPhaseAbstract {

	protected HashMap<CardNameEnum, Integer> cardBuyCost = new HashMap<>();

	public StrategyAI() {

		this.cardBuyCost.put(CardNameEnum.PROVINCE, 8);
		this.cardBuyCost.put(CardNameEnum.DUCHY, 5);
		this.cardBuyCost.put(CardNameEnum.ESTATE, 2);
		this.cardBuyCost.put(CardNameEnum.GOLD, 6);
		this.cardBuyCost.put(CardNameEnum.SILVER, 3);

	}

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.BUY_PHASE);

		if (super.controller.players().getCurrentPlayer().getHand().containsAtLeastOneTreasureCard())
			super.controller.text().showText(TextEnum.PLAY_HAND_TREASURES);
		else
			super.controller.text().showText(TextEnum.BUY_CARD);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		if (textEnum == TextEnum.PLAY_HAND_TREASURES)
			super.playHandTreasures();
		else if (textEnum == TextEnum.BUY_CARD)
			executeBuyCard();

	}

	private void executeBuyCard() {

		getTotalTreasure();

		CardNameEnum cardNameEnumToBuy = null;

		if (canResolveFirst())
			cardNameEnumToBuy = getFirstCard();
		else if (canResolveSecond())
			cardNameEnumToBuy = getSecondCard();
		else if (canResolveThird())
			cardNameEnumToBuy = getThirdCard();
		else if (canResolveFourth())
			cardNameEnumToBuy = getFourthCard();
		else if (canResolveFifth())
			cardNameEnumToBuy = getFifthCard();
		else if (canResolveSixth())
			cardNameEnumToBuy = getSixthCard();

	}

	protected boolean canResolveFirst() {
		return false;
	}

	protected CardNameEnum getFirstCard() {
		return null;
	}

	protected boolean canResolveSecond() {
		return false;
	}

	protected CardNameEnum getSecondCard() {
		return null;
	}

	protected boolean canResolveThird() {
		return false;
	}

	protected CardNameEnum getThirdCard() {
		return null;
	}

	protected boolean canResolveFourth() {
		return false;
	}

	protected CardNameEnum getFourthCard() {
		return null;
	}

	protected boolean canResolveFifth() {
		return false;
	}

	protected CardNameEnum getFifthCard() {
		return null;
	}

	protected boolean canResolveSixth() {
		return false;
	}

	protected CardNameEnum getSixthCard() {
		return null;
	}

	protected int getTotalTreasure() {

		int totalTreasure = 0;

		for (Card card : super.controller.players().getCurrentPlayer().getDeck().getArrayList())
			totalTreasure += card.getTreasure();

		for (Card card : super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList())
			totalTreasure += card.getTreasure();

		for (Card card : super.controller.players().getCurrentPlayer().getPlayArea().getArrayList())
			totalTreasure += card.getTreasure();

		Logger.logNewLine("total money -> " + totalTreasure);

		return totalTreasure;

	}

}
