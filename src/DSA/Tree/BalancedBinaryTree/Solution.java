package DSA.Tree.BalancedBinaryTree;

import DSA.Tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * }
 * 
 * preorder check
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}