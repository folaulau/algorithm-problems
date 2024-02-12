package com.folatech.stack.string_compression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Decompress a compressed string.
 *
 * Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa
 * 
 * One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
 * 
 * Characters allowed as input include digits, small English letters and brackets [ ].
 * 
 * Digits are only to represent amount of repetitions.
 * 
 * Letters are just letters.
 * 
 * Brackets are only part of syntax of writing repeated substring.
 * 
 * Input is always valid, so no need to check its validity.
 */
public class StringCompression {

    public static void main(String[] args) {

        Map<String, String> compressed = new HashMap<>();
        compressed.put("3[a]", "aaa");
        compressed.put("2[aa]3[b]", "aaaabbb");
        compressed.put("10[a]", "aaaaaaaaaa");
        compressed.put("3[abc]4[ab]c", "abcabcabcababababc");
        compressed.put("2[3[a]b]", "aaabaaab");

        for (Map.Entry<String, String> entry : compressed.entrySet()) {
            String result = decompress(entry.getKey());

            // Assert.assertEquals(entry.getValue(), result);

            System.out.println("Result: " + result + "  Expected: " + entry.getValue() + "\n");
        }
    }

    public static String decompress(String compressed) {

        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        resultStack.push(new StringBuilder());

        int index = 0;

        while (index < compressed.length()) {
            char current = compressed.charAt(index);

            if (Character.isDigit(current)) {
                int start = index;
                while (Character.isDigit(compressed.charAt(index + 1))) {
                    index++;
                }
                counts.push(Integer.parseInt(compressed.substring(start, index + 1)));

            } else if (current == '[') {
                resultStack.push(new StringBuilder());

            } else if (current == ']') {
                StringBuilder temp = resultStack.pop();
                StringBuilder decodedString = new StringBuilder();
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    decodedString.append(temp);
                }
                resultStack.peek().append(decodedString);

            } else {
                resultStack.peek().append(current);

            }

            index++;
        }

        return resultStack.pop().toString();
    }
}
