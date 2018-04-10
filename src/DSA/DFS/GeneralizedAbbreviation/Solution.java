package DSA.DFS.GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", ...


dfs thought sheet
Variables:
pos, pointer to the current character
tmp, current string
count, how many letters are abbreviated in current state

At each recursive call:
Abbreviate the current letter
keep the current and summarize the abbr in tmp

Exit condition:
pos == word.length();
Add the summarized one to the result

2 ^ N branch ^ depth
 */
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, "", word, result);
        return result;
    }

    private void dfs(int count, int pos, String tmp, String word, List<String> result) {
        if (pos == word.length()) {
            if (count > 0) {
                tmp += count;
            }
            result.add(tmp);
            return;
        }

        // two choice, dfs both
        // 1. abbrevaite the current letter
        dfs(count + 1, pos + 1, tmp, word, result);
        // keep the current letter, count to 0
        dfs(0, pos + 1, tmp + (count > 0 ? count : "") + word.charAt(pos), word, result);
    }
}
