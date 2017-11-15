package DSA.String.FirstUniqueCharacterinaString;

public class Solution {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}