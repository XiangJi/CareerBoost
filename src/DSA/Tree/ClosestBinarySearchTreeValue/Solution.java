package DSA.Tree.ClosestBinarySearchTreeValue;

import DSA.Tree.TreeNode;

class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode current = root;
        int prev = root.val;
        
        while (current != null) {
            prev = Math.abs(current.val - target) > Math.abs(prev - target) ? prev : current.val;
            current = current.val > target ? current.left : current.right;
        }
        
        return prev;
    }
}