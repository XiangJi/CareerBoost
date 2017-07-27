package DSA.HashTable.LongestSubstringwithAtMostKDistinctCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Save char and index
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left= 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);

            while(map.size() > k) {
                // Delete the oldest key
                if (map.get(s.charAt(left)) == left) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}