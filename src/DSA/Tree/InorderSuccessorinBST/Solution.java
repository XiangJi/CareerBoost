package DSA.Tree.InorderSuccessorinBST;

import DSA.Tree.TreeNode;

// draw graph, divide and conquer

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val > p.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;

        } else {
            return inorderSuccessor(root.right, p);
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