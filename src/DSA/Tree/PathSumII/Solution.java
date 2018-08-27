package DSA.Tree.PathSumII;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

backtracking dfs
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), sum, root);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int sum, TreeNode current) {
        // exit condition
        if (current == null) {
            return;
        }

        if (current.left == null && current.right == null && sum == current.val) {
            path.add(current.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);// don't forget to remove the last
                                         // integer
            return; // check return
        }

        // backtracking add operation
        path.add(current.val);
        // dfs recursion
        dfs(result, path, sum - current.val, current.left);
        dfs(result, path, sum - current.val, current.right);
        // backtracking remove operation
        path.remove(path.size() - 1);
    }
}