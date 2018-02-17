package DSA.Tree.SumRoottoLeafNumbers;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    
    private int dfs(TreeNode current, int prev) {
        if (current == null) {
            return 0;
        }
        int sum = current.val + prev * 10;
        if (current.left == null && current.right == null) {
            return sum;
        }
        
        return dfs(current.left, sum) + dfs(current.right, sum);
    }
}