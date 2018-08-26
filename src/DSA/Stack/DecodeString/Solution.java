package DSA.Stack.DecodeString;

import java.util.Stack;

/*
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

intuitive stack, LIFO
stack应用实现题


当然需要用stack来辅助运算，我们用两个stack，一个用来保存个数
，一个用来保存字符串，我们遍历输入字符串，
如果遇到数字，我们更新计数变量cnt；
如果遇到左中括号，
我们把当前cnt压入数字栈中，把当前t压入字符串栈中；

如果遇到右中括号时，我们取出数字栈中顶元素，
存入变量k，然后给字符串栈的顶元素循环加上k个t字符串，

然后取出顶元素存入字符串t中；
如果遇到字母，我们直接加入字符串t中即可

res来存临时数组
两个stack
 */
class Solution {
    public String decodeString(String s) {
        String temp = "";
        Stack<Integer> cnt = new Stack<>();
        Stack<String> stack = new Stack<>();
        
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                cnt.push(count);
            } else if (s.charAt(i) == '[') {
                stack.push(temp);
                temp = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(stack.pop()); // use previous base
                int k = cnt.pop();
                while (k > 0) {
                    sb.append(temp);
                    k--;
                }
                temp = sb.toString();
                i++;
            } else {
                temp += s.charAt(i);
                i++;
            }
        }
        return temp;
    }
}