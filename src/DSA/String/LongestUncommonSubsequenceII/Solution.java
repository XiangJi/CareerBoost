package DSA.String.LongestUncommonSubsequenceII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a list of strings, you need to find the longest uncommon subsequence among them. 
 * Sort the strings in the reverse order. If there is not duplicates in the array, then the longest string is the answer.

But if there are duplicates, and if the longest string is not the answer, then we need to check other strings. But the smaller strings can be subsequence of the bigger strings.
For this reason, we need to check if the string is a subsequence of all the strings bigger than itself. If it's not, that is the answer.

 */
public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Set<String> duplicates = getDuplicates(strs);
        for (int i = 0; i < strs.length; i++) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0)
                    return strs[0].length();
                for (int j = 0; j < i; j++) {
                    if (isSubsequence(strs[j], strs[i]))
                        break;
                    if (j == i - 1)
                        return strs[i].length();
                }
            }
        }
        return -1;
    }

    public boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j))
                j++;
            i++;
        }
        return j == b.length();
    }

    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();
        for (String s : strs) {
            if (set.contains(s))
                duplicates.add(s);
            set.add(s);
        }
        return duplicates;
    }
}
