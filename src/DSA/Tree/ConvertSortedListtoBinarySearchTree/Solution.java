package DSA.Tree.ConvertSortedListtoBinarySearchTree;

import DSA.LinkedList.ListNode;
import DSA.Tree.TreeNode;

// sorted linked list to BST
// T: O(N) S: O(N)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head, null);
    }
    
    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        return root;
        
    }
}