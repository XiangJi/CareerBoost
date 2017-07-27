package DSA.HashTable.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

// Brute force, double loop
// 用哈希表存字符和index 保证不重复
// i j双指针, j 要和i重复位置 + 1比较， 画图可以理解， 因为j的位置不能为重复位置
// 每次放
// 更新max
public class Solution {
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
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}