package controller;

import utils.Instances;

public class Controller {

	private GameStateManager gameStateManager = new GameStateManager();
	private TextManager textManager = new TextManager();
	private FlowManager flowManager = new FlowManager();
	private Modifiers modifiers = new Modifiers();
	private CardManager cardManager = new CardManager();
	private SaveLoadManager saveLoadManager = new SaveLoadManager();

	public Controller() {
		Instances.setControllerInstance(this);
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

}
