package DSA.Stack.EvaluateReversePolishNotation;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

  标准用stack的题，实现细节 注意string to int method: Integer.parseInt()
  String 是对象 比较用equals
  G tag 很好记忆


  当我们需要的是一个基本类型* int *的时候我们需要使用Integer.parseInt()函数
当我们需要的是一个Integer对象类的时候我们就是用Integer.valueOf()函数

 */

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}