package DSA.DFS.BinaryTreePaths;
// 基础题 穷举树的所有路径
import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
                return result;
        }
        dfs(root, String.valueOf(root.val), result);
        return result;
    }
    // cursor, tmp, res
    private void dfs(TreeNode root, String path, List<String> result) {
        // exist
        if (root == null) {
                return;
        }
        // final level
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        // 只有两种选择 所以不用for循环，树的路径保证了不用backtracking
        // 要做的事情 树上就两种 条件执行即可
        if (root.left != null) {
            dfs(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null) {
            dfs(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}