package controller;

import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.GameStateEnum;
import enums.PhaseEnum;
import model.Card;

public enum CardManagerSingleton {

	INSTANCE;

	private CardManagerSingleton() {

	}

	public Card getNewCard(CardNameEnum cardNameEnum) {

		CardIndicatorSingleton.INSTANCE.createIndicator(cardNameEnum);

		Card card = null;

		switch (cardNameEnum) {

		case COPPER:
			card = new Card(cardNameEnum, 0);
			card.addCardTypeEnum(CardTypeEnum.TREASURE);
			card.setTreasure(1);
			break;

		case SILVER:
			card = new Card(cardNameEnum, 3);
			card.addCardTypeEnum(CardTypeEnum.TREASURE);
			card.setTreasure(2);
			break;

		case GOLD:
			card = new Card(cardNameEnum, 6);
			card.addCardTypeEnum(CardTypeEnum.TREASURE);
			card.setTreasure(3);
			break;

		case ESTATE:
			card = new Card(cardNameEnum, 2);
			card.addCardTypeEnum(CardTypeEnum.VICTORY);
			card.setVictoryPoints(1);
			break;

		case DUCHY:
			card = new Card(cardNameEnum, 5);
			card.addCardTypeEnum(CardTypeEnum.VICTORY);
			card.setVictoryPoints(3);
			break;

		case PROVINCE:
			card = new Card(cardNameEnum, 8);
			card.addCardTypeEnum(CardTypeEnum.VICTORY);
			card.setVictoryPoints(6);
			break;

		case CURSE:
			card = new Card(cardNameEnum, 0);
			card.addCardTypeEnum(CardTypeEnum.CURSE);
			card.setVictoryPoints(-1);
			break;

		case SMITHY:
			card = new Card(cardNameEnum, 4);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			break;

		case CHAPEL:
			card = new Card(cardNameEnum, 2);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.TRASH_UP_TO_FOUR_CARDS_FROM_YOUR_HAND);
			break;

		case CELLAR:
			card = new Card(cardNameEnum, 2);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.DISCARD_ANY_NUMBER_OF_CARDS_THEN_DRAW_THAT_MANY);
			break;

		case VILLAGE:
			card = new Card(cardNameEnum, 3);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_ACTION);
			break;

		case WORKSHOP:
			card = new Card(cardNameEnum, 3);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.GAIN_A_CARD_COSTING_UP_TO_FOUR);
			break;

		case REMODEL:
			card = new Card(cardNameEnum, 4);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION,
					GameStateEnum.TRASH_A_CARD_FROM_YOUR_HAND_GAIN_A_CARD_COSTING_UP_TO_TWO_MORE_THAN_IT);
			break;

		case MILITIA:
			card = new Card(cardNameEnum, 4);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_COIN);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_COIN);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.EACH_OTHER_PLAYER_DISCARDS_DOWN_TO_THREE_CARDS_IN_HAND);
			break;

		case GARDENS:
			card = new Card(cardNameEnum, 4);
			card.addCardTypeEnum(CardTypeEnum.VICTORY);
			card.addCardAbility(PhaseEnum.VICTORY_POINTS_COUNT,
					GameStateEnum.WORTH_ONE_VICTORY_POINT_PER_TEN_CARDS_YOU_HAVE_ROUND_DOWN);
			break;

		case MARKET:
			card = new Card(cardNameEnum, 5);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_BUY);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_COIN);
			break;

		case WITCH:
			card = new Card(cardNameEnum, 5);
			card.addCardTypeEnum(CardTypeEnum.ACTION);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.PLUS_ONE_CARD_CURRENT_PLAYER);
			card.addCardAbility(PhaseEnum.ACTION, GameStateEnum.EACH_OTHER_PLAYER_GAINS_A_CURSE);
			break;

		}

		return card;

	}

}
