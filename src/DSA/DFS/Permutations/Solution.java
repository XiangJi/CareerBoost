package DSA.DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 0, nums, new int[nums.length]);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int index, int[] nums, int[] used) {
        if ( index == nums.length ) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            tmp.add(nums[i]);
            dfs(res, tmp, index + 1, nums,used); // permutation used boolean array, here is index + 1, not i + 1
            used[i] = 0;
            tmp.remove(tmp.size() - 1);
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
