package utils;

public class NumbersPair {

	public double x;
	public double y;

	public NumbersPair(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public void print() {

		Logger.log("x -> " + this.x);
		Logger.log("y -> " + this.y);
		Logger.newLine();

	}

}
