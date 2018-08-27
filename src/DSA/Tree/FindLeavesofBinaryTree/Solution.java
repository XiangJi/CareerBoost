package DSA.Tree.FindLeavesofBinaryTree;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

find height for each node, DFS, we can use hash to store height, but not necessary

post order, dfs with level count
从下往上面传height 这边的height是从下往上面数的
好题
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    // post order return the height from the end, 有点tricky
    private int height(TreeNode node,
            List<List<Integer>> res) {
        if (node == null)
            return -1; // return -1
        
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        
        // 给这层全加上
        if (level + 1 > res.size()) { // 用dfs来做level 就用res.size和level比
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        return level;
    }
}

// BF
class Solution2 {
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> leavesList = new ArrayList<List<Integer>>();
        List<Integer> leaves = new ArrayList<Integer>();

        while (root != null) {
            if (isLeave(root, leaves))
                root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<Integer>();
        }
        return leavesList;
    }

    public boolean isLeave(TreeNode node,
            List<Integer> leaves) {

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }

        if (node.left != null) {
            if (isLeave(node.left, leaves))
                node.left = null;
        }

        if (node.right != null) {
            if (isLeave(node.right, leaves))
                node.right = null;
        }

        return false;
    }
}