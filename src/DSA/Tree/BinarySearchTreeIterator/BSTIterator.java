package DSA.Tree.BinarySearchTreeIterator;

import java.util.Stack;

import DSA.Tree.TreeNode;

/*
 * mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

bst的inorder是升序的 所以直接dfs遍历即可，但是因为是iterator 就要用stack写法来实现

 */
public class BSTIterator {
    TreeNode current;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || current != null) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        int val = current.val;
        current  = current.right;
        
        return val;
    }
}