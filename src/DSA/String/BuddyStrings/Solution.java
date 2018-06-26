package DSA.String.BuddyStrings;
/*
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false

Let's say i is matched if A[i] == B[i], otherwise i is unmatched. A buddy string has almost all matches, because a swap only affects two indices.

If swapping A[i] and A[j] would demonstrate that A and B are buddy strings, then A[i] == B[j] and A[j] == B[i]. That means among the four free variables A[i], A[j], B[i], B[j], there are only two cases: either A[i] == A[j] or not.

 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
}
