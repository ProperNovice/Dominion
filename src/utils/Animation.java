package utils;

import javafx.animation.AnimationTimer;

public enum Animation {

	INSTANCE;

	private final double ANIMATION_STEP = 9;
	private ArrayList<NodeAnimation> animationsSynchronous = new ArrayList<>();
	private ArrayList<NodeAnimation> animationsAsynchronous = new ArrayList<>();
	private ArrayList<Node> nodesAnimating = new ArrayList<>();

	private Animation() {

	}

	public enum AnimationSynch {
		SYNCHRONOUS, ASYNCHRONOUS
	}

	public void startAnimation() {
		new AnimationTimerFX().start();
	}

	private class AnimationTimerFX extends AnimationTimer {

		@Override
		public void handle(long time) {

			if (!animationsSynchronous.isEmpty())
				executeAnimationSynchronous();
			if (!animationsAsynchronous.isEmpty())
				executeAnimationAsynchronous();

		}

	}

	private void executeAnimationSynchronous() {

		executeAnimationList(this.animationsSynchronous);

		if (!this.animationsSynchronous.isEmpty())
			return;

		Lock.unlock();

	}

	private void executeAnimationAsynchronous() {

		executeAnimationList(this.animationsAsynchronous);

	}

	private void executeAnimationList(ArrayList<NodeAnimation> animationsList) {

		ArrayList<NodeAnimation> animationsListTemp = animationsList.clone();

		for (NodeAnimation imageViewAnimation : animationsListTemp) {

			imageViewAnimation.executeAnimation();

			if (!imageViewAnimation.animationEnded())
				continue;

			animationsList.remove(imageViewAnimation);
			this.nodesAnimating.remove(imageViewAnimation.getNode());

		}

	}

	private class NodeAnimation {

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

	public void animate(Node node, double endingX, double endingY, AnimationSynch animationSynch) {

		PlatformFX.runLater(() -> {

			if (this.nodesAnimating.contains(node))
				return;

			this.nodesAnimating.addLast(node);

			ArrayList<NodeAnimation> listToAdd = null;

			switch (animationSynch) {

			case SYNCHRONOUS:
				listToAdd = this.animationsSynchronous;
				break;

			case ASYNCHRONOUS:
				listToAdd = this.animationsAsynchronous;
				break;

			}

			node.toFront();
			listToAdd.addLast(new NodeAnimation(node, endingX, endingY));

		});

	}

	public boolean isAnimating() {
		return !this.animationsSynchronous.isEmpty();
	}

}
