package DSA.Array.NumberofMatchingSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /*
     *  indexing and binary search
     *  acbca
     *  a: 0 4
     *  b: 2
     *  c: 1 3
     */
    // T: S + w * L * log(s) 解法也可以用在issubsequence那题，在two pointer分类里面
    public int numMatchingSubseqII(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) return 0;
        // 初始化count
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), new ArrayList<>());
            }
            map.get(S.charAt(i)).add(i);
        }
        
        int res = 0;
        for (String str : words) {
            if (helper(map, str)) res++;
        }
        
        return res;
    }
    
    private boolean helper(Map<Character, List<Integer>> map, String str) {
        int start = -1;
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch)) return false; // 无法匹配
            List<Integer> list = map.get(ch);
            int i = 0;
            int j = list.size() - 1;
            if (map.get(ch).get(j) <= start) return false; // 如果最后面也匹配不到 直接return false
            // search到合理的最靠前的位置
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (list.get(mid) > start) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            if (map.get(ch).get(j) <= start) {
                return false;
            } 
            start = map.get(ch).get(j);
        }
        
        return true;
    }
}