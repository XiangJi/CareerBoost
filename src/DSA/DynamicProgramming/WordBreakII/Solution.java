package DSA.DynamicProgramming.WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// MEM DP by recursion
/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

 * wordBreak(catsanddog) = wordBreak(catanddo) + inDict(g) .. 所有分割情况的集合 递归找这样的结果
 *N^3
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> dict) {
        // 存string从左边扫的string和它的已有解
        Map<String, List<String>> done = new HashMap<>();
        // 开始没有解
        done.put("", new ArrayList<>());
        done.get("").add("");

        return dfs(s, dict, done);
    }

    private List<String> dfs(String s, List<String> dict, Map<String, List<String>> done) {
        // 退出条件 有了接了 提前return
        if (done.containsKey(s)) {
            return done.get(s);
        }
        List<String> res = new ArrayList<>();

        for (int len = 1; len <= s.length(); len++) {  //将s 分割成s1 s2  其中s1长度为len
            String s1 = s.substring(0, len);
            String s2 = s.substring(len);

            if (dict.contains(s1)) {
                List<String> s2_res = dfs(s2, dict, done);
                for (String item : s2_res) {
                    if (item == "") {
                        res.add(s1); //如果找到的是空的直接就是s1
                    } else {
                        res.add(s1 + " " + item); //别的就加在后面
                    }
                }
            }
        }
        done.put(s, res);
        return res;
    }
}