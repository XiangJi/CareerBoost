package DSA.DFS.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        dfs(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] candidates, int remain, int pos, List<Integer> tmp, List<List<Integer>> result) {
        // exist condition
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
         // operations
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i, tmp, result); // not i + 1 because numbers can be reused
            tmp.remove(tmp.size() - 1);
        }
    }
}