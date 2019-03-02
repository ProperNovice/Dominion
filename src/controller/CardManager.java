package controller;

import enums.CardNameEnum;
import enums.CardTypeEnum;
import model.Card;

public class CardManager {

	public CardManager() {

	}

	public Card getNewCard(CardNameEnum cardNameEnum) {

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

		}

		return card;

	}

}
