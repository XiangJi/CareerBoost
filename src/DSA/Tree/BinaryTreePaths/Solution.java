package DSA.Tree.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, String.valueOf(root.val), res); // we have to use String instead of stringbuilder, otherwise has to deal with backtracking, String is passed by value, so not issue
        return res;
        
    }
    
    private void dfs(TreeNode cur, String path, List<String> res) {
        // exsit condition
        if (cur == null) {
            return;
        }
        // preorder add
        if (cur.left == null && cur.right == null) {
            res.add(path);
            return;
        }
        // check two nodes
        if (cur.left != null) {
            dfs(cur.left, path + "->" + cur.left.val, res);
        }
        if (cur.right != null) {
            dfs(cur.right, path + "->" + cur.right.val, res);
        }
    }
}