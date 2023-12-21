package com.folatech.array.stockmaxprofit;

public class StockProfit {

    public static void main(String[] args) {
        System.out.println(findMaxProfit(new int[]{10, 12, 4, 5, 9})); // Output: 5
        System.out.println(findMaxProfit(new int[]{14, 20, 4, 12, 5, 11})); // Output: 8
        System.out.println(findMaxProfit(new int[]{44, 30, 24, 32, 35, 30, 40, 38, 15})); // Output: 16
        System.out.println(findMaxProfit(new int[]{10, 9, 8, 2})); // Output: -1
    }

    /**
     * Have the function findMaxProfit(arr) take the array of numbers stored in arr which will contain integers that
     * represent the amount in dollars that a single stock is worth, and return the maximum profit that could have been
     * made by buying stock on day x and selling stock on day y where y > x.
     * 
     * For example: if arr is [44, 30, 24, 32, 35, 30, 40, 38, 15] then your program should return 16 because at index 2
     * the stock was worth $24 and at index 6 the stock was then worth $40, so if you bought the stock at 24 and sold it
     * at 40, you would have made a profit of $16, which is the maximum profit that could have been made with this list
     * of stock prices.
     *
     * <p>
     * If there is not profit that could have been made with the stock prices, then your program should return -1. For
     * example: arr is [10, 9, 8, 2] then your program should return -1.
     * 
     * Examples
     * 
     * Input: new int[] {10,12,4,5,9} Output: 5
     * 
     * Input: new int[] {14,20,4,12,5,11} Output: 8
     * 
     */
    public static int findMaxProfit(int[] arr) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int size = arr.length; // Variable name as requested

        for (int i = 0; i < size; i++) {
            // Update the minimum price if a lower price is found
            int profit = arr[i] - minPrice;
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }
            // Calculate profit if current price is higher than the minimum price
            else if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Return -1 if no profit can be made, else return maxProfit
        return maxProfit > 0 ? maxProfit : -1;
    }
}
