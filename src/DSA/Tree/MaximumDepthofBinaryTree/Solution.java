package DSA.Tree.MaximumDepthofBinaryTree;

import DSA.Tree.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        // use DC: two lines of code
    }
}