package com.folatech.recursion.productsum;

import java.util.List;

/**
 * Problem:<br>
 * 
 * Write a function that takes in a "special" array and returns its product sum.
 * <br>
 * A "special" array is a non-empty array that contains either integers or other
 * "special" arrays. The product sum of a "special" array is the sum of its
 * elements, where "special" arrays inside it are summed themselves and then
 * multiplied by their level of depth. <br>
 * The depth of a "special" array is how far nested it is. For instance, the
 * depth of [] is 1; the depth of the inner array in [[]] is 2; the depth of the
 * innermost array in [[[]]] is 3. <br>
 * 
 * Therefore, the product sum of [x, y] is x + y; the product sum of [x, [y, z]]
 * is x + 2 * (y + z); the product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
 * 
 * <br>
 * Sample Input <br>
 * 
 * 
 * array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]] <br>
 * Sample Output
 * 
 * calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)
 */
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
