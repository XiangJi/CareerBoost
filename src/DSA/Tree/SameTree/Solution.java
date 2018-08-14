package DSA.Tree.SameTree;

import DSA.Tree.TreeNode;

/*
 * preorder
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if (p.val == q.val && left && right) {
            return true;
        }
        return false;
    }
}