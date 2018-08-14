package DSA.Tree.CountUnivalueSubtrees;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
 *
 *符合条件的相同值的字数肯定是有叶节点的，而且叶节点也都相同(注意单独的一个叶节点也被看做是一个相同值子树)，
 *那么我们可以从下往上check，采用后序遍历的顺序，左右根，我们还是递归调用函数，对于当前遍历到的节点，如果对其左右子节点分
 *别递归调用函数，返回均为true的话，那么说明当前节点的值和左右子树的值都相同，那么又多了一棵树，所以结果自增1，然后返回当前节
 *点值和给定值(其父节点值)是否相同，从而回归上一层递归调用
 *
 */
class Solution {
    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    // post order 下面的值往上传
    // 返回是否符合univalue条件
    public boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}