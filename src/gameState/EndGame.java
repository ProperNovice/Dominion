package gameState;

import enums.PlayerEnum;
import enums.TextEnum;

public class EndGame extends GameStateAbstract {

	@Override
	public void handleGameStateChange() {

		TextEnum textEnum = null;

		int victoryPointsHuman = super.controller.players().getPlayer(PlayerEnum.HUMAN).getVictoryPoints()
				.getVictoryPoints();
		int victoryPointsAI = super.controller.players().getPlayer(PlayerEnum.AI).getVictoryPoints().getVictoryPoints();

		if (victoryPointsHuman > victoryPointsAI)
			textEnum = TextEnum.YOU_WON;
		else if (victoryPointsHuman < victoryPointsAI)
			textEnum = TextEnum.YOU_LOST;
		else if (victoryPointsHuman == victoryPointsAI)
			textEnum = TextEnum.DRAW;

		super.controller.text().showText(textEnum);
		super.controller.text().showText(TextEnum.RESTART);

	}

}
