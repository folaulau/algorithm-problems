package com.folatech.array.buyandsellstock;

import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * 
 * Output: 5
 * 
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed
 * because you must buy before you sell.
 * 
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * 
 * Output: 0
 * 
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BuyAndSellStock {

	public static void main(String[] args) {

		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };

		System.out.println("prices: " + Arrays.toString(prices));

		int mProfit = maxProfit(prices);

		System.out.println("mProfit: " + mProfit);
		
        System.out.println("maxProfitDay: " + maxProfitDay((prices)));

        int[] buySellDays = maxProfitDays(prices);
        System.out.println("buy: " + buySellDays[0]+", sell: "+buySellDays[1]);
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int profit = 0, min = prices[0];

		/**
		 * loop through prices
		 */
		for (int i = 1; i < prices.length; i++) {

			/**
			 * check if min is greater than current price,
			 */
			if (min > prices[i]) {
				min = prices[i];
			} else {
				/**
				 * check if min is greater than current price,
				 */
				int currentProfit = prices[i] - min;
				profit = Math.max(profit, currentProfit);
			}

		}
		return profit;
	}
	
    public static int maxProfitDay(int[] prices){

        // keep track of the smallest number.

        int min = prices[0];
        int profit = 0;
        int maxProDay = 0;

        for(int i = 0; i < prices.length; i++) {

            if(min > prices[i]){
                min = prices[i];
            }else{
                int currentProfit = prices[i] - min;

                if(currentProfit > profit){
                    profit = currentProfit;
                    maxProDay = i;
                }
            }
        }

        return maxProDay;

    }

    public static int[] maxProfitDays(int[] prices){

        // keep track of the smallest number.

        int min = prices[0];
        int profit = 0;
        int minProDay = 0;
        int maxProDay = 0;

        for(int i = 0; i < prices.length; i++) {

            if(min > prices[i]){
                min = prices[i];
                minProDay = i;
            }else{
                int currentProfit = prices[i] - min;

                if(currentProfit > profit){
                    profit = currentProfit;
                    maxProDay = i;
                }
            }
        }

        return new int[]{minProDay, maxProDay};

    }

}
