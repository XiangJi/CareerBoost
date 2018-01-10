package DSA.DFS.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // DFS, -- DC implenmetation, Recursive implementation, Stack implementation
        List<String> result = new ArrayList<String>();
        if (root == null) {
                return result;
        }
        dfs(root, String.valueOf(root.val), result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) {
                return;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            dfs(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null) {
            dfs(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}