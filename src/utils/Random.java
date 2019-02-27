package utils;

public class Random {

	private static java.util.Random random = new java.util.Random();

	public static int getRandomNumber(int firstNumber, int secondNumber) {
		return firstNumber + random.nextInt(secondNumber - firstNumber + 1);
	}

	public static boolean chanceOutcome(double chance) {

		double rng = getRandomNumber(1, 100);

		if (rng <= chance)
			return true;
		else
			return false;

	}

}
