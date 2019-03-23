package gameState;

import enums.GameStateEnum;
import enums.PhaseEnum;
import enums.PlayerEnum;
import model.Card;
import model.Pile;
import utils.ArrayList;

public class SetVictoryPointsIndicators extends GameStateAbstract {

	private ArrayList<GameStateEnum> victoryPointsCountEnum = new ArrayList<>();
	private int victoryPoints = 0, totalCards = 0;

	@Override
	public void handleGameStateChange() {

		resetCredentials();
		setVictoryPoints(PlayerEnum.HUMAN);

		resetCredentials();
		setVictoryPoints(PlayerEnum.AI);

		super.controller.flow().proceedToNextGameStatePhase();

	}

	private void resetCredentials() {

		this.victoryPointsCountEnum.clear();
		this.victoryPoints = 0;
		this.totalCards = 0;

	}

	private void addVictoryPointsCountEnum(Card card) {

		if (!card.hasPhaseEnum(PhaseEnum.VICTORY_POINTS_COUNT))
			return;

		this.victoryPointsCountEnum.addAll(card.getCardAbilityEnum(PhaseEnum.VICTORY_POINTS_COUNT));

	}

	private void setVictoryPoints(PlayerEnum playerEnum) {

		this.victoryPoints += getVictoryPointsDeck(playerEnum);
		this.victoryPoints += getVictoryPointsDiscardPile(playerEnum);
		this.victoryPoints += getVictoryPointsPlayArea(playerEnum);
		this.victoryPoints += getVictoryPointsHand(playerEnum);
		resolveVictoryPointsCountEnum();

		super.controller.players().getPlayer(playerEnum).getVictoryPoints().setVictoryPointsText(victoryPoints);

	}

	private int getVictoryPointsDeck(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getDeck().getArrayList()) {

			victoryPoints += card.getVictoryPoints();
			addVictoryPointsCountEnum(card);

		}

		this.totalCards += super.controller.players().getPlayer(playerEnum).getDeck().getArrayList().size();

		return victoryPoints;

	}

	private int getVictoryPointsDiscardPile(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getDiscardPile().getArrayList()) {

			victoryPoints += card.getVictoryPoints();
			addVictoryPointsCountEnum(card);

		}

		this.totalCards += super.controller.players().getPlayer(playerEnum).getDiscardPile().getArrayList().size();

		return victoryPoints;

	}

	private int getVictoryPointsPlayArea(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Card card : super.controller.players().getPlayer(playerEnum).getPlayArea().getArrayList()) {

			victoryPoints += card.getVictoryPoints();
			addVictoryPointsCountEnum(card);

		}

		this.totalCards += super.controller.players().getPlayer(playerEnum).getPlayArea().getArrayList().size();

		return victoryPoints;

	}

	private int getVictoryPointsHand(PlayerEnum playerEnum) {

		int victoryPoints = 0;

		for (Pile pile : super.controller.players().getPlayer(playerEnum).getHand().getPiles())
			for (Card card : pile.getArrayList()) {

				victoryPoints += card.getVictoryPoints();
				addVictoryPointsCountEnum(card);

			}

		for (Pile pile : super.controller.players().getPlayer(playerEnum).getHand().getPiles())
			this.totalCards += pile.getArrayList().size();

		return victoryPoints;

	}

	private void resolveVictoryPointsCountEnum() {

		for (GameStateEnum gameStateEnum : this.victoryPointsCountEnum.clone()) {

			switch (gameStateEnum) {

			case WORTH_ONE_VICTORY_POINT_PER_TEN_CARDS_YOU_HAVE_ROUND_DOWN:
				worthOneVictoryPointPerTenCardsYouHaveRoundDown();
				break;

			default:
				break;

			}

		}

	}

	private void worthOneVictoryPointPerTenCardsYouHaveRoundDown() {
		this.victoryPoints += this.totalCards / 10;
	}

}
