package model;

import utils.NumbersPair;

public abstract class Player {

	protected Deck deck = new Deck();
	protected Hand hand = new Hand();
	protected DiscardPile discardPile = new DiscardPile();
	protected NumbersPair handCoordinates = null;

	public Player() {
		setCoordinates();
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
