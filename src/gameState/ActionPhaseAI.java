package gameState;

import enums.CardTypeEnum;
import enums.TextEnum;
import model.Card;
import model.Pile;

public class ActionPhaseAI extends ActionPhaseAbstract {

	@Override
	public void handleGameStateChange() {

		super.controller.text().showText(TextEnum.ACTION_PHASE);
		super.controller.text().showText(TextEnum.RESOLVE_ACTION);

	}

	@Override
	protected void executeTextOption(TextEnum textEnum) {

		Card cardToResolve = null;

		for (Pile pile : super.controller.players().getCurrentPlayer().getHand().getPiles()) {

			if (!pile.getArrayList().getFirst().isCardType(CardTypeEnum.ACTION))
				continue;

			cardToResolve = pile.getArrayList().getFirst();
			break;

		}

		super.resolveActionCard(cardToResolve);
		super.controller.flow().proceedToNextGameStatePhase();

	}

}
