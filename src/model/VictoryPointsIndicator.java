package model;

import controller.Credentials;
import enums.PlayerEnum;
import utils.NumbersPair;
import utils.TextIndicator;

public class VictoryPointsIndicator {

	private String textPlayer = null;
	private int victoryPoints = -1;
	private TextIndicator textIndicator = null;

	public VictoryPointsIndicator(PlayerEnum playerEnum) {

		this.textPlayer = playerEnum.string();
		this.textPlayer += " : ";

		this.textIndicator = new TextIndicator();
		this.textIndicator.setHeight(Credentials.textHeight);
		setVictoryPointsText(3);

	}

	public void relocate(NumbersPair numbersPair) {
		this.textIndicator.relocate(numbersPair);
	}

	public void setVictoryPointsText(int victoryPoints) {

		this.victoryPoints = victoryPoints;
		this.textIndicator.setText(this.textPlayer + this.victoryPoints);

	}

	public int getVictoryPoints() {
		return this.victoryPoints;
	}

}
