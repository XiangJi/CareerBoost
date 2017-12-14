package DSA.TwoPointers.ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        // corner case
        if (s.length() == 0 || s == null) {
                return true;
        }

        char[] array = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for ( char c : array) {
                if (('a' <= c) && (c <= 'z')) {
                        sb.append(c);
                }
                if (('0' <= c) && (c <= '9')) {
                        sb.append(c);
                }
        }
        String result = sb.toString();
        int start = 0;
        int end = result.length() - 1;
        while (start < end) {
                if (result.charAt(start) != result.charAt(end)) {
                        return false;
                }
                start++;
                end--;
        }
        return true;
    }

    // simple one
    public boolean isPalindromeII(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}