package DSA.LinkedList.RemoveDuplicatesfromSortedList;

import DSA.LinkedList.ListNode;

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
                return null; // corner case 一定要加，保持好习惯。这样程序不会down
        }

        ListNode node = head; // temp node
        while (node.next != null) {
                if (node.val == node.next.val) {
                        node.next = node.next.next; // delete
                } else {
                        node = node.next;
                }
        }
        return head;
    }
}