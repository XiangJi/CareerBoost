package DSA.String.ReverseStringII.RepeatedStringMatch;

/*
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.indexOf(B) == -1) {
            //if prev sb is larger than B, but still not there, no more check
            if (sb.length() >  B.length() + A.length()) {
                return -1;
            }
            sb.append(A);
            count++;
        }
        return count;
    }
}