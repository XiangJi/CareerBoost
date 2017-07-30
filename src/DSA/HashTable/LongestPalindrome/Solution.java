package DSA.HashTable.LongestPalindrome;

import java.util.HashSet;

// ��һ��countͳ��pairs�������û�м�����ʣ�� �ͼ�һ
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> map = new HashSet<Character>();
        int pairCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.contains(s.charAt(i))) {
                map.add(s.charAt(i));
            } else {
                map.remove(s.charAt(i));
                pairCount++;
            }
        }
        int odd = 0;
        if (!map.isEmpty()) {
            odd = 1;
        }
        return 2 * pairCount + odd;
    }
}