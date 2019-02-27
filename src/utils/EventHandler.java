package utils;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class EventHandler implements javafx.event.EventHandler<MouseEvent> {

	private EventHandlerAble eventHandlerAble = null;
	private MouseEvent mouseEvent = null;

	public interface EventHandlerAble {

		public default void handleMouseButtonPressedPrimary() {
		};

		public default void handleMouseButtonPressedSecondary() {
		};

		public default void handleMouseEntered() {
		};

		public default void handleMouseExited() {
		};

	}

	public EventHandler(EventHandlerAble eventHandlerAble) {
		this.eventHandlerAble = eventHandlerAble;
	}

	@Override
	public void handle(MouseEvent event) {

		if (Animation.isAnimating())
			return;

		this.mouseEvent = event;

		if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {

			if (event.getButton().equals(MouseButton.PRIMARY))
				Executor.runLater(() -> this.eventHandlerAble.handleMouseButtonPressedPrimary());

			else if (event.getButton().equals(MouseButton.SECONDARY))
				Executor.runLater(() -> this.eventHandlerAble.handleMouseButtonPressedSecondary());

		} else if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED))
			Executor.runLater(() -> this.eventHandlerAble.handleMouseEntered());

		else if (event.getEventType().equals(MouseEvent.MOUSE_EXITED))
			Executor.runLater(() -> this.eventHandlerAble.handleMouseExited());

	}

	public MouseEvent getMouseEvent() {
		return this.mouseEvent;
	}

}
