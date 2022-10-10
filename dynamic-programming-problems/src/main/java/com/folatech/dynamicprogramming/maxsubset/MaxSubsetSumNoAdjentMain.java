package com.folatech.dynamicprogramming.maxsubset;

import java.util.Arrays;

/**
 * 
 * Problem:
 * 
 * Write a function that takes in an array of positive integers and returns the
 * maximum sum of non-adjacent elements in the array.
 * 
 * If the input array is empty, the function should return 0
 * 
 * Sample input: [75,105,120,75,90,135]
 * 
 * Sample output: 330 -> (75 + 120 + 135)
 * 
 * Reference: https://www.algoexpert.io/questions/max-subset-sum-no-adjacent
 *
 */
public class MaxSubsetSumNoAdjentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = new int[] { 75, 105, 120, 75, 90, 135 };

		maxSubsetSumNoAdjacent(numbers);

		numbers = new int[] {};

		maxSubsetSumNoAdjacent(numbers);

		numbers = new int[] { 1 };

		maxSubsetSumNoAdjacent(numbers);

		numbers = new int[] { 1, 15, 3 };

		maxSubsetSumNoAdjacent(numbers);

		numbers = new int[] { 7, 10, 12, 7, 9, 14 };

		maxSubsetSumNoAdjacent(numbers);

	}

	/**
	 * Solution
	 * 
	 * 
	 * 
	 * O(n) time -  n is the length of the input array
	 * 
	 * O(1) space
	 * 
	 */
	static int maxSubsetSumNoAdjacent(int[] array) {

		System.out.println("array: " + Arrays.toString(array));

		int answer = 0;

		if (array.length == 0) {
			System.out.println("answer: " + answer + "\n\n");
			return 0;
		} else if (array.length == 1) {
			System.out.println("answer: " + array[0] + "\n\n");
			return array[0];
		}

		int first = Math.max(array[0], array[1]);
		int second = array[0];
		int current = 0;

		System.out.println("first: " + first + ", second: " + second + ", current: " + current);

		for (int i = 2; i < array.length; i++) {
			current = Math.max(first, second + array[i]);
			second = first;
			first = current;

			System.out.println("first: " + first + ", second: " + second + ", array[" + i + "]: " + array[i]
					+ ", current: " + current);
		}

		answer = first;

		System.out.println("answer: " + answer + "\n\n");

		return answer;
	}

}
