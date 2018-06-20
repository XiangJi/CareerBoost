package DSA.Tree.FindModeinBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import DSA.Tree.TreeNode;

/*
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

算法就是中序遍历 用max 和 count更新 用list记录中间结果，注意 用成员遍历code会比较好看
 *
 */
class Solution {
    int max;
    Integer prev;
    int count;
    public int[] findMode(TreeNode root) {
        max = 0;
        count = 1;
        prev = null;

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public void dfs(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        // left
        dfs(cur.left, list);
        // op
        if (prev != null) {
            if (cur.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(cur.val);
        } else if (count == max) {
            list.add(cur.val);
        }
        prev = cur.val;
        // right
        dfs(cur.right, list);
    }
}