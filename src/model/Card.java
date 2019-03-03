package model;

import controller.Credentials;
import enums.CardAbilityEnum;
import enums.CardNameEnum;
import enums.CardTypeEnum;
import enums.PhaseEnum;
import utils.ArrayList;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.HashMap;
import utils.Image;
import utils.ImageView;
import utils.ImageViewAble;
import utils.Instances;
import utils.Logger;

public class Card implements EventHandlerAble, ImageViewAble {

	private CardNameEnum cardNameEnum = null;
	private ArrayList<CardTypeEnum> cardTypeEnum = new ArrayList<>();
	private int buyCost = -1, treasure = 0, victoryPoints = 0;
	private HashMap<PhaseEnum, ArrayList<CardAbilityEnum>> cardAbilities = new HashMap<>();
	private Image front = null, back = null;

	public Card(CardNameEnum cardNameEnum, int buyCost) {

		this.cardNameEnum = cardNameEnum;
		this.buyCost = buyCost;

		for (PhaseEnum phaseEnum : PhaseEnum.values())
			this.cardAbilities.put(phaseEnum, new ArrayList<CardAbilityEnum>());

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
		imageView.setWidth(Credentials.DimensionsCard.x);

		map.put(this, imageView);

	}

	public void addCardTypeEnum(CardTypeEnum cardTypeEnum) {
		this.cardTypeEnum.addLast(cardTypeEnum);
	}

	public void addCardAbility(PhaseEnum phaseEnum, CardAbilityEnum cardAbilityEnum) {
		this.cardAbilities.get(phaseEnum).addLast(cardAbilityEnum);
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

		Executor.runLater(() -> Instances.getControllerInstance().gameState().getCurrentGameState()
				.handleCardPressed(this, this.cardNameEnum, this.cardTypeEnum, this.cardAbilities, this.buyCost));

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

		for (PhaseEnum phaseEnum : PhaseEnum.values())
			if (!this.cardAbilities.get(phaseEnum).isEmpty()) {

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

}
