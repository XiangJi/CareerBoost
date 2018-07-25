package DSA.Tree.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DSA.Tree.TreeNode;

// 从右边看binary tree 看最右边的节点

// BFS, DFS
class Solution {

    // DFS
    public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res;

    }

    public void dfs(TreeNode current, List<Integer> res,
            int level) {
        // exsit
        if (current == null) {
            return;
        }

        // op, root, 注意调节
        if (level == res.size()) { 
            res.add(current.val);
        }
        // op right, then left、从右边一路加下去
        dfs(current.right, res, level + 1);
        dfs(current.left, res, level + 1);
    }

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    res.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return res;
    }
}
