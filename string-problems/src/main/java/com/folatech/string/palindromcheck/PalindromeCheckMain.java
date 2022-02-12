package com.folatech.string.palindromcheck;

public class PalindromeCheckMain {

    /**
     * Difficulty level: easy
     */
    public static void main(String[] args) {

        String str = "abcdcba";

        boolean palindrome = isPalindrome(str);

        System.out.println("str: " + str + ", palindrome: " + palindrome);
    }

    static boolean isPalindrome(String str) {

        for (int i = 0, x = str.length() - 1; i < str.length() / 2; i++, x--) {
            if (str.charAt(x) != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
