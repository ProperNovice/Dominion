package gameStateStrategyAI;

import enums.CardNameEnum;
import gameState.BuyPhaseAbstract;

public abstract class StrategyAI extends BuyPhaseAbstract {

	@Override
	public void handleGameStateChange() {

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

}
