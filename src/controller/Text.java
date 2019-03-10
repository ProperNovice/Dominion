package controller;

import enums.TextEnum;
import enums.TextEnum.TextTypeEnum;
import utils.ArrayList;
import utils.TextGame;

public class Text {

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();
	private double coordinatesX = Credentials.CoordinatesTextPanel.x, coordinatesY = Credentials.CoordinatesTextPanel.y;

	public Text() {
		createTexts();
	}

	private void createTexts() {

		for (TextEnum textEnum : TextEnum.values())
			this.textGame.addLast(new TextGame(textEnum));

	}

	public void showText(TextEnum textEnum) {

		for (TextGame textGame : this.textGame) {

			if (!textGame.getTextEnum().equals(textEnum))
				continue;

			this.textGameShowing.addLast(textGame);
			break;

		}

		showText();

	}

	private void showText() {

		double currentCoordinatesY = this.coordinatesY;

		for (TextGame textGame : this.textGameShowing) {

			textGame.toFront();

			textGame.setVisible(true);
			textGame.relocate(this.coordinatesX, currentCoordinatesY);

			currentCoordinatesY += Credentials.textHeight;

			if (textGame.getTextEnum().string().contains("\n"))
				currentCoordinatesY += Credentials.textHeight;

		}

	}

	public void concealText() {

		for (TextGame textGame : this.textGameShowing)
			textGame.setVisible(false);

		this.textGameShowing.clear();

	}

	public void setCoordinates(double coordinatesX, double coordinatesY) {
		this.coordinatesX = coordinatesX;
		this.coordinatesY = coordinatesY;
	}

	public TextEnum getTextEnumOptionShowing(int textOptionListOrder) {

		int textOptionId = 0;

		for (TextGame textGame : this.textGameShowing) {

			TextEnum textEnum = textGame.getTextEnum();

			if (textEnum.textTypeEnum() == TextTypeEnum.INDICATOR)
				continue;

			textOptionId++;

			if (textOptionListOrder == textOptionId)
				return textEnum;

		}

		return null;

	}

}
