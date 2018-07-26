package DSA.Tree.DistanceBetweenTwoNodes;

import DSA.Tree.TreeNode;

/*
 * 数两点间距离
 * Use the LCA, find the distance from LCA, use level order count
 * 
 * Follow up: BST
 * We have discussed distance between two nodes in binary tree. The time complexity of this solution is O(n)

In case of BST, we can find distance faster. We start from root and for every node, we do following.

If both keys are greater than current node, we move to right child of current node.
If both keys are smaller than current node, we move to left child of current node.
If one keys is smaller and other key is greater, current node is Lowest Common Ancestor (LCA) of two nodes. We find distances of current node from two keys and return sum of the distances.

 */
public class Solution {
    public int findDistance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = LCA(root, p, q);
        int dist1 = findDist(node, p, 0);
        int dist2 = findDist(node, q, 0);
        return dist1 + dist2;
    }
    
    private int findDist(TreeNode node, TreeNode q, int level) {
        // exist
        if (node == null) {
            return -1;
        }
        if (node == q) {
            return level;
        }
        int left = findDist(node.left, q, level + 1);
        int right = findDist(node.right, q, level + 1);
        return left != -1 ? left : right;
    }
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        // Method definition: 点在哪一边， 如果子树里两边都返回值，返回祖先， 有一个就返回一个，都没有就返回空
        // 后续遍历
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        // divide
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        // if find in both, mean root is the answer
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
