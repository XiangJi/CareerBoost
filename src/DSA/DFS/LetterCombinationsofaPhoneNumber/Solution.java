package DSA.DFS.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

枚举实质的一堆for循环，因为不定长 所以递归实现
 */
public class Solution {
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        dfs(digits, new StringBuilder(), result, 0);
        return result;
    }

    private void dfs(String digits, StringBuilder sb,
            List<String> result, int index) {
        
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(index) - '0']; // iterate current possible letters
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, sb, result, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}