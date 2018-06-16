package DSA.Tree.BinaryTreePostOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DSA.Tree.TreeNode;

public class Solution {
    public List<Integer> postorderTraversalII(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>(); // trick linked list
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val); // trick
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }

}