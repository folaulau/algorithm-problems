package com.folatech.dictionary.mostfrequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a list of objects, return the most frequent data type of those objects
 */
public class MostFrequentDataType {

	public static void main(String[] args) {
		List<Object> lists = List.of("ac", "Laulau", true, 2, 3.4, 'd', 5, 9.23, List.of(1, 8),
				Map.of("name", "folau", "age", 35, "numbers", List.of(10, 18)));

		System.out.println("lists: " + lists);
		System.out.println("mostFrequentDataType: " + getMostFrequentDataType(lists) + "\n");
	}

	static String getMostFrequentDataType(List<Object> lists) {

		Map<String, Integer> dict = getDataTypeCounts(lists);

		/**
		 * use list of Map.Entry(s) which Map.Entry is an object
		 */
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(dict.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		System.out.println("list: " + list);

		return list.get(0).getKey().toString();
	}

	static Map<String, Integer> getDataTypeCounts(List<Object> lists) {

		Map<String, Integer> dict = new HashMap<>();

		for (Object obj : lists) {
			String typeName = obj.getClass().getTypeName();

			if (typeName.startsWith("java.util.ImmutableCollections$List")) {

				// call getDataTypeCounts again
				Map<String, Integer> dict1 = getDataTypeCounts((List) obj);

				dict = Stream.of(dict, dict1).flatMap(map -> map.entrySet().stream())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> {
							System.out.println("value1: " + value1 + ", value2: " + value2);
							return value1 + value2;
						}));

				continue;
			} else if (typeName.startsWith("java.util.ImmutableCollections$Map")) {

				List<Map.Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>(((Map) obj).entrySet());

				// get a list of the values
				// call getDataTypeCounts again
				Map<String, Integer> dict1 = getDataTypeCounts(
						list.stream().map(ob -> ob.getValue()).collect(Collectors.toList()));

				dict = Stream.of(dict, dict1).flatMap(map -> map.entrySet().stream())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> {
							System.out.println("value1: " + value1 + ", value2: " + value2);
							return value1 + value2;
						}));
				continue;
			}

			int count = dict.getOrDefault(typeName, 0);
			dict.put(typeName, ++count);

			System.out.println("value: " + obj + ", type: " + typeName + ", count: " + count);

		}

		System.out.println("dict: " + dict + "\n");
		return dict;
	}

}
