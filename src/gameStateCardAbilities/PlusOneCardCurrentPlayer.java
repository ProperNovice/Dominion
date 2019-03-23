package gameStateCardAbilities;

import model.Player;

public class PlusOneCardCurrentPlayer extends PlusOneCardAbstract {

	@Override
	protected Player getPlayer() {
		return super.controller.players().getCurrentPlayer();
	}

}
