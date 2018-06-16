package DSA.Tree.ConvertSortedArraytoBinarySearchTree;

import DSA.Tree.TreeNode;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


T:O (n)
S: O(n)
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        return buildTree(A, 0, A.length - 1);
    }
    // 用头尾index来构建数
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num, start, mid - 1);
        node.right = buildTree(num, mid + 1, end);
        return node;
    }

}
