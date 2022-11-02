package com.folatech.list;

public class KaratTestMain {

    public static void main(String[] args) {

        int price[] = {9, 8, 7, 6, 5, 4, 3};

        int n = price.length;

        System.out.print(getMaxProfit(price, 0, n - 1));
    }

    static int getMaxProfit(int price[], int start, int end) {

        if (end <= start) {
            return 0;
        }

        int profit = 0;

        for (int i = start; i < end; i++) {

            for (int j = i + 1; j <= end; j++) {

                if (price[j] > price[i]) {

                    int curr_profit = price[j] - price[i] + getMaxProfit(price, start, i - 1) + getMaxProfit(price, j + 1, end);

                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

}
