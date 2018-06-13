package DSA.DFS.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

T: O(n!) 卡特兰数   --- O（2^N)

 */
public class Solution {
    public List<String> generateParenthesis(int num) {
        List<String> result = new ArrayList<String>();
        if (num <= 0) {
            return result;
        }
        helper(num, num, "", result);
        return result;
    }

    private void helper(int left, int right, String current, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > 0) {
            helper(left - 1, right, current + "(", result);
        }

        if (right > 0 && left < right) { // left < right condition guarantee valid, bravo!
            helper(left, right - 1, current + ")", result);
        }
    }
}
