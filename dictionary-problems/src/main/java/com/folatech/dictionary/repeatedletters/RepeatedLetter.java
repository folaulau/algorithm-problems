package com.folatech.dictionary.repeatedletters;

import java.util.*;

class RepeatedLetter {

    public static void main(String[] args) {

        List<String> phrases = List.of("Today, is the greatest day ever!", "Hello apple pie", "No words");

        for (String phrase : phrases) {
            System.out.println("Phrase: " + phrase);
            String letter = searchForMostRepeatedLetters(phrase);
            System.out.println("First word with the most repeated letter: " + letter);
            System.out.println("");
        }
    }

    /**
     * Searching Challenge
     * <p>
     * Have the function search(str) take the str parameter being passed and return the first word with the greatest
     * number of repeated letters.
     * <p>
     * For example: "Today, is the greatest day ever!" should return greatest because it has 2 e's (and 2 t's) and it
     * comes before ever which also has 2 e's.
     * <p>
     * If there are no words with repeating letters return -1. Words will be separated by spaces.
     * <p>
     * Examples Input: "Hello apple pie" -> Output: Hello Input:"No words" -> Output: -1
     */
    public static String searchForMostRepeatedLetters(String str) {
        String[] words = str.split(" ");
        int maxRepeats = 0;
        String resultWord = "-1";

        for (String word : words) {
            Map<Character, Integer> charCountMap = new HashMap<>();

            // Count the frequency of each character in the word
            for (char c : word.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            // Find the maximum number of repeats for any character in the word
            int maxInWord = charCountMap.values().stream().max(Integer::compare).orElse(0);

            // Update the result if this word has more repeats than the previous ones
            if (maxInWord > maxRepeats) {
                maxRepeats = maxInWord;
                resultWord = word;
            }
        }

        // Check if the result word actually has repeated characters
        return maxRepeats > 1 ? resultWord : "-1";
    }
}
