package controller;

import utils.Instances;

public class Controller {

	private GameStateManager gameStateManager = null;
	private TextManager textManager = null;
	private FlowManager flowManager = null;
	private Modifiers modifiers = null;
	private SaveLoadManager saveLoadManager = null;
	private CardManager cardManager = null;
	private Supply supply = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateManager = new GameStateManager();
		this.textManager = new TextManager();
		this.flowManager = new FlowManager();
		this.modifiers = new Modifiers();
		this.cardManager = new CardManager();
		this.saveLoadManager = new SaveLoadManager();
		this.supply = new Supply();

	}

	public GameStateManager gameStateManager() {
		return this.gameStateManager;
	}

	public TextManager textManager() {
		return this.textManager;
	}

	public FlowManager flowManager() {
		return this.flowManager;
	}

	public Modifiers modifiers() {
		return this.modifiers;
	}

	public SaveLoadManager saveLoadManager() {
		return this.saveLoadManager;
	}

	public CardManager cardManager() {
		return this.cardManager;
	}

	public Supply supply() {
		return this.supply;
	}

}
