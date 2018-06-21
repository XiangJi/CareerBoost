package DSA.Tree.BinaryTreeLongestConsecutiveSequence;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the
tree along the parent-child connections.
 The longest consecutive path need to be from parent to child
 (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

O(N)

 */
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, root.val);
        return max;
    }
    // variable tmp, next target
    public void dfs(TreeNode current, int tmp, int target) {
        if (current == null) {
            return;
        }
        if (current.val == target) {
            tmp++;
        } else {
            tmp = 1;
        }
        max = Math.max(max, tmp);
        dfs(current.left, tmp, current.val + 1);
        dfs(current.right, tmp, current.val + 1);
    }
}