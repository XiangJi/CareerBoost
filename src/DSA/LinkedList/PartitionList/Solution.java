package DSA.LinkedList.PartitionList;

import DSA.LinkedList.ListNode;

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
                return null;
        }

        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode leftPointer = leftDummy;
        ListNode rightPointer = rightDummy;

        while (head != null) {
                if (head.val < x) {
                        leftPointer.next = head; // copy the node to the tail
                        leftPointer = head; // move pointer to the newest
                } else {
                        rightPointer.next = head;
                        rightPointer = head;
                }
                head = head.next;
        }

        // link two dummy lists
        rightPointer.next = null;
        leftPointer.next = rightDummy.next;

        return leftDummy.next;
    }
}
