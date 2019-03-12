package controller;

import enums.TextEnum;
import enums.TextEnum.TextTypeEnum;
import utils.ArrayList;
import utils.Coordinates;
import utils.CoordinatesBuilder;
import utils.ListSizeAble;
import utils.RearrangeTypeEnum;
import utils.TextGame;

public class Text implements ListSizeAble {

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();
	private Coordinates coordinates = null;

	public Text() {

		createCoordinates();
		createTexts();

	}

	private void createCoordinates() {

		this.coordinates = new CoordinatesBuilder().height(Credentials.textHeight)
				.coordinatesNumbersPair(Credentials.CoordinatesTextPanel).objectsPerRow(1)
				.rearrangeTypeEnum(RearrangeTypeEnum.PIVOT).list(this).create();

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

		for (TextGame textGame : this.textGameShowing) {

			textGame.toFront();

			textGame.setVisible(true);
			textGame.relocate(this.coordinates.getCoordinate(this.textGameShowing.indexOf(textGame)));

		}

	}

	public void concealText() {

		for (TextGame textGame : this.textGameShowing)
			textGame.setVisible(false);

		this.textGameShowing.clear();

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

	@Override
	public int getSize() {
		return this.textGameShowing.size();
	}

}
