package DSA.Tree.BinaryTreeLongestConsecutiveSequenceII;

import DSA.Tree.TreeNode;

/*
 * 那道题只让从父结点到子结点这种顺序来找最长连续序列，而这道题没有这个顺序限制，我
 * 们可以任意的拐弯，这样能找到最长的递增或者递减的路径。
 * 当然是从叶结点算起，这样才方便往根结点回溯。当某个结点比其父结点值大1的话，
 * 说明这条路径是递增的，那么当我们知道其左右子结点各自的递增路径长度，那么当前结点的递增路径
 * 长度就是左右子结点递增路径长度中的较大值加上1，同理如果是递减路径，那么当前结点的递减路径长度就是左右子
 * 结点递减路径长度中的较大值加上1，通过这种方式我们可以更新每个结点的递增递减路径长度。在回溯的过程中，
 * 一旦我们知道了某个结点的左右子结点的最长递增递减路径长度，那么我们可以算出当前结点的最长连续序列的长度，
 * 要么是左子结点的递增路径跟右子结点的递减路径之和加1，要么事左子结点的递减路径跟右子结点的递增路径之和加1，二者中取较大值即可
 */
public class Solution {
    int maxval = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }

    public int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] { inr, dcr };
    }
}