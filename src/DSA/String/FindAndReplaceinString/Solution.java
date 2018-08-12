package DSA.String.FindAndReplaceinString;

import java.util.Arrays;

/*
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
"ec" doesn't starts at index 2 in the original S, so we do nothing.

String code的题目 注意用match in arr的 trick
 */
public class Solution {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int N = s.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; i++) {
            int ix = indexes[i];
            if (s.startsWith(sources[i], ix)) {
                match[ix] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0; // the pointer in the original string
        while (i < N) {
            if (match[i] >= 0) {
                // replace
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();

            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();

    }
}