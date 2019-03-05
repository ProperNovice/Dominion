package enums;

import gameState.*;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	CREATE_SUPPLY(new CreateSupply()),
	CREATE_KINGDOM(new CreateKingdom()),
	END_TURN(new EndTurn()),
	DRAW_STARTING_HAND(new DrawStartingHand()),
	START_NEW_TURN(new StartNewTurn()),
	
	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
