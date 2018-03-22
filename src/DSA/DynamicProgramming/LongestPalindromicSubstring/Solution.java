package DSA.DynamicProgramming.LongestPalindromicSubstring;

/*
 * Given a string s, find the longest palindromic substring in s.
 *  You may assume that the maximum length of s is 1000.
 * 
 * BF: O(N^3)
 * DP O(N^2)
 * 中心扩散法expand around center T: N^2 S:1
 * Manacher's algorithm o(N)
 */
public class Solution {
    /*
     * DP: To improve over the brute force solution, we first observe how we can
     * avoid unnecessary re-computation while validating palindromes. Consider the
     * case \textrm{''ababa''}”ababa”. If we already knew that \textrm{''bab''}”bab”
     * is a palindrome, it is obvious that \textrm{''ababa''}”ababa” must be a
     * palindrome since the two left and right end letters are the same.
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1] ); // corner case in front
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    result = s.substring(i, j + 1); // substring index think carefully
                }
            }
        }
        return result;
    }
    
    // implementation: expand from center
    public String longestPalindromeII(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
