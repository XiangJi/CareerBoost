package DSA.Tree.PopulatingNextRightPointersinEachNode;

import DSA.Tree.TreeLinkNode;

/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 */
public class Solution {
    // dfs dc recursive 
    public void connect(TreeLinkNode root) {
        // exit
        if (root == null) {
            return;
        }
        // operation
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        // recursive
        connect(root.left);
        connect(root.right);

    }
    
    // iterative follow up use this, level order
    public void connectII(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode current = start;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                
                if (current.next != null && current.right != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            start = start.left;
        }
        
    }
}
