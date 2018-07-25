package DSA.Tree.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * 确实有些题确实需要背诵 模板题目
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        // Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        
        //Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
    
    // iterative stack
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right); // 因为是根左右 所以右边先进去 这样可以后出
            if (cur.left != null) stack.push(cur.left); 
            res.add(cur.val);
        }
        return res;
    }
}
