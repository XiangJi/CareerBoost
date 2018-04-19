package DSA.BFS.AverageofLevelsinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DSA.Tree.TreeNode;

/*
 * iven a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

F tag
 */
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