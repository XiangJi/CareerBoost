package DSA.TwoPointers.ValidPalindromeII;

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                //psedo delete
                if (isValid(s, l + 1, r) || isValid(s, l, r - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(String s, int l, int r) {
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}