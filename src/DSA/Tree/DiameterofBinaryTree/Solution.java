package DSA.Tree.DiameterofBinaryTree;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. T
 * he diameter of a binary tree is the length of the longest path between any two nodes
 *  in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

preorder 简单
 */
public class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        longestPath(root);
        return res;
    }
    // return the max depth of one node
    public int longestPath(TreeNode current) {
        if (current == null) {
            return 0;
        }
        int left = longestPath(current.left);
        int right = longestPath(current.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}


