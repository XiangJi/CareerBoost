package DSA.BFS.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DSA.Tree.TreeNode;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>(); // queue是虚类在java里
            queue.offer(root);
            int levelNum = 1;

            // 关键的双重循环
            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    if (levelNum % 2 != 0) {
                        level.add(head.val);
                    } else {
                        level.add(0, head.val);
                    }
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
                levelNum++;
                result.add(level);
            }

            return result;
        }
}
