package DSA.BFS.BinaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

1. 保证列数从左到右，用hash表
2. 保证从上到下，用BFS
3. 都相同时从左到右，BFS已经保证
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root); 
        cols.add(0);

        int min = 0;
        int max = 0;
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left); 
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }
    
}
