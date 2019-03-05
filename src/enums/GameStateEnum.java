package enums;

import gameState.*;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	CREATE_SUPPLY(new CreateSupply()),
	CREATE_KINGDOM(new CreateKingdom()),
	END_TURN(new EndTurn()),
	DRAW_STARTING_HAND(new DrawStartingHand()),
	START_NEW_TURN(new StartNewTurn()),
	START_NEW_PHASE(new StartNewPhase()),
	ACTION_PHASE(new ActionPhase()),
	BUY_PHASE(new BuyPhase()),
	PLUS_ONE_CARD(new PlusOneCard()),
	PLUS_ONE_ACTION(new PlusOneAction()),
	PLUS_ONE_COIN(new PlusOneCoin()),
	PLUS_ONE_BUY(new PlusOneBuy()),
	TRASH_UP_TO_FOUR_CARDS_FROM_YOUR_HAND(new TrashUpToFourCardsFromYourHand()),
	DISCARD_ANY_NUMBER_OF_CARDS_THEN_DRAW_THAT_MANY(new DiscardAnyNumberOfCardsThenDrawThatMany()),
	GAIN_A_CARD_COSTING_UP_TO_FOUR(new GainCardCostingUpToFour()),
	TRASH_A_CARD_FROM_YOUR_HAND_GAIN_A_CARD_COSTING_UP_TO_TWO_MORE_THAN_IT(new TrashCardFromYourHandGainCardCostingUpToTwoMoreThanIt()),
	EACH_OTHER_PLAYER_DISCARDS_DOWN_TO_THREE_CARDS_IN_HAND(new EachOtherPlayerDiscardsaDownToThreeCardsInHand()),
	EACH_OTHER_PLAYER_GAINS_A_CURSE(new EachOtherPlayerGainsCurse()),
	WORTH_ONE_VICTORY_POINT_PER_TEN_CARDS_YOU_HAVE_ROUND_DOWN(new WorthOneVictoryPointPerTenCardsYouHaveRoundDown()),
	
	;

	private GameState gameState = null;

	private GameStateEnum(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return this.gameState;
	}

}
