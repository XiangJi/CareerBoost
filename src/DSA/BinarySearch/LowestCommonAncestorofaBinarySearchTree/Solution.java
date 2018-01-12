package DSA.BinarySearch.LowestCommonAncestorofaBinarySearchTree;

import DSA.Tree.TreeNode;

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return root;
        }
        while ((root.val - A.val) * (root.val - B.val) > 0) {
            if (root.val > A.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
    
    // recursive version
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode A, TreeNode B) {
         if (root.val > A.val && root.val > B.val) {
             return lowestCommonAncestorII(root.left, A, B);
         } else if (root.val < A.val && root.val < B.val) {
             return lowestCommonAncestorII(root.right, A, B);
         } else {
             return root;
         }
     }
}