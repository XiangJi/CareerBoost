package DSA.Tree.SumofLeftLeaves;

import DSA.Tree.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // Clarify the questions, not all the left node, only leaf node
        //DC int, the left sum of left/right tree
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        return sum + leftSum + rightSum;
    }

    //TODO learn how to convert DC DFS into iterative implementation using stack
}