package gameState;

import controller.Credentials;
import utils.ImageView;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		ImageView a = new ImageView("cards/province.jpg");
		ImageView b = new ImageView("cards/province.jpg");

		System.out.println(a.getWidth());
		System.out.println(a.getHeight());

		a.setWidth(Credentials.cardGameWidth);
		b.setWidth(Credentials.cardIndicatorWidth);

		System.out.println(a.getWidth());
		System.out.println(a.getHeight());

		b.relocate(300, 0);
		
		System.out.println(a);
		System.out.println(b);

	}

}
