package DSA.String.RomantoInteger;

public class Solution {
    /*
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int result = toNum(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (toNum(s.charAt(i + 1)) > toNum(s.charAt(i))) {
                result -= toNum(s.charAt(i));
            } else {
                result += toNum(s.charAt(i));
            }
        }
        return result;
    }
    
    private int toNum(char c) {
        int ans = 0;;
        switch (c) {
            case 'I':
                ans = 1;
                break;
            case 'V':
                ans = 5;
                break;
            case 'X':
                ans = 10;
                break;
            case 'L':
                ans = 50;
                break;
            case 'C':
                ans = 100;
                break;
            case 'D':
                ans = 500;
                break;
            case 'M':
                ans = 1000;
                break;
        }
        return ans;
    }
}