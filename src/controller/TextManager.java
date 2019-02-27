package controller;

import enums.TextEnum;
import utils.ArrayList;
import utils.TextGame;

public class TextManager {

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();
	private double coordinatesX = Credentials.CoordinatesTextPanel.x, coordinatesY = Credentials.CoordinatesTextPanel.y;

	public TextManager() {
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

}
