package DSA.Tree.ConstructBinaryTreefromPreorderandInorderTraversal;

import DSA.Tree.TreeNode;

/*
 * The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it’s IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)

 /**
     *    3
         / \
        9  20
      /  \
     15   7
     inorder : 15 9 7 3 20
     preorder : 3 9 15 7 20
     time : O(n)
     space : O(n)

很少出现 但是很有意思
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    // we need a helper to store index args
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // exsit
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // find root node
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        // find it in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // 画图找到搜索位置
        root.left = helper(preStart + 1,                      inStart,     inIndex - 1, preorder, inorder);
        // inIndex - inStart 可以找到左边树的数量 加上在加一找到其实位置
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
