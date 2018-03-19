package DSA.Tree.ValidateBinarySearchTree;

import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class Solution {

    // in-order traverse
    private Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }

        // inorder traverse
        if (prev != null && prev >= root.val) {
            return false;
        }
        prev = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;

    }

    // just use the conditions we have
    public boolean isValidBSTII(TreeNode root) {
        if(root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        if(min != null && node.val <= min) return false;
        if(max != null && node.val >= max) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    // use stack to in-order traverse
    public boolean isValidBSTIII(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
           while (root != null) {
              stack.push(root);
              root = root.left;
           }
           root = stack.pop();
           if(pre != null && root.val <= pre.val) return false;
           pre = root;
           root = root.right;
        }
        return true;
     }

}