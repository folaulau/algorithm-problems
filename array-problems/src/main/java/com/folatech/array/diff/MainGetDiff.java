package com.folatech.array.diff;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainGetDiff {


  public static void main(String[] args) {
    System.out.println(listDiff(Arrays.asList(1, 1, 2, 3, 4), Arrays.asList(2, 5, 6, 1)));
  }

  /**
   * write function that takes in two lists of integers and returns a new list containing only the
   * unique values from the first list
   */
  static List<Integer> listDiff(List<Integer> a, List<Integer> b) {
    return a.stream()
        // strip out duplicates from a
        .distinct()
        // filter elements from a that are not in b
        .filter(element -> !b.contains(element)).collect(Collectors.toList());
  }
}
