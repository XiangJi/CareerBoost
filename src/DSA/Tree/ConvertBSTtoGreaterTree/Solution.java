package DSA.Tree.ConvertBSTtoGreaterTree;

import DSA.Tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    // BST's reverse inorder tranverse is big -> small
    //Definition: add the current value to sum, replace the current value 
    void dfs(TreeNode current) {
        if (current == null) {
            return;
        }
        dfs(current.right);
        sum += current.val;
        current.val = sum;
        dfs(current.left);
        return;
    }
}