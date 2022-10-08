package com.folatech.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in an array of unique integers and returns an
 * array of all permutations of those integers in no particular order.<br>
 * 
 * If the input array is empty, the function should return an empty array. <br>
 * 
 * Sample input: [1, 2, 3]<br>
 * 
 * Sample output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2,
 * 1]]<br>
 * 
 * <br>
 * Reference: https://www.algoexpert.io/questions/permutations
 *
 */
public class IntPermutations {

	public static void main(String[] args) {

		List<Integer> lists = List.of(1, 2, 3, 4);

		System.out.println("lists: " + lists);
		System.out.println("permutations: " + getPermutations(lists) + "\n");

	}

	public static List<List<Integer>> getPermutations(List<Integer> list) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		getPermutations(list, new ArrayList<Integer>(), permutations, 1);
		return permutations;
	}

	public static void getPermutations(List<Integer> list, List<Integer> currentPermutation,
			List<List<Integer>> permutations, int depth) {

		System.out.println("list: " + list + ", currentPermutation: " + currentPermutation + ", permutations: "
				+ permutations + ", depth: " + depth);

		if (list.size() == 0 && currentPermutation.size() > 0) {
			System.out.println("added currentPermutation: " + currentPermutation + ", depth: " + depth + "\n\n");
			permutations.add(currentPermutation);
		} else {

			for (int i = 0; i < list.size(); i++) {
				List<Integer> newList = new ArrayList<>(list);
				newList.remove(i);

				List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(list.get(i));
				System.out.println("i: " + i + ", depth: " + depth);
				getPermutations(newList, newPermutation, permutations, (depth + 1));
			}
		}

	}
}
