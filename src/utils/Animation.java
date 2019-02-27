package utils;

import javafx.animation.AnimationTimer;

public class Animation {

	private static final double ANIMATION_STEP = 9;
	private static ArrayList<NodeAnimation> animationsSynchronous = new ArrayList<>();
	private static ArrayList<NodeAnimation> animationsAsynchronous = new ArrayList<>();
	private static ArrayList<Node> nodesAnimating = new ArrayList<>();

	private Animation() {

	}

	public enum AnimationSynch {
		SYNCHRONOUS, ASYNCHRONOUS
	}

	public static void startAnimation() {
		new AnimationTimerFX().start();
	}

	private static class AnimationTimerFX extends AnimationTimer {

		@Override
		public void handle(long time) {

			if (!animationsSynchronous.isEmpty())
				executeAnimationSynchronous();
			if (!animationsAsynchronous.isEmpty())
				executeAnimationAsynchronous();

		}

	}

	private static void executeAnimationSynchronous() {

		executeAnimationList(animationsSynchronous);

		if (!animationsSynchronous.isEmpty())
			return;

		Lock.unlock();

	}

	private static void executeAnimationAsynchronous() {

		executeAnimationList(animationsAsynchronous);

	}

	private static void executeAnimationList(ArrayList<NodeAnimation> animationsList) {

		ArrayList<NodeAnimation> animationsListTemp = animationsList.clone();

		for (NodeAnimation imageViewAnimation : animationsListTemp) {

			imageViewAnimation.executeAnimation();

			if (!imageViewAnimation.animationEnded())
				continue;

			animationsList.remove(imageViewAnimation);
			nodesAnimating.remove(imageViewAnimation.getNode());

		}

	}

	private static class NodeAnimation {

		private Node node = null;
		private double currentX, currentY;
		private double endingX, endingY;
		private boolean animationEnded = false;
		private double stepX, stepY;

		public NodeAnimation(Node node, double endingX, double endingY) {

			this.node = node;
			this.endingX = endingX;
			this.endingY = endingY;

			calculateCedentials();

		}

		private void calculateCedentials() {

			this.currentX = this.node.getLayoutX();
			this.currentY = this.node.getLayoutY();

			double differenceX = Math.abs(this.endingX - this.currentX);
			double differenceY = Math.abs(this.endingY - this.currentY);

			if (differenceX > differenceY) {

				this.stepX = ANIMATION_STEP;
				this.stepY = differenceY * ANIMATION_STEP / differenceX;

			} else if (differenceY > differenceX) {

				this.stepX = differenceX * ANIMATION_STEP / differenceY;
				this.stepY = ANIMATION_STEP;

			} else if (differenceX == differenceY) {

				this.stepX = ANIMATION_STEP;
				this.stepY = ANIMATION_STEP;

			}

		}

		public void executeAnimation() {

			executeX();
			executeY();

			this.node.relocate(this.currentX, this.currentY);

			if (this.currentX != this.endingX)
				return;

			if (this.currentY != this.endingY)
				return;

			this.animationEnded = true;

		}

		private void executeX() {

			if (this.currentX == this.endingX)
				return;

			if (Math.abs(this.endingX - this.currentX) <= this.stepX) {
				this.currentX = this.endingX;
				return;
			}

			if (this.currentX < this.endingX)
				this.currentX += this.stepX;
			else if (this.currentX > this.endingX)
				this.currentX -= this.stepX;

		}

		private void executeY() {

			if (this.currentY == this.endingY)
				return;

			if (Math.abs(this.endingY - this.currentY) <= this.stepY) {
				this.currentY = this.endingY;
				return;
			}

			if (this.currentY < this.endingY)
				this.currentY += this.stepY;
			else if (this.currentY > this.endingY)
				this.currentY -= this.stepY;

		}

		public boolean animationEnded() {
			return this.animationEnded;
		}

		public Node getNode() {
			return this.node;
		}

	}

	public static void animate(Node node, double endingX, double endingY, AnimationSynch animationSynch) {

		PlatformFX.runLater(() -> {

			if (nodesAnimating.contains(node))
				return;

			nodesAnimating.addLast(node);

			ArrayList<NodeAnimation> listToAdd = null;

			switch (animationSynch) {

			case SYNCHRONOUS:
				listToAdd = animationsSynchronous;
				break;

			case ASYNCHRONOUS:
				listToAdd = animationsAsynchronous;
				break;

			}

			node.toFront();
			listToAdd.addLast(new NodeAnimation(node, endingX, endingY));

		});

	}

	public static boolean isAnimating() {

		if (animationsSynchronous.isEmpty())
			return false;

		return true;

	}

}
