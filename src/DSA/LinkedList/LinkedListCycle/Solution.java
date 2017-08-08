package DSA.LinkedList.LinkedListCycle;

import DSA.LinkedList.ListNode;

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
                return false;
        }

        ListNode fast, slow;
        slow = head;
        fast = head.next;

        // keep around on cycle linked list
        while (fast != slow) {
                if (fast == null || fast.next == null) {
                return false; // doesn't have cycle if to null
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}