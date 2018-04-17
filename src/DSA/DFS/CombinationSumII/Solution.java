package DSA.DFS.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// follow up, but has duplicates, and each number only used once
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
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
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue; // avoid out of bound && skip if same nunmber
            }
            tmp.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}