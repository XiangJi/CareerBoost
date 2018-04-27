package DSA.Array.NumberofMatchingSubsequences;

import java.util.ArrayList;

/*
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].

BF
 */
public class Solution {
    // O((S+L) * W)
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (isSubseqence(S, word)) {
                result++;
            }
        }
        return result;
    }

    private boolean isSubseqence(String S, String word) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }
    // indexing and binary search
    /*
     * We can put words into buckets by starting character. If for example we have words = ['dog', 'cat', 'cop'], then we can group them 'c' : ('cat', 'cop'), 'd' : ('dog',). This groups words by what letter they are currently waiting for. Then, while iterating through letters of S, we will move our words through different buckets.

For example, if we have a string like S = 'dcaog':

heads = 'c' : ('cat', 'cop'), 'd' : ('dog',) at beginning;
heads = 'c' : ('cat', 'cop'), 'o' : ('og',) after S[0] = 'd';
heads = 'a' : ('at',), 'o' : ('og', 'op') after S[0] = 'c';
heads = 'o' : ('og', 'op'), 't': ('t',) after S[0] = 'a';
heads = 'g' : ('g',), 'p': ('p',), 't': ('t',) after S[0] = 'o';
heads = 'p': ('p',), 't': ('t',) after S[0] = 'g';
Algorithm

Instead of a dictionary, we'll use an array heads of length 26, one entry for each letter of the alphabet. For each letter in S, we'll take all the words waiting for that letter, and have them wait for the next letter in that word. If we use the last letter of some word, it adds 1 to the answer.

     */
    public int numMatchingSubseqII(String S, String[] words) {
        int matchedWords = 0;
        ArrayList<Node>[] hash = new ArrayList[26];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = new ArrayList<Node>();
        }
        for (String word : words) {
            char headCh = word.charAt(0);
            hash[headCh - 'a'].add(new Node(word, 0));
        }
        for (char ch : S.toCharArray()) {
            ArrayList<Node> tmpList = hash[ch - 'a'];   // need to assign new list before alter the old FOR we can't update during iteration
            hash[ch - 'a'] = new ArrayList<>();
            for (Node node : tmpList) {
                node.idx++;
                if (node.idx == node.word.length()) {
                    matchedWords++;
                }
                else {
                    hash[node.word.charAt(node.idx) - 'a'].add(node);
                }
            }
            tmpList.clear();
        }
        return matchedWords;
    }

    class Node {
        String word;
        int idx;
        public Node(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }
}