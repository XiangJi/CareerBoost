package DSA.BinarySearch.ClosestBinarySearchTreeValue;

import DSA.Tree.TreeNode;

class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode current = root;
        int closest = root.val;
        
        while (current != null) {
            closest = Math.abs(current.val - target) > Math.abs(closest - target) ? closest : current.val;
            current = current.val > target ? current.left : current.right;
        }
        
        return closest;
    }
}