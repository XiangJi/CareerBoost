package DSA.SlidingWindow.MinimumWindowSubstring;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

Sliding window的实现比较麻烦，细节比较难，比较难在面试的时候debug

time : O(n)
     space : O(1)
     
     Variables：
     
 */
class Solution {
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        // 统计T里面每个出现了多少次 ABC
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0; // the slow pointer
        int total = t.length(); //需要match的数量
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            // 满足了 开始缩小windows
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++; // 不满足了 i再开始向前
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
