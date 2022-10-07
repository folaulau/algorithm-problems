package com.folatech.array.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Only return positive numbers given a list of numbers
 *
 */
public class OnlyPositiveNumber {

  public static void main(String[] args) {
    System.out.println(onlyPositive(Arrays.asList(1, 2, 3, -5)));
  }

  static List<Integer> onlyPositive(List<Integer> input) {
    return input.stream().filter(num -> num > 0).collect(Collectors.toList());
  }
}
