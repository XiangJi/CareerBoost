package DSA.LinkedList.RemoveLinkedListElements;

import DSA.LinkedList.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode previous = new ListNode(-1);
        previous = dummy;
        while (head != null) {
            if (head.val == val) {
                previous.next = head.next;
            } else {
                previous = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}