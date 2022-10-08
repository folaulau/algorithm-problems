package com.folatech.recursion.rulecombination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Get combination of rules with unknown or unlimited size of list of strings
 */
public class RuleCombinations {

	public static void main(String[] args) {
		List<List<String>> lists = List.of(List.of("a", "b", "c"), List.of("+", "-", "*", "/"), List.of("1", "2", "3"));

		System.out.println("lists: " + lists);
		System.out.println("combos: " + getCombos(lists) + "\n");
	}

	static List<String> getCombos(List<List<String>> objs) {

		List<String> combos = new ArrayList<>();

		List<String> list1 = objs.get(0);
		List<String> list2 = objs.get(1);
		List<String> list3 = objs.get(2);

		for (String str1 : list1) {
			for (String str2 : list2) {
				for (String str3 : list3) {
					System.out.println("com: " + (str1.concat(str2).concat(str3)));
				}
			}
		}

		for (int i = 0; i < objs.size(); i++) {

		}

		return combos;
	}

//	static List<String> getCombos(List<Object> objs) {
//
//		List<String> combos = new ArrayList<>();
//
//		List<String> list1 = (List<String>) objs.get(0);
//		List<String> list2 = (List<String>) objs.get(1);
//		List<String> list3 = (List<String>) objs.get(2);
//		// if size is known
//		for (String str1 : list1) {
//			for (String str2 : list2) {
//				for (String str3 : list3) {
//					System.out.println("str3: " + (str1.concat(str2).concat(str3)));
//				}
//			}
//		}
//
//		for (int i = 0; i < objs.size(); i++) {
//
//		}
//
//		return combos;
//	}

}
