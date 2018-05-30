package DSA.Tree.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        // Divide
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);


        //Conquer
        result.addAll(left);
        result.add(root.val);

        result.addAll(right);

        return result;
    }

    // iterative using stack, 中序遍历最重要，死记硬背，是的 三种顺序 实现并不太一样
    // stack实现也有好几种写法
    //这个一定要掌握
    // https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551
    public List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

}