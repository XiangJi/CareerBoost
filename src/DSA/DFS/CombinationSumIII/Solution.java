package DSA.DFS.CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]


 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int size,int remain, int pos, List<Integer> tmp, List<List<Integer>> result) {
        // exist condition
        if (remain < 0) {
            return;
        }
        if (remain == 0 && tmp.size() == size) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
         // operations
        for (int i = pos; i <= 9; i++) {
            tmp.add(i);
            dfs(size, remain - i, i + 1, tmp, result); // 每个数只能用一次，所以i+1
            tmp.remove(tmp.size() - 1);
        }
    }
}