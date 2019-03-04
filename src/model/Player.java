package model;

import utils.Coordinates;

public abstract class Player {

	private Deck deck = new Deck();
	private Hand hand = new Hand();
	private DiscardPile discardPile = new DiscardPile();
	protected Coordinates coordinatesDeck = null, coordinatesHand = null, coordinatesDiscardPile = null;

	public Player() {

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
