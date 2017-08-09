package DSA.LinkedList.RotateList;

import DSA.LinkedList.ListNode;

public class Solution {
    private int getLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = getLength(head);
        k = k % length;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        head = dummy;

        for (int i = 0; i <  k; i++) {
            head = head.next;
        }

        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }

        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;

    }
}