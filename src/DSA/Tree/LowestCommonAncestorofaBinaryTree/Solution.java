package DSA.Tree.LowestCommonAncestorofaBinaryTree;

import DSA.Tree.TreeNode;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Algorithm

 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Method definition: 点在哪一边， 如果子树里两边都返回值，返回祖先， 有一个就返回一个，都没有就返回空
        // 后续遍历
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        // divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if find in both, mean root is the answer
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
