package DSA.Array.MagicalString;

/*
 * A magical string S consists of only '1' and '2' and obeys the following rules:

The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122……"

If we group the consecutive '1's and '2's in S, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2 2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.

Example 1:
Input: 6
Output: 3
Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.

如果按照连续出现的'1'和'2'分组，则有：

1 22 11 2 1 22 1 22 11 2 11 22 ......
每一个组内的'1'和'2'的出现次数为：

1 2    2 1 1 2 1 2 2 1 2 2 ......
观察可见上述序列是S的一部分。

 */
public class Solution {
    public int magicalString(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        StringBuilder s = new StringBuilder("12");
        int index = 2;
        char c = '2';
        int left = 1;
        
        int end = 1;
        int count = 1;
        while(end < n - 1) {
            if(left == 1) {
                s.append(c);
                if(c == '1') {
                    count++;
                    c = '2';
                }
                else {
                    c = '1';
                }
                left = s.charAt(index++) - '0';
            } else if(left == 2) {
                s.append(c);
                if(c == '1') {
                    count++;
                }
                left--;
            }
            end++;
        }
        
        return count;
    }
}