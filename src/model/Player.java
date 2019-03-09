package model;

import utils.NumbersPair;

public abstract class Player {

	protected Deck deck = new Deck();
	protected Hand hand = new HandHuman();
	protected DiscardPile discardPile = new DiscardPile();
	protected PlayArea playArea = new PlayArea();
	protected NumbersPair handCoordinates = null;

	public Player() {

		setCoordinates();

		this.deck.relocateImageViews();
		this.discardPile.relocateImageViews();

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
