package com.folatech.array.subarray;

import java.util.List;

/**
 * 
 */
public class ValidateSubsequence {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 1, 22, 25, 6, -1, 8, 10);
		List<Integer> sequence = List.of(1, 6, -1, 10);

		System.out.println("list: " + list);
		System.out.println("sequence: " + sequence);
		boolean result = isValidSubsequence(list, sequence);
		System.out.println("result: " + result+"\n");

		list = List.of();
		sequence = List.of();

		System.out.println("list: " + list);
		System.out.println("sequence: " + sequence);
		result = isValidSubsequence(list, sequence);
		System.out.println("result: " + result+"\n");
	}

	/**
	 * Reference: https://www.algoexpert.io/questions/validate-subsequence
	 * 
	 * Given two non-empty arrays of integers, write a function that determines
	 * whether the second array is a subsequence of the first one.
	 * 
	 * 
	 * A subsequence of an array is a set of numbers that aren't necessarily
	 * adjacent in the array but that are in the same order as they appear in the
	 * array. For instance, the numbers [1, 3, 4] form a subsequence of the array
	 * [1, 2, 3, 4] , and so do the numbers [2, 4]
	 * 
	 * Note that a single number in an array and the array itself are both valid
	 * subsequences of the array.
	 * 
	 * Sample Input
	 * 
	 * array = [5, 1, 22, 25, 6, -1, 8, 10]
	 * 
	 * sequence = = [1, 6, -1, 10]
	 * 
	 * Sample Output
	 * 
	 * true
	 */

	static boolean isValidSubsequence(List<Integer> list, List<Integer> sequence) {

		return false;
	}
}
