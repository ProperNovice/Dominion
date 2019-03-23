package gameState;

import controller.CardManagerSingleton;
import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import enums.PlayerEnum;
import model.Card;
import model.DiscardPile;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumbersPair;

public class StartGame extends GameState {

	private PlayerEnum currentPlayerEnum = null;

	@Override
	public void handleGameStateChange() {

//		setFirstPlayerEnum(PlayerEnum.HUMAN);
		setFirstPlayerEnum(PlayerEnum.AI);

//		presentCards();
//		setDeck();
//		setDiscardPile();
//		setHand();
//		setActionBuy(2, 7, 81);

		flow();

	}

	public void flow() {

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_KINGDOM);

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND_BOTH_PLAYERS);
//		super.controller.flow().addGameStateResolvingLast(GameStateEnum.NEW_PHASE);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void setDeck() {

		ArrayList<Card> deck = super.controller.players().getCurrentPlayer().getDeck().getArrayList();

		for (Card card : deck)
			card.getImageView().setVisible(false);

		deck.clear();

		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.MILITIA));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.WITCH));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.ESTATE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SILVER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));

		for (Card card : deck)
			card.flipFaceDown();

		super.controller.players().getCurrentPlayer().getDeck().relocateImageViews();

		if (this.currentPlayerEnum == PlayerEnum.HUMAN)
			return;

		for (Card card : deck)
			card.getImageView().setWidth(Credentials.DimensionsCardAI.x);

	}

	public void setDiscardPile() {

		DiscardPile discardPile = super.controller.players().getCurrentPlayer().getDiscardPile();

		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
//		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GARDENS));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.MARKET));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.MARKET));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.MARKET));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.DUCHY));
		discardPile.getArrayList().addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));

//		discardPile.getArrayList().shuffle();

		discardPile.relocateImageViews();
		discardPile.toBack();

		if (this.currentPlayerEnum == PlayerEnum.HUMAN)
			return;

		for (Card card : discardPile.getArrayList())
			card.getImageView().setWidth(Credentials.DimensionsCardAI.x);

	}

	public void setHand() {

		ArrayList<Card> hand = new ArrayList<Card>();

		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CHAPEL));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.REMODEL));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.CELLAR));
		hand.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.WORKSHOP));

		super.controller.players().getCurrentPlayer().getHand().testSetHandAndRelocate(hand);
//		super.controller.players().getOpponentPlayer().getHand().testSetHandAndRelocate(hand);

		if (this.currentPlayerEnum == PlayerEnum.HUMAN)
			return;

		for (Card card : hand)
			card.getImageView().setWidth(Credentials.DimensionsCardAI.x);

	}

	public void setActionBuy(int actions, int buys, int treasures) {
		super.controller.actionBuyTreasureIndicators().testSetActionBuy(actions, buys, treasures);
	}

	public void presentCards() {
		new Cards();
	}

	private class Cards extends ArrayListImageViewAbles<Card> {

		public Cards() {

			for (CardNameEnum cardNameEnum : CardNameEnum.values())
				super.arrayList.addLast(CardManagerSingleton.INSTANCE.getNewCard(cardNameEnum));

			relocateImageViews();

		}

		@Override
		public void createCoordinates() {

			NumbersPair numbersPair = new NumbersPair(Credentials.gapBetweenBorders, Credentials.gapBetweenBorders);

			super.coordinates = new CoordinatesBuilder().coordinatesNumbersPair(numbersPair)
					.dimensionsNumbersPair(Credentials.DimensionsCardHuman)
					.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(14).create();

		}

	}

	public void setFirstPlayerEnum(PlayerEnum playerEnum) {

		this.currentPlayerEnum = playerEnum;

//		this.currentPlayerEnum = new ArrayList<>(PlayerEnum.values()).getRandom();

		super.controller.players().setCurrentPlayerEnum(this.currentPlayerEnum);
		super.controller.actionBuyTreasureIndicators().setCoordinatesPlayer(this.currentPlayerEnum);

	}

}
