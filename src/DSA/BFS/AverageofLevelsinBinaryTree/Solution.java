package DSA.BFS.AverageofLevelsinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DSA.Tree.TreeNode;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            double sum = 0;
            int n = queue.size(); // have to fix level queue fix here
            for (int i = 0; i < n; i++) {
                TreeNode head = queue.poll();
                sum += head.val;
                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(sum / n);
        }
        return result;
    }
}