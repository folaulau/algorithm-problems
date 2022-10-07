package com.folatech.dictionary.mostfrequent;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentLetter {


  public static void main(String[] args) {
    System.out.println(mostFrequentLetter("babaacccccc"));
  }

  static String mostFrequentLetter(String input) {

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

    return mostFrequentChar.toString();
  }
}
