package gameStateStrategyAI;

import enums.CardNameEnum;
import utils.Logger;

public class BigMoney extends StrategyAI {

	@Override
	protected boolean canBuyCard1() {

		int totalTreasure = 18;

		Logger.log("Province if my.getTotalMoney() > " + totalTreasure);
		return (super.totalTreasureGreaterToLog(totalTreasure));

	}

	@Override
	protected CardNameEnum getCard1() {
		return CardNameEnum.PROVINCE;
	}

	@Override
	protected boolean canBuyCard2() {

		int state = 4;

		Logger.log("Duchy if state.gainsToEndGame() <= " + state);
		return (super.stateGainsToEndGameLessOrEqualToLog(state));

	}

	@Override
	protected CardNameEnum getCard2() {
		return CardNameEnum.DUCHY;
	}

	@Override
	protected boolean canBuyCard3() {

		int state = 2;

		Logger.log("Estate if state.gainsToEndGame() <= " + state);
		return (super.stateGainsToEndGameLessOrEqualToLog(state));

	}

	@Override
	protected CardNameEnum getCard3() {
		return CardNameEnum.ESTATE;
	}

	@Override
	protected boolean canBuyCard4() {
		return true;
	}

	@Override
	protected CardNameEnum getCard4() {
		return CardNameEnum.GOLD;
	}

	@Override
	protected boolean canBuyCard5() {

		int state = 5;

		Logger.log("Duchy if state.gainsToEndGame() <= " + state);
		return (super.stateGainsToEndGameLessOrEqualToLog(state));

	}

	@Override
	protected CardNameEnum getCard5() {
		return CardNameEnum.DUCHY;
	}

	@Override
	protected boolean canBuyCard6() {
		return true;
	}

	@Override
	protected CardNameEnum getCard6() {
		return CardNameEnum.SILVER;
	}

}
