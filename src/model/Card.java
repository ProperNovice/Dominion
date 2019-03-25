package model;

import controller.Controller;
import controller.Credentials;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.GameStateEnum;
import enums.PhaseEnum;
import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.HashMap;
import utils.Image;
import utils.ImageView;
import utils.ImageViewAble;
import utils.Logger;

public class Card implements EventHandlerAble, ImageViewAble {

	private CardNameEnum cardNameEnum = null;
	private ArrayList<CardTypeEnum> cardTypeEnum = new ArrayList<>();
	private int buyCost = -1, treasure = 0, victoryPoints = 0;
	private HashMap<PhaseEnum, ArrayList<GameStateEnum>> cardAbilities = new HashMap<>();
	private Image front = null, back = null;

	public Card(CardNameEnum cardNameEnum, int buyCost) {

		this.cardNameEnum = cardNameEnum;
		this.buyCost = buyCost;

		createImageView();

	}

	private void createImageView() {

		String path = "";
		path += "cards/";
		path += this.cardNameEnum.getString();
		path += ".jpg";

		this.front = new Image(path);
		this.back = new Image("cards/back.jpg");

		ImageView imageView = new ImageView(this.front, this);
		imageView.setWidth(Credentials.DimensionsCardHuman.x);

		map.put(this, imageView);

	}

	public void addCardTypeEnum(CardTypeEnum cardTypeEnum) {
		this.cardTypeEnum.addLast(cardTypeEnum);
	}

	public void addCardAbility(PhaseEnum phaseEnum, GameStateEnum gameStateEnum) {

		if (!this.cardAbilities.containsKey(phaseEnum))
			this.cardAbilities.put(phaseEnum, new ArrayList<GameStateEnum>());

		this.cardAbilities.get(phaseEnum).addLast(gameStateEnum);

	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	public int getVictoryPoints() {
		return this.victoryPoints;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	public int getTreasure() {
		return this.treasure;
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		printCard();

		Executor.runLater(() -> Controller.INSTANCE.gameState().getCurrentGameState().executeCardPressedPrimary(this));

	}

	@Override
	public void handleMouseButtonPressedSecondary() {

		printCard();

		Executor.runLater(
				() -> Controller.INSTANCE.gameState().getCurrentGameState().executeCardPressedSecondary(this));

	}

	@Override
	public void handleMouseEntered() {
		Executor.runLater(() -> Controller.INSTANCE.gameState().getCurrentGameState().executeCardEntered(this,
				this.cardNameEnum));
	}

	@Override
	public void handleMouseExited() {
		Executor.runLater(
				() -> Controller.INSTANCE.gameState().getCurrentGameState().executeCardExited(this.cardNameEnum));
	}

	private void printCard() {

		String seperator = "*******";

		Logger.log(seperator);

		Logger.log("card name -> " + this.cardNameEnum);
		Logger.log("buy cost -> " + this.buyCost);

		for (CardTypeEnum cardTypeEnum : this.cardTypeEnum)
			Logger.log("card type -> " + cardTypeEnum);

		if (this.treasure != 0)
			Logger.log("treasure -> " + this.treasure);

		if (this.victoryPoints != 0)
			Logger.log("victory points -> " + this.victoryPoints);

		for (PhaseEnum phaseEnum : PhaseEnum.values()) {

			if (!this.cardAbilities.containsKey(phaseEnum))
				continue;

			Logger.log("phase -> " + phaseEnum);
			this.cardAbilities.get(phaseEnum).printList();

		}

		Logger.log(seperator);
		Logger.newLine();

	}

	public void flipFaceUp() {
		map.get(this).setImage(this.front);
	}

	public void flipFaceDown() {
		map.get(this).setImage(this.back);
	}

	public CardNameEnum getCardNameEnum() {
		return this.cardNameEnum;
	}

	public boolean isCardType(CardTypeEnum cardTypeEnum) {
		return this.cardTypeEnum.contains(cardTypeEnum);
	}

	public int getBuyCost() {
		return this.buyCost;
	}

	public boolean hasPhaseEnum(PhaseEnum phaseEnum) {
		return this.cardAbilities.containsKey(phaseEnum);
	}

	public ArrayList<GameStateEnum> getCardAbilityEnum(PhaseEnum phaseEnum) {
		return this.cardAbilities.get(phaseEnum);
	}

}
