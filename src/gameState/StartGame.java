package gameState;

import controller.CardManagerSingleton;
import controller.Credentials;
import enums.CardNameEnum;
import enums.GameStateEnum;
import model.Card;
import utils.ArrayList;
import utils.ArrayListImageViewAbles;
import utils.CoordinatesBuilder;
import utils.NumbersPair;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

//		presentCards();
		setDeck();
//		setActionBuy(2, 13);

		flow();

	}

	public void flow() {

		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_SUPPLY);
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.CREATE_KINGDOM);
		
		super.controller.flow().addGameStateResolvingLast(GameStateEnum.END_TURN);
		
//		super.controller.flow().addGameStateResolvingLast(GameStateEnum.DRAW_STARTING_HAND);
//		super.controller.flow().addGameStateResolvingLast(GameStateEnum.START_NEW_PHASE);



		super.controller.flow().proceedToNextGameStatePhase();

	}

	public void setDeck() {

		ArrayList<Card> deck = new ArrayList<>();

		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.SMITHY));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.VILLAGE));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.COPPER));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));
		deck.addLast(CardManagerSingleton.INSTANCE.getNewCard(CardNameEnum.GOLD));

		super.controller.players().getCurrentPlayer().getDeck().testSetDeck(deck);
		super.controller.players().getCurrentPlayer().getDeck().relocateImageViews();

	}

	public void setActionBuy(int action, int buy) {
		super.controller.actionBuy().testSetActionBuy(action, buy);
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
					.dimensionsNumbersPair(Credentials.DimensionsCard)
					.gapNumbersPair(Credentials.DimensionsGapBetweenCards).objectsPerRow(14).create();

		}

	}

}
