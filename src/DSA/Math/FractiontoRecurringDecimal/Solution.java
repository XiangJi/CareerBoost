package DSA.Math.FractiontoRecurringDecimal;

import java.util.HashMap;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".

循环十进制
细心实现题,很有可能出现
1. + - 0 overflow case
2. 整数
3. 小数

 */
public class Solution {
    public String fractionToDecimal(int a, int b) {
        if (a == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append((a > 0) ^ (b > 0) ? "-" : ""); // only true + false = false

        // avoid overflow
        long num = Math.abs((long) a);
        long den = Math.abs((long) b);

        result.append(num / den);
        num %= den;
        if (num == 0) {
            return result.toString();
        }
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());

        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;
            // detect cycle
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }
}