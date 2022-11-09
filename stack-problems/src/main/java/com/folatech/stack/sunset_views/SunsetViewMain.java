package com.folatech.stack.sunset_views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given an array of buildings and a direction that all of the buildings face,
 * return an array of the indices of the buildings that can see the sunset.
 * 
 * 
 * A building can see the sunset if it's strictly taller than all of the
 * buildings that come after it in the direction that it faces.
 * 
 * 
 * The input array named buildings contains positive, non-zero integers
 * representing the heights of the buildings. A building at index i thus has a
 * height denoted by buildings[i] . All of the buildings face the same
 * direction, and this direction is either east or west, denoted by the input
 * string named direction , which will always be equal to either EAST or WEST
 * 
 * . In relation to the input array, you can interpret these directions as right
 * for east and left for west.
 * 
 * 
 * Important note: the indices in the ouput array should be sorted in ascending
 * order.
 * 
 * Also direction is where the sun is set. In this example sun can be set either
 * to the EAST or WEST
 * 
 * Sample input = [3, 5, 4, 4, 3, 1, 3, 2], Direction = EAST
 * 
 * Sample output: Sample Output #1 [1, 3, 6, 7]
 * 
 */
public class SunsetViewMain {

	public static void main(String[] args) {
		int[] buildings = new int[] { 3, 5, 4, 4, 3, 1, 3, 2 };
		String direction = "EAST";

		System.out.println("buildings: " + Arrays.toString(buildings) + ", direction: " + direction);

//		List<Integer> tallBuildings = getSunsetViewsWithList(buildings, direction);
//
//		System.out.println("tallBuildings: " + tallBuildings);
//
//		buildings = new int[] { 3, 5, 4, 4, 3, 1, 3, 2 };
//		direction = "WEST";
//
//		System.out.println("buildings: " + Arrays.toString(buildings) + ", direction: " + direction);
//
//		tallBuildings = getSunsetViewsWithList(buildings, direction);
//
//		System.out.println("tallBuildings: " + tallBuildings);

		List<Integer> tallBuildings = getSunsetViewsWithStack(buildings, direction);

		System.out.println("tallBuildings: " + tallBuildings);

		buildings = new int[] { 3, 5, 4, 4, 3, 1, 3, 2, 9 };
		direction = "WEST";

		System.out.println("buildings: " + Arrays.toString(buildings) + ", direction: " + direction);

		tallBuildings = getSunsetViewsWithStack(buildings, direction);

		System.out.println("tallBuildings: " + tallBuildings);
	}

	/**
	 * Solution
	 * 
	 * Start iteration from where the building is facing. if direction is west,
	 * start from beginning else start from the end
	 * 
	 * 
	 * Use a max height tracker
	 * 
	 * O(n) time, 0(n) space
	 * 
	 */
	static List<Integer> getSunsetViewsWithList(int[] buildings, String direction) {
		// Write your code here.
		List<Integer> tallIndices = new ArrayList<Integer>();

		if (direction.equals("EAST")) {

			int viewableHeight = 0;

			int length = (buildings.length - 1);
			for (int i = length; i >= 0; i--) {
				int buildingHeight = buildings[i];
				System.out.println("i: " + i + ", buildingHeight: " + buildingHeight);

				if (i == length) {
					tallIndices.add(i);
					viewableHeight = buildingHeight;
					continue;
				}
				System.out.println("buildingHeight: " + buildingHeight + ", viewableHeight: " + viewableHeight);
				if (buildingHeight > viewableHeight) {
					tallIndices.add(i);
					viewableHeight = buildingHeight;
				}

			}
		} else {// WEST

			int viewableHeight = 0;

			int length = (buildings.length);
			for (int i = 0; i < length; i++) {
				int buildingHeight = buildings[i];

				if (i == 0) {
					tallIndices.add(i);
					viewableHeight = buildingHeight;
					continue;
				}
				if (buildingHeight > viewableHeight) {
					tallIndices.add(i);
					viewableHeight = buildingHeight;
				}

			}
		}

		tallIndices.sort(Comparator.comparingInt(a -> a));
		System.out.println("tallIndices: " + tallIndices);
		return tallIndices;
	}

	/**
	 * Solution
	 * 
	 * Use a stack which the max height tracker is the top item on the stack
	 * 
	 * O(n) time, 0(n) space
	 * 
	 */
	static List<Integer> getSunsetViewsWithStack(int[] buildings, String direction) {
		// Write your code here.
		Stack<Integer> tallIndices = new Stack<Integer>();

		if (direction.equals("EAST")) {
			int length = (buildings.length);
			for (int i = 0; i < length; i++) {
				int buildingHeight = buildings[i];

				if (tallIndices.isEmpty()) {
					tallIndices.add(i);
				} else {

					int backBuildingHeight = buildings[tallIndices.peek()];
					System.out.println(
							"buildingHeight: " + buildingHeight + ", backBuildingHeight: " + backBuildingHeight);
					if (buildingHeight >= backBuildingHeight) {
						while (buildingHeight >= backBuildingHeight) {

							System.out.println("\npoping index: " + tallIndices.peek() + ", backBuildingHeight: "
									+ backBuildingHeight + ", buildingHeight: " + buildingHeight + "\n");
							tallIndices.pop();

							if (tallIndices.isEmpty()) {
								break;
							}

							backBuildingHeight = buildings[tallIndices.peek()];
						}
					}
					tallIndices.add(i);

				}

			}

		} else {// WEST
			int length = (buildings.length);
			for (int i = 0; i < length; i++) {
				int buildingHeight = buildings[i];

				if (tallIndices.isEmpty()) {
					tallIndices.add(i);
				} else {

					int frontBuildingHeight = buildings[tallIndices.peek()];
					System.out.println(
							"buildingHeight: " + buildingHeight + ", frontBuildingHeight: " + frontBuildingHeight);
					if (buildingHeight <= frontBuildingHeight) {
						System.out.println("\ndont push to stack\n");
						continue;
					}
					tallIndices.add(i);

				}

			}
		}

		return new ArrayList<>(tallIndices);
	}

}
