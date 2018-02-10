package DSA.Tree.BinaryTreeUpsideDown;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5

 */
public class Solution {
    // use DFS recursive flip
    // 先递归 再翻转 否则ceo要插手左总监了
    // oN 所有元素访问一遍
    TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return newRoot;
    }
    
    private void dfs(TreeNode current) {
        if (current.left == null) {
            newRoot = current;
            return;
        }
        //recursion
        dfs(current.left);
        // real operation
        current.left.left = current.right;
        current.left.right = current;
        // break old link
        current.left = null;
        current.right = null;
    }
}
