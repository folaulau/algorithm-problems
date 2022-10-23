package com.folatech.array.sorting;

import java.util.Arrays;

/**
 * Reference: https://www.algoexpert.io/questions/sorted-squared-array
 * 
 * Square every number in array and sort it
 */
public class SortedSquaredArray {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5 };

		System.out.println("array: " + Arrays.toString(array));

		int[] squaredArray = squareArray(array);

		System.out.println("squaredArray: " + Arrays.toString(squaredArray));

	}

	static int[] squareArray(int[] array) {

		int[] squaredArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			int num = array[i];

			squaredArray[i] = (int) (Math.pow(num, 2));
		}

		Arrays.sort(squaredArray);

		return squaredArray;
	}
}
