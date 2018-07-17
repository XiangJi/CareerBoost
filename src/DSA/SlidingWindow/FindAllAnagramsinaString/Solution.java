package DSA.SlidingWindow.FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */

    // brute force, get all the substring with length p, then compare each pair, store the value N ^ 2
    
   
    //用sliding window更新hashtable再比较两个map是不是一样 O（N）
    // optimize 2: use sliding window and absValue to check if two map is the equal to each other, sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = p.length();
        if (s.length() < p.length()) {
            return res;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < l; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i >= l) {
                sCount[s.charAt(i - l) -'a']--;
            }
            sCount[s.charAt(i) -'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - l + 1);
            }
        }
        return res;
    }
    
    public static List<Integer> findAnagramsII(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {
            if (end - start == p.length() && chars[s.charAt(start++) - 'a'] >= 0) {
                count++;
            }
            if (--chars[s.charAt(end++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) res.add(start);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution test = new Solution();
        String s = "cbaebabacd", p = "abc";
        System.out.println(test.findAnagrams(s, p));
    }
}