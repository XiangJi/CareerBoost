package DSA.Tree.BinaryTreeMaximumPathSum;

import DSA.Tree.TreeNode;

/*
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

Node can from any node to any node
Postorder traversel, use the childsum and decide if we should add the current val

A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. 
Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other 
nodes on the path.
A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update
 maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.


Post order

结合了DP的subarray sum
 */
class Solution {
    int max = Integer.MIN_VALUE; // here it must start from min
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    // return the max sum from this node down to some below point
    // 返回的常常和更新的不一样
    private int dfs(TreeNode cur) { 
        if (cur == null) {
            return 0;
        }
        int left = Math.max(dfs(cur.left), 0);
        int right = Math.max(dfs(cur.right), 0); // ? why with 0, because if the substree sum > 0, just add it
        
        max = Math.max(max, left + right + cur.val);
        return Math.max(left, right) + cur.val;
    }
}