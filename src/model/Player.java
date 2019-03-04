package model;

import controller.Credentials;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.NumbersPair;
import utils.RearrangeTypeEnum;

public abstract class Player {

	protected Deck deck = new Deck();
	protected Hand hand = null;
	protected DiscardPile discardPile = new DiscardPile();
	protected NumbersPair handCoordinates = null;

	public Player() {

		setCoordinates();

		this.deck.relocateImageViews();
		this.discardPile.relocateImageViews();

		Coordinates coordinatesHand = new CoordinatesBuilder().dimensionsNumbersPair(Credentials.DimensionsCard)
				.coordinatesNumbersPair(this.handCoordinates).rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).create();

		this.hand = new Hand(coordinatesHand);

	}

	protected abstract void setCoordinates();

	public Deck getDeck() {
		return this.deck;
	}

	public Hand getHand() {
		return this.hand;
	}

	public DiscardPile discardPile() {
		return this.discardPile;
	}

}
