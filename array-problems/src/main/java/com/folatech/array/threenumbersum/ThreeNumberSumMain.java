package com.folatech.array.threenumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Reference: https://www.algoexpert.io/questions/three-number-sum
 * 
 * 
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. The function should find all triplets in
 * the array that sum up to the target sum and return a two-dimensional array of
 * all these triplets. The numbers in each triplet should be ordered in
 * ascending order, and the triplets themselves should be ordered in ascending
 * order with respect to the numbers they hold.
 * 
 * 
 * If no three numbers sum up to the target sum, the function should return an
 * empty array.
 *
 * Sample Input = [12, 3, 1, 2, -6, 5, -8, 6], target sum = 0
 * 
 * Sample Output = [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 */
public class ThreeNumberSumMain {

	/**
	 * inputs<br>
	 * { "array": [3, 5, -4, 8, 11, 1, -1, 6], "targetSum": 10 }<br>
	 * { "array": [4, 6], "targetSum": 10 }<br>
	 * { "array": [4, 6, 1], "targetSum": 5 }<br>
	 * { "array": [4, 6, 1, -3], "targetSum": 3 }<br>
	 * { "array": [1, 2, 3, 4, 5, 6, 7, 8, 9], "targetSum": 17 }<br>
	 * { "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15], "targetSum": 18 }<br>
	 * { "array": [-7, -5, -3, -1, 0, 1, 3, 5, 7], "targetSum": -5 }<br>
	 * { "array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 163
	 * }<br>
	 * { "array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 164
	 * }<br>
	 * { "array": [3, 5, -4, 8, 11, 1, -1, 6], "targetSum": 15 }<br>
	 * { "array": [14], "targetSum": 15 }<br>
	 * { "array": [15], "targetSum": 15 }<br>
	 */

	/**
	 * Level of difficulty - Easy<br>
	 * Type - Array
	 */
	public static void main(String[] args) {
		int[] numbers = { 12, 3, 1, 2, -6, 5, -8, 6 };
		int targetTotal = 0;

		List<Integer[]> operands = threeNumberSum(numbers, targetTotal);
		System.out.println("numbers: " + Arrays.toString(numbers));
		System.out.println("targetTotal: " + targetTotal);

		operands.stream().forEach(array -> {
			System.out.println("array: " + Arrays.toString(array));
		});

	}

	/**
	 * Time O(n^2)<br>
	 * Space O(n)
	 */
	private static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		int size = array.length;

		List<Integer[]> answers = new ArrayList<>();

		if (size < 2) {
			return answers;
		}

		Arrays.sort(array);

		for (int x = 0; x < size - 2; x++) {
			int left = x + 1;
			int right = size - 1;

			while (left < right) {
				int sum = array[x] + array[left] + array[right];

				if (sum == targetSum) {
					Integer[] triplet = { array[x], array[left], array[right] };
					answers.add(triplet);

					left++;
					right--;

				} else if (sum < targetSum) {

					left++;

				} else if (sum > targetSum) {

					right--;

				}
			}
		}

		return answers;
	}

}
