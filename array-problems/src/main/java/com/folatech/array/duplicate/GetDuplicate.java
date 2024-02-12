package com.folatech.array.duplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Interview question from Synaptec Health
 */
public class GetDuplicate {

	public static void main(String[] args) {

		int[] numbers = new int[] { 1, 2, 3 };

		System.out.println("numbers: " + Arrays.toString(numbers));

		int duplicateNum = getDuplicate(numbers);

		System.out.println("duplicateNum: " + duplicateNum);

		System.out.println("\n");

		numbers = new int[] { 1, 2, 3, 2 };

		System.out.println("numbers: " + Arrays.toString(numbers));

		duplicateNum = getDuplicate(numbers);

		System.out.println("duplicateNum: " + duplicateNum);

		System.out.println("\n");

		numbers = new int[] { 1, 2, 3, 2, 5, 6, 9, 9, 9 };

		System.out.println("numbers: " + Arrays.toString(numbers));

		duplicateNum = getDuplicate(numbers);

		System.out.println("duplicateNum: " + duplicateNum);

		List<Integer> duplicates = getDuplicates(numbers);

		System.out.println("duplicates: " + duplicates);

		Map<Integer, Integer> duplicateCounts = getDuplicateCount(numbers);

		System.out.println("duplicateCounts: " + duplicateCounts);
	}

	/**
	 * Get first duplicate in array
	 */
	static int getDuplicate(int[] numbers) {

		Map<Integer, Integer> numberCount = new HashMap<>();

		for (Integer number : numbers) {
			if (numberCount.containsKey(number)) {
				int value = numberCount.get(number);
				numberCount.put(number, ++value);
			} else {
				numberCount.put(number, 1);
			}
		}

		List<Integer> duplicates = numberCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).collect(Collectors.toList());

		return duplicates.size() > 0 ? duplicates.get(0) : -1;
	}

	/**
	 * Get list of duplicates from array
	 */
	static List<Integer> getDuplicates(int[] numbers) {

		Map<Integer, Integer> numberCount = new HashMap<>();

		for (Integer number : numbers) {
			if (numberCount.containsKey(number)) {
				int value = numberCount.get(number);
				numberCount.put(number, ++value);
			} else {
				numberCount.put(number, 1);
			}
		}

		if (numberCount.isEmpty()) {
			return Arrays.asList();
		}

		// Here's stream way of doing the above task.
//		Arrays.asList(numbers)
//		
//		.stream()
//		
//			.collect(Collectors.groupingBy(num -> num, Collectors.counting())).entrySet()
//		
//		.stream()
//		
//			.filter(m -> m.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		return numberCount.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toList());
	}

	/**
	 * Get duplicate numbers and their count
	 */
	static Map<Integer, Integer> getDuplicateCount(int[] numbers) {

		Map<Integer, Integer> numberCount = new HashMap<>();

		for (Integer number : numbers) {
			if (numberCount.containsKey(number)) {
				int value = numberCount.get(number);
				numberCount.put(number, ++value);
			} else {
				numberCount.put(number, 1);
			}
		}

		if (numberCount.isEmpty()) {
			new HashMap<>();
		}

		Map<Integer, Integer> duplicateCount = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {

			if (entry.getValue() > 1) {
				duplicateCount.put(entry.getKey(), entry.getValue());
			}
		}

		/**
		 * using stream solution
		 */
//		return numberCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
//		.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

		return duplicateCount;

	}
}
