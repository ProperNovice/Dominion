package utils;

public class Permutations {

	private static ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	private static int total, permutations;

	private Permutations() {

	}

	public static ArrayList<ArrayList<Integer>> getPermutations(int total,
			int permutations) {

		results.clear();

		Permutations.total = total;
		Permutations.permutations = permutations;

		if (Permutations.total < Permutations.permutations)
			return results;

		addLeaves(new ArrayList<Integer>(), 0);

		return results;

	}

	private static void trimList() {

		if (permutationsComplete())
			return;

		ArrayList<Integer> list = results.remove(0);

		int lastNumberAdded = list.get(list.size() - 1);
		int numberToAdd = lastNumberAdded + 1;

		addLeaves(list, numberToAdd);

	}

	private static void addLeaves(ArrayList<Integer> list, int number) {

		if (number == total) {
			trimList();
			return;
		}

		ArrayList<Integer> listClone = new ArrayList<>(list);

		listClone.addLast(number);
		results.addLast(listClone);

		number++;

		addLeaves(list, number);

	}

	private static boolean permutationsComplete() {
		return results.get(0).size() == permutations;
	}

}
