package DSA.Stack.LongestValidParentheses;

import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

Instead of finding every possible string and checking its validity, we can make use of stack while scanning the given string to check if the string scanned so far is valid, and also the length of the longest valid string. In order to do so, we start by pushing -1−1 onto the stack.

For every \text{‘(’}‘(’ encountered, we push its index onto the stack.

For every \text{‘)’}‘)’ encountered, we pop the topmost element and subtract the current element's index from the top element of the stack, which gives the length of the currently encountered valid string of parentheses. If while popping the element, the stack becomes empty, we push the current element's index onto the stack. In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.

 */
public class Solution {
    public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                    return 0;
            }
            Stack<Integer> stack = new Stack<Integer>();
    int len = s.length();
    int max = 0, sum = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            if (stack.isEmpty()) {
                sum = 0;
            } else {
                int tmp = i - stack.pop() + 1;
                if (stack.isEmpty()) {
                    sum += tmp;
                    max = Math.max(max, sum);
                } else {
                    tmp = i - stack.peek();
                    max = Math.max(max, tmp);
                }
            }
        }
    }
    return max;
    }
}