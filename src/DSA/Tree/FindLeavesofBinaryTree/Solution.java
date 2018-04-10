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
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }

    private int height(TreeNode node,
            List<List<Integer>> res) {
        if (null == node)
            return -1;
        int level = 1 + Math.max(height(node.left, res),
                height(node.right, res));
        if (res.size() < level + 1)
            res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}