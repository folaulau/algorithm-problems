package com.folatech.array.subarray;

import java.util.List;

/**
 * 
 */
public class ValidateSubsequence {

	public static void main(String[] args) {

		List<Integer> list = List.of(5, 1, 22, 25, 6, -1, 8, 10, 17, 29);
		List<Integer> sequence = List.of(1, 6, -1, 10);

		System.out.println("list: " + list);
		System.out.println("sequence: " + sequence);
		boolean result = isValidSubsequence(list, sequence);
		System.out.println("result: " + result + "\n");

		list = List.of(5, 1, 22, 25, 6, -1, 8, 10);
		sequence = List.of(5, 1, 22, 6, -1, 8, 10);

		System.out.println("list: " + list);
		System.out.println("sequence: " + sequence);
		result = isValidSubsequence(list, sequence);
		System.out.println("result: " + result + "\n");

		list = List.of(5, 1, 22, 25, 6, -1, 8, 10);
		sequence = List.of(25, 34);

		System.out.println("list: " + list);
		System.out.println("sequence: " + sequence);
		result = isValidSubsequence(list, sequence);
		System.out.println("result: " + result + "\n");

		list = List.of(5, 1, 22, 25, 6, -1, 8, 10, 19, 45);
		List<Integer> sequence1 = List.of(25, 8, 10);
		List<Integer> sequence2 = List.of(5, 6, 8);

		System.out.println("list: " + list);
		System.out.println("sequence1: " + sequence1);
		System.out.println("sequence2: " + sequence2);
		result = isValidSubsequences(list, sequence1, sequence2);
		System.out.println("result: " + result + "\n");

		list = List.of(5, 1, 22, 25, 6, -1, 8, 10, 19, 45);
		sequence1 = List.of(25, 8, 10);
		sequence2 = List.of(5, 6, 8, 89);

		System.out.println("list: " + list);
		System.out.println("sequence1: " + sequence1);
		System.out.println("sequence2: " + sequence2);
		result = isValidSubsequences(list, sequence1, sequence2);
		System.out.println("result: " + result + "\n");
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
	 * 
	 * Solution
	 * 
	 * - loop through both arrays
	 * 
	 * - always move on array but only move in sequence when there is a match in
	 * array and sequence.
	 * 
	 * -
	 */

	static boolean isValidSubsequence(List<Integer> list, List<Integer> sequence) {

		int listIndex = 0;
		int seqIndex = 0;

		int listSize = list.size();
		int seqSize = sequence.size();

		/**
		 * Using for loop
		 * 
		 * loop through main array/list
		 * 
		 * only move sub array if there is a match
		 * 
		 * break out if sub array size is less than main array iteration index
		 * 
		 * true if
		 */
		for (int i = 0; i < listSize; i++) {

			System.out.println("list i: " + list.get(i));
			System.out.println("sequence i: " + sequence.get(seqIndex));

			if (list.get(i).equals(sequence.get(seqIndex))) {
				seqIndex += 1;
			}

			if (seqIndex == seqSize) {
				break;
			}

		}

//		/**
//		 * Using while loop
//		 * check if any of list finishes iteration
//		 */
//		while (listIndex < listSize && seqIndex < seqSize) {
//
//			System.out.println("list i: " + list.get(listIndex));
//			System.out.println("sequence i: " + sequence.get(seqIndex));
//
//			if (list.get(listIndex).equals(sequence.get(seqIndex))) {
//
//				seqIndex += 1;
//
//			}
//
//			listIndex += 1;
//
//		}

		/**
		 * if loop through til ends of sequence then it's true else false
		 */
		return (seqSize == seqIndex);
	}

	static boolean isValidSubsequences(List<Integer> list, List<Integer> sequence1, List<Integer> sequence2) {

		int seq1Index = 0;
		int seq2Index = 0;

		int listSize = list.size();
		int seq1Size = sequence1.size();
		int seq2Size = sequence2.size();

		/**
		 * Using for loop
		 * 
		 * loop through main array/list
		 * 
		 * only move sub array if there is a match
		 * 
		 * make sure to check for index is less then size else it will blow up
		 * 
		 * true if
		 */
		for (int i = 0; i < listSize; i++) {

			System.out.println("list i: " + list.get(i));

			try {
				System.out.println("sequence1 i: " + sequence1.get(seq1Index));
			} catch (Exception e) {
			}

			if (seq1Index < seq1Size && list.get(i).equals(sequence1.get(seq1Index))) {
				seq1Index += 1;
			}

			try {
				System.out.println("sequence2 i: " + sequence2.get(seq2Index));
			} catch (Exception e) {
			}

			if (seq2Index < seq2Size && list.get(i).equals(sequence2.get(seq2Index))) {
				seq2Index += 1;
			}

		}

		/**
		 * if loop through til ends of sequence then it's true else false
		 */
		return (seq1Size == seq1Index && seq2Size == seq2Index);
	}
}
