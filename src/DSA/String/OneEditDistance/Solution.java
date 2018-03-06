package DSA.String.OneEditDistance;

/*
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        int diff = t.length() - s.length();

        if (diff > 1) {
            return false;
        }
        if (diff == 0) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    cnt++;
                }
            }
            return (cnt == 1);
        }
        if (diff == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    return (s.substring(i).equals(t.substring(i + 1)));
                }
            }
        }
        return true;
    }
}