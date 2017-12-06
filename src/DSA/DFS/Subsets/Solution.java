package DSA.DFS.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * input no dup
 * output no dup
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, list, result);
        return result;
    }

    // dfs template, input, search index,
    private void dfs(int[] nums, int pos, List<Integer> temp, List<List<Integer>> result) {
        // Deep copy the current list
        result.add(new ArrayList<Integer>(temp));

        for (int i = pos; i < nums.length; i++) {
            // [1] -> [1,2]
            temp.add(nums[i]);
            // 寻找所有以 temp 开头的集合，并扔到 results
            dfs(nums, i + 1, temp, result);
            // backtracking
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.subsets(new int[]{1,2,3});
    }
}