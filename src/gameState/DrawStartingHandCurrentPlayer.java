package gameState;

import enums.GameStateEnum;

public class DrawStartingHandCurrentPlayer extends DrawStartingHandAbstract {

	@Override
	protected GameStateEnum getDrawCardEnum() {
		return GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER;
	}

}
