package gameState;

import enums.PlayerEnum;
import model.Card;
import model.Pile;

public class SetVictoryPointsIndicators extends GameState {

	@Override
	public void handleGameStateChange() {

		setVictoryPoints(PlayerEnum.HUMAN);
		setVictoryPoints(PlayerEnum.AI);
		
		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void setVictoryPoints(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		victoryPoints += getVictoryPointsDeck(playerEnum);
		victoryPoints += getVictoryPointsDiscardPile(playerEnum);
		victoryPoints += getVictoryPointsPlayArea(playerEnum);
		victoryPoints += getVictoryPointsHand(playerEnum);

		super.controller.players().getPlayer(playerEnum).getVictoryPoints().setVictoryPointsText(victoryPoints);

	}

	private int getVictoryPointsDeck(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getDeck().getArrayList())
			victoryPoints += card.getVictoryPoints();

		return victoryPoints;

	}

	private int getVictoryPointsDiscardPile(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getDiscardPile().getArrayList())
			victoryPoints += card.getVictoryPoints();

		return victoryPoints;

	}

	private int getVictoryPointsPlayArea(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getPlayArea().getArrayList())
			victoryPoints += card.getVictoryPoints();

		return victoryPoints;

	}

	private int getVictoryPointsHand(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Pile pile : super.controller.players().getPlayer(playerEnum).getHand().getPiles())
			for (Card card : pile.getArrayList())
				victoryPoints += card.getVictoryPoints();

		return victoryPoints;

	}

}
