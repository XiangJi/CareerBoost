package DSA.String.ImplementstrStr;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        char[] big = haystack.toCharArray();
        char[] small = needle.toCharArray();

        for (int i = 0; i <= big.length
                - small.length; i++) {
            int j;
            for (j = 0; j < small.length; j++) {
                if (big[i + j] != small[j]) {
                    break;
                }

            }
            // after exit, the j will be added 1
            if (j == small.length) {
                return i;
            }
        }
        return -1;
    }

}