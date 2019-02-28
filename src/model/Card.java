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
import utils.ImageView;
import utils.ImageViewAble;
import utils.Instances;
import utils.Logger;

public class Card implements EventHandlerAble, ImageViewAble {

	private CardNameEnum cardNameEnum = null;
	private ArrayList<CardTypeEnum> cardTypeEnum = new ArrayList<>();
	private int buyCost = -1, treasure = 0, victoryPoints = 0;
	private HashMap<PhaseEnum, ArrayList<CardAbilityEnum>> abilities = new HashMap<>();

	public Card(CardNameEnum cardNameEnum, int buyCost) {

		this.cardNameEnum = cardNameEnum;
		this.buyCost = buyCost;

		for (PhaseEnum phaseEnum : PhaseEnum.values())
			this.abilities.put(phaseEnum, new ArrayList<CardAbilityEnum>());

		createImageView();

	}

	public void addCardTypeEnum(CardTypeEnum cardTypeEnum) {
		this.cardTypeEnum.addLast(cardTypeEnum);
	}

	public void addCardAbility(PhaseEnum phaseEnum, CardAbilityEnum cardAbilityEnum) {
		this.abilities.get(phaseEnum).addLast(cardAbilityEnum);
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

		Executor.runLater(() -> Instances.getControllerInstance().gameStateManager().getCurrentGameState()
				.handleCardPressed(this, this.cardNameEnum, this.cardTypeEnum, this.abilities, this.buyCost));

	}

	private void printCard() {

		String seperator = "*******";

		Logger.log(seperator);

		Logger.log(this.cardNameEnum);
		Logger.log("buy cost -> " + this.buyCost);

		for (CardTypeEnum cardTypeEnum : this.cardTypeEnum)
			Logger.log(cardTypeEnum);

		if (this.treasure != 0)
			Logger.log("treasure -> " + this.treasure);

		if (this.victoryPoints != 0)
			Logger.log("victory points -> " + this.victoryPoints);

		for (PhaseEnum phaseEnum : PhaseEnum.values())
			if (!this.abilities.get(phaseEnum).isEmpty()) {

				Logger.log(phaseEnum);
				this.abilities.get(phaseEnum).printList();

			}

		Logger.log(seperator);
		Logger.newLine();

	}

	private void createImageView() {

		String path = "";
		path += "cards/";
		path += this.cardNameEnum.getString();
		path += ".jpg";

		ImageView imageView = new ImageView(path, this);
		imageView.setWidth(Credentials.cardGameWidth);

		map.put(this, imageView);

	}

}
