package controller;

public enum Controller {

	INSTANCE;

	private GameStateManager gameState = null;
	private Text text = null;
	private Flow flow = null;
	private Modifiers modifiers = null;
	private SaveLoad saveLoad = null;
	private Supply supply = null;
	private Players players = null;
	private Kingdom kingdom = null;
	private ActionBuyTreasureIndicators actionBuyTreasuresIndicators = null;

	public void createInstances() {

		this.gameState = new GameStateManager();
		this.text = new Text();
		this.flow = new Flow();
		this.modifiers = new Modifiers();
		this.saveLoad = new SaveLoad();
		this.supply = new Supply();
		this.players = new Players();
		this.kingdom = new Kingdom();
		this.actionBuyTreasuresIndicators = new ActionBuyTreasureIndicators();

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

	public Kingdom kingdom() {
		return this.kingdom;
	}

	public ActionBuyTreasureIndicators actionBuyTreasureIndicators() {
		return this.actionBuyTreasuresIndicators;
	}

}
