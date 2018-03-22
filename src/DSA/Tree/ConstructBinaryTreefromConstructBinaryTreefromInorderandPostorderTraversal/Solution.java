package DSA.Tree.ConstructBinaryTreefromConstructBinaryTreefromInorderandPostorderTraversal;

import DSA.Tree.TreeNode;

/*
 * You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    // we need a helper to store index args
    public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        // exsit
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        // find root node
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0; // Index of current root in inorder
        // find it in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // 画图找到搜索位置
        // 多传一个参数
        root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
}
