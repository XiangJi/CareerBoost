package DSA.Tree.MinimumAbsoluteDifferenceinBST;

import DSA.Tree.TreeNode;

public class Solution {
    // Brute force: BST's inorder travelis sorted, find the mininal delta, do it
    // during the DC DFS
    int      min  = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        // inorder
        if (root == null) {
            return min;
        }

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        getMinimumDifference(root.right);
        return min;
    }

    // What if it is not a BST? (Follow up of the problem) The idea is to put
    // values in a TreeSet and then every time we can use O(lgN) time to lookup
    // for the nearest values.

    // Solution 2 - Pre-Order traverse, time complexity O(NlgN), space
    // complexity O(N).
    // TODO: learn TreeSet

}