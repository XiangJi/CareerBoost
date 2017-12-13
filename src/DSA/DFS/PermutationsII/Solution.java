package DSA.DFS.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Corner case
        if (nums.length == 0 || nums == null) {
            return result;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return; // exit condition
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue; // avoid duplicate
            used[i] = true;
            list.add(nums[i]);
            dfs(result, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}