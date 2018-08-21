package DSA.Tree.CountCompleteTreeNodes;

import DSA.Tree.TreeNode;

/*
 * Given a complete binary tree, count the number of nodes
 * BF: DFS/BFS and count
 * Algorithm: math, + recursive
 * postOrder count
 */
public class Solution {
    public int countNodes (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0, rightHeight = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            leftHeight++;
            l = l.left;
        }
        while (r != null) {
            rightHeight++;
            r = r.right;
        }
        if (leftHeight == rightHeight) return (int) Math.pow(2, leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
