package com.folatech.array.nonconstructiblechange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reference: https://www.algoexpert.io/questions/non-constructible-change
 *
 * Given an array of positive integers representing the values of coins in your
 * possession, write a function that returns the minimum amount of change (the
 * minimum sum of money) that you cannot create. The given coins can have any
 * positive integer value and aren't necessarily unique (i.e., you can have
 * multiple coins of the same value).
 * 
 * 
 * For example, if you're given coins = [1, 2, 5] , the minimum amount of change
 * that you can't create is 4. If you're given no coins, the minimum amount of
 * change that you can't create is 1
 * 
 * Sample Input: = [5, 7, 1, 1, 2, 3, 22]
 * 
 * Sample Output = 20
 * 
 * video: https://www.youtube.com/watch?v=nD2RD4PlO-4,
 * https://www.youtube.com/watch?v=EMv62PjeiQM solution:
 * https://github.com/pinglu85/algoExpert/blob/main/Easy/non-constructible-change.md,
 * https://lei-d.gitbook.io/leetcode/math/smallest-non-constructible-value
 */
public class NonConstructibleChange {

	public static void main(String[] args) {
		List<Integer> coins = List.of(5, 7, 1, 1, 2, 3, 22);

		System.out.println("coins: " + coins);

		int change = getNonConstructibleChange(coins);

		System.out.println("change: " + change);
		
		change = getNonConstructibleChange(new int[] {5, 7, 1, 1, 2, 3, 22});

		System.out.println("change: " + change);
		
		change = getNonConstructibleChange(new int[] {1, 1, 1, 1, 1});

		System.out.println("change: " + change);
		
		change = getNonConstructibleChange(new int[] {1, 5, 1, 1, 1, 10, 15, 20, 100});

		System.out.println("change: " + change);
	}

	static int getNonConstructibleChange(List<Integer> money) {
		
		List<Integer> coins = new ArrayList<>(money);
		Collections.sort(coins);
		
		System.out.println("sorted coins: " + coins);
		
		int currentChange = 0;
		
		for(Integer coin : coins) {
			
			System.out.println("coin: " + coin+", (currentChange+1): "+(currentChange+1));
			
			if(coin > (currentChange+1)) {
				return (currentChange+1);
			}
			
			currentChange+=coin;
		}

		return currentChange+1;
	}
	
	static int getNonConstructibleChange(int[] coins) {
		Arrays.sort(coins);
		
		System.out.println("sorted coins: " + Arrays.toString(coins));
		
		int currentChange = 0;
		
		for(Integer coin : coins) {
			
			System.out.println("coin: " + coin+", (currentChange+1): "+(currentChange+1));
			
			if(coin > (currentChange+1)) {
				return (currentChange+1);
			}
			
			currentChange+=coin;
		}

		return currentChange+1;
	}
}
