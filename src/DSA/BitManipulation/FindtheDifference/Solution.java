package DSA.BitManipulation.FindtheDifference;

/*
 * Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.

brute force: hash map
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            diff ^= t.charAt(j);
        }
        return (char) diff;
    }
}