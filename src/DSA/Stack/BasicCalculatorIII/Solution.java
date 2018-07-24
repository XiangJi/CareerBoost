package DSA.Stack.BasicCalculatorIII;

import java.util.Deque;
import java.util.LinkedList;

// 加减乘除括号都有

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // initialize operator
        char sign = '+';
        Deque<Long> stack1 = new LinkedList<>(); // store digit and '('
        Deque<Character> stack2 = new LinkedList<>(); // store sign before '('
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                i--;
                stack1.offerFirst(eval(sign, stack1, num));
            } else if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                stack1.offerFirst(Long.MAX_VALUE);
                stack2.offerFirst(sign);
                sign = '+';
            } else if (ch == ')') {
                long num = 0;
                while (stack1.peekFirst() != Long.MAX_VALUE) {
                    num += stack1.pollFirst();
                }
                stack1.pollFirst(); // pop out '(' (Long.MAX_VALUE)
                char operator = stack2.pollFirst();
                stack1.offerFirst(eval(operator, stack1, num));
            } else {
                sign = ch;
            }
        }
        // what we need to do is just sum up all num in stack
        int result = 0;
        while (!stack1.isEmpty()) {
            result += stack1.pollFirst();
        }
        return result;
    }
    private long eval(char sign, Deque<Long> stack1, long num) {
        if (sign == '+') {
            return num;
        } else if (sign == '-') {
            return -num;
        } else if (sign == '*') {
            return stack1.pollFirst() * num;
        } else {
            return stack1.pollFirst() / num;
        }
    }
}