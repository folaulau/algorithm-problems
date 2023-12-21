package com.folatech.stack.balanced_brackets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Reference: https://www.algoexpert.io/questions/balanced-brackets
 * 
 * Problem<br>
 * Given an expression string exp, write a program to examine whether the pairs
 * and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given
 * expression.<br>
 * 
 * Source: asked in interview
 */
public class ValidParentheses {

	public static void main(String[] args) {

		List<String> strs = Arrays.asList("{{}}()[()]", "(][)", ")", "([])(){}(())()()", "()[]{}{",
				"(((((({{{{{[[[[[([)])]]]]]}}}}}))))))", "(a)");

		for (String str : strs) {
			boolean valid = containValidParentheses(str);
			System.out.println("str: " + str + " -> valid: " + valid);
			System.out.println("\n");
		}
	}

	/**
	 * Solution<br>
	 * The idea is to put all the open parentheses in the stack. Whenever you hit a
	 * closing bracket, check if the top of the stack is the opening bracket of the
	 * same nature. If this is true then pop the stack and continue the iteration,
	 * in the end if the stack is empty, it means all open parentheses found their
	 * closing parentheses. Otherwise, they are not correct.<br>
	 * 
	 * 
	 * 1. Declare an empty stack.<br>
	 * 2. Push an opening parenthesis on top of the stack.<br>
	 * 3. In case of a closing parenthesis, check if the stack is empty.<br>
	 * 4. If not, pop in a closing parenthesis if the top of the stack contains the
	 * corresponding open parenthesis.<br>
	 * 5. If the parentheses are valid,​ then the stack will be empty once the input
	 * string finishes.<br>
	 * 
	 * Time Complexity: O(N), Iteration over the string of size N one time.<br>
	 * Auxiliary Space: O(N) for stack.
	 *
	 */
	public static boolean containValidParentheses(String str) {
		
//		Set<Character> validCharacters = new HashSet<>();
//		validCharacters.add('(');
//		validCharacters.add(')');
//		validCharacters.add('{');
//		validCharacters.add('}');
//		validCharacters.add('[');
//		validCharacters.add(']');

		/**
		 * Use stack so you can easily check the top for the corresponding open
		 * parentheses once finding a closing parentheses.
		 */
		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {
			
//			if(!validCharacters.contains(ch)) {
//				continue;
//			}

			/**
			 * look for closing, and add all open characters to your stack
			 */
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {

				/**
				 * no opening character to match with closing
				 */
				if (stack.isEmpty()) {
					break;
				}

				/**
				 * Once you find a closing then, peek at the top of the stack to see if you have
				 * the corresponding closing character, if true, pop the stack to remove
				 * character. if false, then you have an invalid pair of parentheses and so
				 * return false
				 */
				char top = stack.peek();

				if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
					stack.pop();
				} else {
					return false;
				}

			}
		}
		
//		System.out.println("stack: "+stack);

		/**
		 * if stack is not empty, which means there might be some open characters
		 * without corresponding closing characters so you have an invalid pair of
		 * parentheses and so return false
		 */

		return stack.isEmpty();
	}

}
