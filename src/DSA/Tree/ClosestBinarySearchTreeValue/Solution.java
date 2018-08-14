package DSA.Tree.ClosestBinarySearchTreeValue;

import DSA.Tree.TreeNode;

//inorder traversal
// both recursive and iterative

class Solution {
    // iterative search in BST
    public int closestValue(TreeNode root, double target) {
        TreeNode current = root;
        int prev = root.val;

        while (current != null) {
            prev = Math.abs(current.val - target) > Math.abs(prev - target) ? prev : current.val;
            current = current.val > target ? current.left : current.right;
        }

        return prev;
    }

    public int closestValueII(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}