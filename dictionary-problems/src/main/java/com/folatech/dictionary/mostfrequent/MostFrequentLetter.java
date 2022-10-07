package com.folatech.dictionary.mostfrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentLetter {

	public static void main(String[] args) {
		System.out.println("mostFrequentLetter: " + getMostFrequentLetter("babaacccccc")+"\n");

		System.out.println("secondMostFrequentLetter: " + getSecondMostFrequentLetter("babaacccccc")+"\n");
	}

	static String getMostFrequentLetter(String input) {

		Map<Character, Integer> dict = new HashMap<>();

		Character mostFrequentChar = null;
		int mostFrequentCount = 0;

		for (char ch : input.toCharArray()) {

			int count = dict.getOrDefault(ch, 0);
			count++;

			dict.put(ch, count);

			if (count > mostFrequentCount) {
				mostFrequentCount = count;
				mostFrequentChar = ch;
			}
		}
		
		System.out.println("dict: " + dict);

		return mostFrequentChar.toString();
	}

	static String getSecondMostFrequentLetter(String input) {

		Map<Character, Integer> dict = new HashMap<>();

		for (char ch : input.toCharArray()) {

			int count = dict.getOrDefault(ch, 0);
			count++;

			dict.put(ch, count);

		}

		System.out.println("dict: " + dict);

		/**
		 * use list of Map.Entry(s) which Map.Entry is an object
		 */
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(dict.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		System.out.println("list: " + list);

		return list.get(1).getKey().toString();
	}
}
