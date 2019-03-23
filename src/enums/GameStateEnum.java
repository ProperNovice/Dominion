package enums;

import gameState.*;
import gameStateCardAbilities.*;
import gameStateStrategyAI.*;

public enum GameStateEnum {

	START_GAME(new StartGame()),
	CREATE_SUPPLY(new CreateSupply()),
	CREATE_KINGDOM(new CreateKingdom()),
	DRAW_STARTING_HAND_CURRENT_PLAYER(new DrawStartingHandCurrentPlayer()),
	DRAW_STARTING_HAND_OPPONENT_PLAYER(new DrawStartingHandOpponentPlayer()),
	DRAW_STARTING_HAND_BOTH_PLAYERS(new DrawStartingHandsBothPlayers()),
	NEW_PHASE(new NewPhase()),
	ACTION_PHASE_HUMAN(new ActionPhaseHuman()),
	ACTION_PHASE_AI(new ActionPhaseAI()),
	BUY_PHASE_HUMAN(new BuyPhaseHuman()),
	BUY_PHASE_AI(new BigMoney()),
	CLEAN_UP_PHASE(new CleanUpPhase()),
	SET_UP_AND_SHOW_NEW_ROUND_INDICATORS(new SetUpAndShowNewRoundIndicators()),
	END_GAME(new EndGame()),
	SET_VICTORY_POINTS_INDICATORS(new SetVictoryPointsIndicators()),
	
	PLUS_ONE_CARD_CURRENT_PLAYER(new PlusOneCardCurrentPlayer()),
	PLUS_ONE_CARD_OPPONENT_PLAYER(new PlusOneCardOpponentPlayer()),
	PLUS_ONE_ACTION(new PlusOneAction()),
	PLUS_ONE_COIN(new PlusOneCoin()),
	PLUS_ONE_BUY(new PlusOneBuy()),
	DISCARD_ANY_NUMBER_OF_CARDS_THEN_DRAW_THAT_MANY(new DiscardAnyNumberOfCardsThenDrawThatMany()),
	TRASH_UP_TO_FOUR_CARDS_FROM_YOUR_HAND(new TrashUpToFourCardsFromYourHand()),
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
