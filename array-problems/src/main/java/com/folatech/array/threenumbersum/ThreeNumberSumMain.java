package com.folatech.array.threenumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * { "array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 163 }<br>
     * { "array": [-21, 301, 12, 4, 65, 56, 210, 356, 9, -47], "targetSum": 164 }<br>
     * { "array": [3, 5, -4, 8, 11, 1, -1, 6], "targetSum": 15 }<br>
     * { "array": [14], "targetSum": 15 }<br>
     * { "array": [15], "targetSum": 15 }<br>
     */

    /**
     * Level of difficulty - Easy<br>
     * Type - Array
     */
    public static void main(String[] args) {
        int[] numbers = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetTotal = 0;

        List<Integer[]> operands = threeNumberSum(numbers, targetTotal);
        System.out.println("numbers: " + Arrays.toString(numbers));
        System.out.println("targetTotal: " + targetTotal);
        System.out.println("operands: " + operands.toString());

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
                    Integer[] triplet = {array[x], array[left], array[right]};
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
