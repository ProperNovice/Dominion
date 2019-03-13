package gameStateAI;

import gameState.GameState;

public abstract class StrategyAI extends GameState {

	protected final int getTotalMoney() {
		return 0;
	}

	protected final int getRoundsTillEndGame() {
		return 0;
	}

	protected boolean canResolveFirst() {
		return false;
	}

	protected void executeFirst() {

	}

	protected boolean canResolveSecond() {
		return false;
	}

	protected void executeSecond() {

	}

	protected boolean canResolveThird() {
		return false;
	}

	protected void executeThird() {

	}

	protected boolean canResolveFourth() {
		return false;
	}

	protected void executeFourth() {

	}

	protected boolean canResolveFifth() {
		return false;
	}

	protected void executeFifth() {

	}

}
