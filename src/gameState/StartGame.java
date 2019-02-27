package gameState;

import utils.ImageView;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		ImageView a = new ImageView("cards/copper.jpg");
		ImageView b = new ImageView("cards/copper.jpg");

		System.out.println(a.getWidth());
		System.out.println(a.getHeight());
		
		a.setWidth(100);
		b.setWidth(200);
		
		System.out.println(a.getWidth());
		System.out.println(a.getHeight());
		
		b.relocate(300, 0);

	}

}
