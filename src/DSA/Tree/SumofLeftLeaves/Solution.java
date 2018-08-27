package DSA.Tree.SumofLeftLeaves;

import DSA.Tree.TreeNode;

/*
 * preorder, prev, sum, target
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // Clarify the questions, not all the left node, only leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        return sum + leftSum + rightSum;
    }

}