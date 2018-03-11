package DSA.LinkedList.RemoveDuplicatesfromSortedListII;

import DSA.LinkedList.ListNode;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

 */

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy; // use prev pointer
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
            }
            
            if (prev.next != current) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
    
}