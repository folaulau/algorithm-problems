package com.folatech.greedyprogramming.minimumwaitingtime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWaitingTimeMain {

    public static void main(String[] args) {

        int[] waitingTimes = {3, 2, 1, 2, 6};

        int minimumWaitingTime = getMinimumWaitingTime(waitingTimes);

        System.out.println("minimumWaitingTime: " + minimumWaitingTime);
    }

    static int getMinimumWaitingTime(int[] queries) {
        System.out.println("waitingTimes: " + Arrays.toString(queries));

        /**
         * sort the array to help getting the minimum total waiting time
         */
        Arrays.sort(queries);

        int size = queries.length;

        if (size <= 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int currentWaitingTime = 0;
            int previousTotalWaitingTime = 0;

            if (i != 0) {
                currentWaitingTime = queries[i - 1];
                previousTotalWaitingTime = currentWaitingTime + map.get(i - 1);
            }

            map.put(i, previousTotalWaitingTime);

            totalWaitingTime += previousTotalWaitingTime;

            System.out.println("index: " + i + ", previousTotalWaitingTime: " + previousTotalWaitingTime + ", totalWaitingTime: " + totalWaitingTime);

        }

        // minimumWaitingTime = map.values().stream().reduce(0, Integer::sum);

        return totalWaitingTime;
    }
}
