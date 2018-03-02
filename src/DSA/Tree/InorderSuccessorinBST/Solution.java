package DSA.Tree.InorderSuccessorinBST;

import DSA.Tree.TreeNode;

// draw graph, divide and conquer

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null ? left : root);
        }
    }
    
    // iterative solution
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;
            }
        }
        return result;
    }
    
    
}