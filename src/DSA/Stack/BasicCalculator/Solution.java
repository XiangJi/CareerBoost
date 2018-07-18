package DSA.Stack.BasicCalculator;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

应用场景 任何语言compiler都需要处理这个表达式，用stack
        1 - (2 + (3 -4)) - 5
level:  0     1     2    0
1. 如果没有括号 就直接扫过去做
2. 设定parethsis level， 保存用stack， 不是顺序访问 用stack, 运算从stack top到stack bottom

operator stack: -,0  + 1  - 2, 要比较优先级  ，遇见） 同一层全部pop掉
operand stack : 往里面插 如果operand pop了就拿出两个然后 算出然后插入回去

帅帅帅
Expression: An expression is a string whose value is to be calculated. Every expression must be alternating between operands and operators.

对每一个不同的token类型做不同的处理

Use stack to implement 实现题 G


 */
public class Solution {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int result = 0;
        int number = 0; // 关键遍历
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + c - '0';
            } else if (c == '+') {

            } else if (c == '-') {

            } else if (c == '(') {

            } else if (c == ')') {


            }
        }
        // before return, do the rest of the calculation
        if (number != 0)
            result += sign * number;
        return result;
    }

}