package DSA.SlidingWindow.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Brute force, double loop
// 用哈希表存字符和index 保证不重复
// i j双指针, j 要和i重复位置 + 1比较， 画图可以理解， 因为j的位置不能为重复位置，j是第一个不重复的位置
// sliding window concept
// 每次放
// 更新max
public class Solution {

    /*
     * We use HashSet to store the characters in current window [i, j)[i,j) (j =
     * ij=i initially). Then we slide the index jj to the right. If it is not in
     * the HashSet, we slide jj further. Doing so until s[j] is already in the
     * HashSet. At this point, we found the maximum size of substrings without
     * duplicate characters start with index ii. If we do this for all ii, we
     * get our answer.
     */
    public int lengthOfLongestSubstringII(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1); // 数数，坐差之后加一
        }

        return max;
    }
}