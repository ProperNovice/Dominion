package controller;

import utils.Instances;

public class Controller {

	private GameStateManager gameState = null;
	private Text text = null;
	private Flow flow = null;
	private Modifiers modifiers = null;
	private SaveLoad saveLoad = null;
	private Supply supply = null;
	private Players players = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameState = new GameStateManager();
		this.text = new Text();
		this.flow = new Flow();
		this.modifiers = new Modifiers();
		this.saveLoad = new SaveLoad();
		this.supply = new Supply();
		this.players = new Players();

	}

	public GameStateManager gameState() {
		return this.gameState;
	}

	public Text text() {
		return this.text;
	}

	public Flow flow() {
		return this.flow;
	}

	public Modifiers modifiers() {
		return this.modifiers;
	}

	public SaveLoad saveLoad() {
		return this.saveLoad;
	}

	public Supply supply() {
		return this.supply;
	}

	public Players players() {
		return this.players;
	}

}
