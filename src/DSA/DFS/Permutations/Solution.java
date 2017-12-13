package DSA.DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
        //exit condition
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list)); //be carefull, deep copy here!
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
        list.add(nums[i]);
        dfs(result, list, nums);
        list.remove(list.size() - 1);
        }

    }

    // recursive test, use print instead of debugger
    // variables i, temp, list,
    /*
     * current index:0 [1] current index:0 current index:1 [1, 2] current
     * index:0 current index:1 current index:2 [1, 2, 3] [[1, 2, 3]] [1, 2] [1]
     * current index:2 [1, 3] current index:0 current index:1 [1, 3, 2] [[1, 2,
     * 3], [1, 3, 2]] [1, 3] current index:2 [1] [] current index:1 [2] current
     * index:0 [2, 1] current index:0 current index:1 current index:2 [2, 1, 3]
     * [[1, 2, 3], [1, 3, 2], [2, 1, 3]] [2, 1] [2] current index:1 current
     * index:2 [2, 3] current index:0 [2, 3, 1] [[1, 2, 3], [1, 3, 2], [2, 1,
     * 3], [2, 3, 1]] [2, 3] current index:1 current index:2 [2] [] current
     * index:2 [3] current index:0 [3, 1] current index:0 current index:1 [3, 1,
     * 2] [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2]] [3, 1] current
     * index:2 [3] current index:1 [3, 2] current index:0 [3, 2, 1] [[1, 2, 3],
     * [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]] [3, 2] current
     * index:1 current index:2 [3] current index:2 []
     */
    public static void main(String[] args) {
        new Solution().permute(new int[] { 1, 2, 3 });
    }
}
