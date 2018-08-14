package DSA.Tree.kthElementinaTree;

import DSA.Tree.TreeNode;

/*
 * kth element in a tree. 每个Node中包含有所有子节点的个数
 *
 * kth is for in-order
 *
 * 给定一个二叉树,每一个节点里记录了其下有多少个子节点，求第k个inorder position.
 *
 * 不是BST，就是普通的binary tree。这个find kth element call会调用多次。面试官的意思是，你一开始可以用O(n)时间遍历下树，给每个树加一个count变量，代表这个节点有多少个子节点。这样以后就可以用O（logn）的时间进行查询了。所有过程不算recursion的stack空间，其它都要求空间是O（1）的。所以不能中序遍历存到某个数组里，再查询。
 *
 *查询是logN的
 */
public class Solution {
    // Solution 1: just inorder and count, when kth, just return which is naive
    // T: o(N), S: O(h)
    int count;

    public TreeNode findkth(TreeNode root, int k) {
        TreeNode res = null;
        count = k;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode cur, TreeNode res) {
        if (cur == null) {
            return;
        }
        helper(cur.left, res);
        count--;
        if (count == 0) {
            res = cur;
        }
        helper(cur.right, res);
    }

    // Solution 2 , first inorder to count the sum of these left, then binary search in the BST
    int cnt;
    public TreeNode findkthInorder(TreeNode root, int k) {
        cnt = 0;
        helper2(root);
        TreeNode cur = root;
        // binary search in Tree
        while (cur != null) {
            if (cur.val == k) {
                return cur;
            } else if (cur.val < k) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }
    // inorder add count
    public void helper2(TreeNode cur) {
        if (cur == null) {
            return;
        }
        helper2(cur.left);
        cnt++;
        cur.val = count;
        helper2(cur.right);
    }

}
