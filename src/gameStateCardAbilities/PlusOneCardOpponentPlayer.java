package gameStateCardAbilities;

import model.Player;

public class PlusOneCardOpponentPlayer extends PlusOneCardAbstract {

	@Override
	protected Player getPlayer() {
		return super.controller.players().getOpponentPlayer();
	}

}
