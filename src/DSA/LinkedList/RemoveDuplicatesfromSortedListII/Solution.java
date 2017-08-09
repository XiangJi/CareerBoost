package DSA.LinkedList.RemoveDuplicatesfromSortedListII;

import DSA.LinkedList.ListNode;

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
                return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
                if (head.next.val == head.next.next.val) {
                        // do not know how many continuous dup nodes
                        int val = head.next.val;
                        while (head.next != null && head.next.val == val) {
                                head.next = head.next.next; // delete one
                        }
                } else {
                        head = head.next;
                }
        }
        return dummy.next;
    }
}