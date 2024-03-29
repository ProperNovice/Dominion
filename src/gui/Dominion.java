package gui;

import controller.Controller;
import controller.Credentials;
import controller.ObjectsPool;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Animation;
import utils.Executor;
import utils.Logger;
import utils.ShutDown;

public class Dominion extends Application {

	private Panel panel = null;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Animation.INSTANCE.startAnimation();
		ObjectsPool.INSTANCE.create();
		Logger.startLogging();
		Credentials.calculateCredentials();

		this.panel = new Panel();

		double width = Credentials.DimensionsFrame.x + Credentials.DimensionsInsets.x;
		double height = Credentials.DimensionsFrame.y + Credentials.DimensionsInsets.y;

		Scene scene = new Scene(this.panel);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				KeyCode keyCode = event.getCode();

				Logger.logNewLine(keyCode + " keyCode pressed");

				Executor.runLater(() -> {

					if (Animation.INSTANCE.isAnimating())
						return;

					Controller.INSTANCE.gameState().getCurrentGameState().executeKeyPressed(keyCode);

				});

			}
		});

		primaryStage.setScene(scene);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setResizable(false);

		primaryStage.setTitle("Dominion");

		primaryStage.setX((Screen.getPrimary().getBounds().getWidth() - width) / 2 - 180);
		primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - height) / 2 - 20);

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				ShutDown.execute();
			}

		});

		primaryStage.show();

		this.panel.startGame();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
