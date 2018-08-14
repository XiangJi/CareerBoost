package DSA.DynamicProgramming.DecodeWays;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

输入可以看成一个数组 1D DP

就两种情况
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] ways = new int[s.length() + 1];

        ways[0] = 1;
        ways[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                ways[i] = ways[i - 1];
            }

            int lastTwo = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (lastTwo >= 10 && lastTwo <= 26) {
                ways[i] += ways[i - 2];
            }
        }
        return ways[s.length()];
    }
}