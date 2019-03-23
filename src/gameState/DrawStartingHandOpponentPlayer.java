package gameState;

import enums.GameStateEnum;

public class DrawStartingHandOpponentPlayer extends DrawStartingHandAbstract {

	@Override
	protected GameStateEnum getDrawCardEnum() {
		return GameStateEnum.PLUS_ONE_CARD_OPPONENT_PLAYER;
	}

}
