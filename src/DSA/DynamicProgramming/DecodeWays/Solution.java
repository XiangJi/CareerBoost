package DSA.DynamicProgramming.DecodeWays;

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