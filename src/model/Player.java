package model;

import controller.Credentials;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.NumbersPair;
import utils.RearrangeTypeEnum;

public abstract class Player {

	protected Deck deck = new Deck();
	protected Hand hand = new Hand();
	protected DiscardPile discardPile = new DiscardPile();
	protected PlayArea playArea = new PlayArea();
	protected NumbersPair handCoordinates = null;

	public Player() {

		setCoordinates();

		this.deck.relocateImageViews();
		this.discardPile.relocateImageViews();

		Coordinates coordinatesHand = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCard)
				.coordinatesNumbersPair(this.handCoordinates).gapNumbersPair(Credentials.DimensionsGapBetweenCards)
				.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).list(this.hand).create();

		this.hand.setCoordinates(coordinatesHand);

	}

	protected abstract void setCoordinates();

	public Deck getDeck() {
		return this.deck;
	}

	public Hand getHand() {
		return this.hand;
	}

	public DiscardPile getDiscardPile() {
		return this.discardPile;
	}

	public PlayArea getPlayArea() {
		return this.playArea;
	}

}
