package com.folatech.array.twonumbersum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoNumberSumMain {

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
        int[] numbers = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetTotal = 10;

        int[] operands = twoNumberSum(numbers, targetTotal);
        System.out.println("numbers: " + Arrays.toString(numbers));
        System.out.println("targetTotal: " + targetTotal);
        System.out.println("operands: " + Arrays.toString(operands));

        operands = twoNumberSumWithSortedArray(numbers, targetTotal);

        System.out.println("operands: " + Arrays.toString(operands));

        operands = twoNumberSumWithSet(numbers, targetTotal);
        System.out.println("operands: " + Arrays.toString(operands));

    }

    /**
     * Time O(n^2)<br>
     * Space O(1)
     */
    private static int[] twoNumberSum(int[] array, int targetSum) {
        int size = array.length;

        if (size < 2) {
            return new int[0];
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == y) {
                    continue;
                }

                if (array[x] + array[y] == targetSum) {
                    int[] operands = new int[2];
                    operands[0] = array[x];
                    operands[1] = array[y];
                    return operands;
                }

            }
        }

        return new int[0];
    }

    /**
     * Time O(nlogn)<br>
     * Space O(1)<br>
     * if space is more important than time, this is the optimal solution
     */
    private static int[] twoNumberSumWithSortedArray(int[] array, int targetSum) {

        int size = array.length;

        if (size < 2) {
            return new int[0];
        }

        /**
         * Time O(nlogn)
         */
        Arrays.sort(array);

        int left = 0;
        int right = size - 1;

        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (sum < targetSum) {
                left++;
            } else if (sum > targetSum) {
                right--;
            }
        }

        return new int[0];
    }

    /**
     * Time O(n)<br>
     * Space O(n)<br>
     * if time is more important than space, this is the optimal solution
     */
    private static int[] twoNumberSumWithSet(int[] array, int targetSum) {

        int size = array.length;

        if (size < 2) {
            return new int[0];
        }

        Map<Integer, Integer> nums = new HashMap<>();

        for (int num : array) {

            int match = targetSum - num;

            if (nums.containsKey(match)) {
                return new int[]{match, num};
            } 
            
            nums.put(num, num);
        }

        return new int[0];
    }
}
