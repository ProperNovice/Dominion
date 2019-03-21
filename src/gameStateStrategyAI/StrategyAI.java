package gameStateStrategyAI;

import enums.CardNameEnum;
import enums.TextEnum;
import gameState.BuyPhaseAbstract;
import model.Card;
import model.Pile;
import utils.HashMap;
import utils.Logger;

public abstract class StrategyAI extends BuyPhaseAbstract {

	protected HashMap<CardNameEnum, Integer> cardBuyCost = new HashMap<>();
	private int treasureAvailable = 0;

	public StrategyAI() {

		this.treasureAvailable = 0;

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

		Logger.logNewLine("/*");
		Logger.logNewLine("executing buy card");

		this.treasureAvailable = super.controller.actionBuyTreasureIndicators().getTreasure();

		CardNameEnum cardNameEnumToBuy = null;

		if (canBuyCard1() && canBuyCardLog(getCard1()))
			cardNameEnumToBuy = getCard1();
		else if (canBuyCard2() && canBuyCardLog(getCard2()))
			cardNameEnumToBuy = getCard2();
		else if (canBuyCard3() && canBuyCardLog(getCard3()))
			cardNameEnumToBuy = getCard3();
		else if (canBuyCard4() && canBuyCardLog(getCard4()))
			cardNameEnumToBuy = getCard4();
		else if (canBuyCard5() && canBuyCardLog(getCard5()))
			cardNameEnumToBuy = getCard5();
		else if (canBuyCard6() && canBuyCardLog(getCard6()))
			cardNameEnumToBuy = getCard6();

		Logger.logNewLine(cardNameEnumToBuy);

		Logger.logNewLine("*/");

	}

	protected boolean canBuyCard1() {
		return false;
	}

	protected CardNameEnum getCard1() {
		return null;
	}

	protected boolean canBuyCard2() {
		return false;
	}

	protected CardNameEnum getCard2() {
		return null;
	}

	protected boolean canBuyCard3() {
		return false;
	}

	protected CardNameEnum getCard3() {
		return null;
	}

	protected boolean canBuyCard4() {
		return false;
	}

	protected CardNameEnum getCard4() {
		return null;
	}

	protected boolean canBuyCard5() {
		return false;
	}

	protected CardNameEnum getCard5() {
		return null;
	}

	protected boolean canBuyCard6() {
		return false;
	}

	protected CardNameEnum getCard6() {
		return null;
	}

	protected final boolean totalTreasureGreaterToLog(int treasure) {

		int totalTreasure = 0;

		for (Card card : super.controller.players().getCurrentPlayer().getDeck().getArrayList())
			totalTreasure += card.getTreasure();

		for (Card card : super.controller.players().getCurrentPlayer().getDiscardPile().getArrayList())
			totalTreasure += card.getTreasure();

		for (Card card : super.controller.players().getCurrentPlayer().getPlayArea().getArrayList())
			totalTreasure += card.getTreasure();

		Logger.log("total treasure greater to -> " + treasure);
		Logger.log("total treasure -> " + totalTreasure);

		boolean pass = totalTreasure > treasure;

		Logger.logNewLine(pass);
		return pass;

	}

	protected final boolean canBuyCardLog(CardNameEnum cardNameEnum) {

		Logger.log("trying to buy " + cardNameEnum);

		int buyCost = this.cardBuyCost.get(cardNameEnum);
		int treasureAvailable = super.controller.actionBuyTreasureIndicators().getTreasure();
		boolean canBuyCard = false;

		Logger.log("buy cost -> " + buyCost);
		Logger.log("treasure -> " + treasureAvailable);

		if (treasureAvailable >= buyCost)
			canBuyCard = true;

		Logger.log(canBuyCard);

		if (!canBuyCard)
			Logger.newLine();

		return canBuyCard;

	}

	protected final boolean stateGainsToEndGameLessOrEqualToLog(int state) {

		int stateGainsToEndGame = -1;
		boolean pass = false;

		for (Pile pile : super.controller.supply().getPiles())
			if (pile.getArrayList().getFirst().getCardNameEnum() == CardNameEnum.PROVINCE)
				stateGainsToEndGame = pile.getArrayList().size();

		if (stateGainsToEndGame <= state)
			pass = true;

		Logger.log("state gains to end game -> " + stateGainsToEndGame);
		Logger.logNewLine(pass);

		return pass;

	}

}
