package DSA.String.ExpressiveWords;
/*
 * Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.

Given a list of query words, return the number of words that are stretchy

当一个字母连续的个数小于3的时候可以扩展成3个或者3个以上连续的这个字母,例如aa可以扩展aaa或者aaaa。最后返回list中有多少个单词可以扩展成与S一样.

Loop through all words. check(string S, string W) checks if W is stretchy to S.

In check function, use two pointer:

If S[i] == W[j, i++, j++
If S[i - 2] == S[i - 1] == S[i] or S[i - 1] == S[i] == S[i + 1], i++
return false


 */
public class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String W : words) if (check(S, W)) res++;
        return res;
    }
    public boolean check(String S, String W) {
        int n = S.length(), m = W.length(), j = 0;
        for (int i = 0; i < n; i++)
            if (j < m && S.charAt(i) == W.charAt(j)) j++;
            else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2));
            else if (0 < i && i < n - 1 && S.charAt(i - 1) == S.charAt(i) && S.charAt(i) == S.charAt(i + 1));
            else return false;
        return j == m;
    }
}
