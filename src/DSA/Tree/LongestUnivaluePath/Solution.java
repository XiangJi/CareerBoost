package DSA.Tree.LongestUnivaluePath;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2


 */
public class Solution {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        pathLength(root);
        return res;
    }

    // find the one side max univalue path
    public int pathLength(TreeNode current) {
        if (current == null) {
            return 0;
        }
        // DC
        int left = pathLength(current.left);
        int right = pathLength(current.right);
        int l = 0;
        int r = 0;
        if (current.left != null && current.left.val == current.val) {
            l = left + 1;
        }
        if (current.right != null && current.val == current.right.val) {
            r = right + 1;
        }
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
