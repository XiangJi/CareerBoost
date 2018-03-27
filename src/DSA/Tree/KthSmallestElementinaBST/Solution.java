package DSA.Tree.KthSmallestElementinaBST;

import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to
 find the kth smallest frequently? How would you optimize the kthSmallest routine?


inorder BST:recursive / iterative
 */
public class Solution {
    private int count;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 中序遍历 左根右
        dfs(root.left);
        // operations
        count--;
        if (count == 0) {
            result = root.val;
        }

        dfs(root.right);
    }

    // iterative
    public int kthSmallestII(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
  }

    // Divide and conquer
    public int kthSmallestIII(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
    // follow up: save the data in array
}
