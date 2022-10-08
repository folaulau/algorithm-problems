package com.folatech.recursion.productsum;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductSum {

	public static void main(String[] args) {

		List list = List.of(1, 2, 3, List.of(2, -8), 5, List.of(1, 2, List.of(3, 8)));

		System.out.println("list: " + list + "\n");

		int productSum = getProductSum(list, 1);

		System.out.println("\nproductSum: " + productSum);
	}

	static int getProductSum(List<Object> objs, int depth) {
		int productSum = 0;
		for (Object obj : objs) {
			String typeName = obj.getClass().getTypeName();

			System.out.println("typeName: " + typeName);

			if (typeName.startsWith("java.util.ImmutableCollections$List")
					|| typeName.startsWith("java.util.ArrayList")) {

				// call getDataTypeCounts again
				productSum += getProductSum((List) obj, (depth + 1));

				continue;
			}

			productSum += Integer.valueOf(obj.toString());

		}

		productSum *= depth;

		System.out.println("list: " + objs + ", depth: " + depth + ", productSum: " + productSum);

		return productSum;
	}
}
